package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPin extends AppCompatActivity {
    //Used to check if there is a pin
    SharedPreferences preferences;

    //Title of the private file for the pin
    public final String PINFILE = "PinFile";

    private int pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

        pin = getPinFromFile();

        //If the user did not create a pin, send to create one and end this activity
        if(pin == -1) {
            forceCreatePin();
            finish();
        }
        if (checkSecQuestions().equals("")) {
            Intent intent = new Intent(this, CreateQuestions.class);
            startActivity(intent);
            finish();
        }

        Button logBtn = (Button)findViewById(R.id.logBtn);
        Button forgotBtn = (Button)findViewById(R.id.forgotPin);
    }

    public void onClick(View v){
        if(v.getId() == R.id.logBtn){
            EditText pinIn = (EditText) findViewById(R.id.enterPin);
            String pinStr = pinIn.getText().toString();
            if (pinStr.length() == 4) {
                int pinInt = Integer.parseInt(pinStr);
                if (pin == pinInt) {
                    //Login
                    Intent mainPage = new Intent(EnterPin.this, MainActivity.class);
                    mainPage.putExtra("verified", true);
                    startActivity(mainPage);
                    finish();
                } else {
                    //clear input and notify user of wrong pin
                    pinIn.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "Incorrect PIN", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                pinIn.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "PIN must be 4 characters", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else if(v.getId() == R.id.forgotPin){
            Intent intent = new Intent(getApplicationContext(), ForgotPIN.class);
            startActivity(intent);
            finish();
        }

    }

    private int getPinFromFile() {
        preferences = getSharedPreferences(PINFILE, MODE_PRIVATE);
        //Returns value at key "pin" if it exists, -1 if pin is not created
        return preferences.getInt(PINFILE, -1);
    }

    private void forceCreatePin() {
        Intent intent = new Intent(getApplicationContext(), CreatePin.class);
        startActivity(intent);
    }

    //Makes sure sec questions were created, only need to check 1 because
    //sec question creation doesnt allow leaving the page without filling all fields.
    //Mainly to handle the case where user exits app during question creation
    private String checkSecQuestions() {
        preferences = getSharedPreferences("SecurityQuestion1", MODE_PRIVATE);
        return preferences.getString("SecurityQuestion1", "");
    }

}
