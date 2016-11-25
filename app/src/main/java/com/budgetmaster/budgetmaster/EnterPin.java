package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPin extends AppCompatActivity {
    //Used to check if there is a pin
    SharedPreferences preferences;

    //Title of the private file for the pin
    private final String PINFILE = "PinAndQuestionsFile";

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

        EditText pinInput = (EditText) findViewById(R.id.enterPin);
        String pinStr = pinInput.getText().toString();
        int pinInt;
        //once pin is entered
        if (pinStr.length() == 4) {
            pinInt = Integer.parseInt(pinStr);
            if (pin == pinInt) {
                //Login
                //need to add extras isVerified
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("verified", true);
                startActivity(intent);
                finish();
            } else {
                //clear input and notify user of wrong pin
                pinInput.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Incorrect PIN", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private int getPinFromFile() {
        preferences = getSharedPreferences(PINFILE, MODE_PRIVATE);
        //Returns value at key "pin" if it exists, -1 if pin is not created
        return preferences.getInt("pin", -1);
    }

    private void forceCreatePin() {
        Intent intent = new Intent(this, CreatePin.class);
        startActivity(intent);
    }

}
