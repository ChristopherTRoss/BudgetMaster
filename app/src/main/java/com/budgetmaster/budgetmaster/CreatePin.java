package com.budgetmaster.budgetmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePin extends AppCompatActivity {

    public final String PINFILE = "PinFile";
    private int pin = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pin);

        final Button button = (Button) findViewById(R.id.conBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText pinInput = (EditText) findViewById(R.id.pinCreation);
                EditText confirmInput = (EditText) findViewById(R.id.pinConfirm);
                String pinStr = pinInput.getText().toString();
                String confStr = confirmInput.getText().toString();
                //if passwords match
                if(pinStr.length() == 4 && confStr.length() == 4) {
                    if (pinStr.equals(confStr)) {
                        //store pin
                        pin = Integer.parseInt(pinStr);
                        SharedPreferences.Editor pinEdit = getSharedPreferences(PINFILE, MODE_PRIVATE).edit();
                        pinEdit.putInt(PINFILE, pin);
                        pinEdit.commit();
                        //if remake is true, PIN was just reset, dont create new questions
                        if (getIntent().getBooleanExtra("remake", false)) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("verified", true);
                            startActivity(intent);
                            finish();
                        } else {
                            //create new security questions
                            Intent intent = new Intent(getApplicationContext(), CreateQuestions.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        //clear text boxes and display that passwords do not match
                        pinInput.setText("");
                        confirmInput.setText("");
                        Toast toast = Toast.makeText(getApplicationContext(), "PINs must match", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    pinInput.setText("");
                    confirmInput.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "PIN must be 4 characters", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
