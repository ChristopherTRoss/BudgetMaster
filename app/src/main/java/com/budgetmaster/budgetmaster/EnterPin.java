package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        //If the user did not create a pin, send to to create one and end this activity
        if(pin == -1) {
            forceCreatePin();
            finish();
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
