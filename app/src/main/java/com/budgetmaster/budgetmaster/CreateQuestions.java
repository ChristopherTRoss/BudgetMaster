package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/****************************************************************************************/
/*
/* FILE NAME: Main Activity
/*
/* DESCRIPTION: The page for creating the questions and answers to security questions.
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/24/2016   Ross Thompson                    Made the layout and set the button to store the
/*                                               values and go to the main page only if the fields
/*                                               are all non-empty, otherwise error message
/*
/*
/*
/****************************************************************************************/

public class CreateQuestions extends AppCompatActivity {

    private final String SECQ1 = "SecurityQuestion1";
    private final String SECQ2 = "SecurityQuestion2";
    private final String SECQ3 = "SecurityQuestion3";
    private final String SECA1 = "SecurityAnswer1";
    private final String SECA2 = "SecurityAnswer2";
    private final String SECA3 = "SecurityAnswer3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sec_questions);

        //Make the security question fields expand downward instead of horizontally
        //if the input is too large to fit on one line. Only the last 2 lines will be
        //displayed at once to maintain space
        TextView[] secqField = new TextView[6];
        secqField[0] = (TextView)findViewById(R.id.secq1);
        secqField[1] = (TextView)findViewById(R.id.secq2);
        secqField[2] = (TextView)findViewById(R.id.secq3);
        for(int i=0; i<3; i++) {
            secqField[i].setHorizontallyScrolling(false);
            secqField[i].setMaxLines(2);
        }

        final Button button = (Button) findViewById(R.id.secqBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get question/answer text values from layout then store values as strings
                EditText inputTxt = (EditText) findViewById(R.id.secq1);
                String secq1 = inputTxt.getText().toString();
                inputTxt = (EditText) findViewById(R.id.seca1);
                String seca1 = inputTxt.getText().toString();
                inputTxt = (EditText) findViewById(R.id.secq2);
                String secq2 = inputTxt.getText().toString();
                inputTxt = (EditText) findViewById(R.id.seca2);
                String seca2 = inputTxt.getText().toString();
                inputTxt = (EditText) findViewById(R.id.secq3);
                String secq3 = inputTxt.getText().toString();
                inputTxt = (EditText) findViewById(R.id.seca3);
                String seca3 = inputTxt.getText().toString();
                //if all fields entered
                if (!secq1.isEmpty() && !seca1.isEmpty() && !secq2.isEmpty() && !seca2.isEmpty() && !secq3.isEmpty() && !seca3.isEmpty()) {
                    //store questions and answers
                    //TODO:: make this use the database instead of preferences (maybe)
                    SharedPreferences.Editor secqEdit = getSharedPreferences(SECQ1, MODE_PRIVATE).edit();
                    secqEdit.putString(SECQ1, secq1);
                    secqEdit.commit();
                    secqEdit = getSharedPreferences(SECA1, MODE_PRIVATE).edit();
                    secqEdit.putString(SECA1, seca1);
                    secqEdit.commit();
                    secqEdit = getSharedPreferences(SECQ2, MODE_PRIVATE).edit();
                    secqEdit.putString(SECQ2, secq2);
                    secqEdit.commit();
                    secqEdit = getSharedPreferences(SECA2, MODE_PRIVATE).edit();
                    secqEdit.putString(SECA2, seca2);
                    secqEdit.commit();
                    secqEdit = getSharedPreferences(SECQ3, MODE_PRIVATE).edit();
                    secqEdit.putString(SECQ3, secq3);
                    secqEdit.commit();
                    secqEdit = getSharedPreferences(SECA3, MODE_PRIVATE).edit();
                    secqEdit.putString(SECA3, seca3);
                    secqEdit.commit();
                    //go to main page
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("verified", true);
                    startActivity(intent);
                    finish();
                } else {
                    //Display error message
                    Toast toast = Toast.makeText(getApplicationContext(), "Fields cannot be left blank", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}
