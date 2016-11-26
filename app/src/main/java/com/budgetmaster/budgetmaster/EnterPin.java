package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

        pin = getPinFromFile();

        //TODO::add similar check for security questions in case they exit the app during creation
        //If the user did not create a pin, send to create one and end this activity
        if(pin == -1) {
            forceCreatePin();
            finish();
        }
    }

    public void onClick(View v){
        if(v.getId() == R.id.logBtn){
            EditText pinIn = (EditText) findViewById(R.id.enterPin);
            String pinStr = pinIn.getText().toString();
            if (pinStr.length() == 4) {
                int pinInt = Integer.parseInt(pinStr);
                if (pin == pinInt) {
                    //Login
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("verified", true);
                    startActivity(intent);
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
        Intent intent = new Intent(this, CreatePin.class);
        startActivity(intent);
    }

}
