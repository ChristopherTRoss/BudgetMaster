package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/****************************************************************************************/
/*
/* FILE NAME: EnterPin
/*
/* DESCRIPTION: The login page
/*
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/20/2016 Jason Williams                  Created class and force pin creation if no existing pin
/* 11/23/2016 Ross Thompson                     Added login UI and functionality
/* 11/24/2016 Ross Thompson                      Changed login to happen on pressing enter rather than using a button
/* 11/25/2016 Ross Thompson                     Went back to using a button to eliminate a bug
/* 11/26/2016 Ross Thompson                     Fixed a bug that caused user to have to login after creating PIN/questions
/* 11/27/2016 Ross Thompson                     Re-implemented the feature where user can log in 2 different ways, either
/*                                              pressing enter or clicking the button
/*
/****************************************************************************************/

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
            return;
        }
        if (checkSecQuestions().equals("")) {
            Intent intent = new Intent(this, CreateQuestions.class);
            startActivity(intent);
            finish();
            return;
        }

        Button logBtn = (Button)findViewById(R.id.logBtn);
        Button forgotBtn = (Button)findViewById(R.id.forgotPin);

        listenForEnter();
    }

    public void listenForEnter() {
        //if enter is pressed logs in with same functionality as button press
        EditText pinInput = (EditText) findViewById(R.id.enterPin);
        pinInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView pinIn, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
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
                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View v){
        if(v.getId() == R.id.logBtn){
            EditText pinIn = (EditText) findViewById(R.id.enterPin);
            String pinStr = pinIn.getText().toString();
            Toast toast = null;
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
                    //cancel existing toast if there is one for a faster transition to the new toast
                    if (toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Incorrect PIN", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                pinIn.setText("");
                //cancel existing toast if there is one for a faster transition to the new toast
                if (toast != null)
                    toast.cancel();
                toast = Toast.makeText(getApplicationContext(), "PIN must be 4 characters", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else if(v.getId() == R.id.forgotPin){
            Intent intent = new Intent(getApplicationContext(), ForgotPIN.class);
            startActivity(intent);
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
