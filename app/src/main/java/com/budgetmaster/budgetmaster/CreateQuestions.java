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
/* FILE NAME: CreateQuestions
/*
/* DESCRIPTION: The page for creating the questions and answers to security questions.
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/24/2016 Ross Thompson                    Implemented PIN creation, only saves questions
/*                                               and advances to main page if fields are all non-empty
/* 11/24/2016 Ross Thompson                     Made the formatting of fields show long inputs better (2 lines at a time)
/* 11/25/2016 Ross Thompson                      Fixed bug where only last question was storing
/* 11/26/2016 Ross Thompson                     Added ability to edit security questions
/*
/****************************************************************************************/

public class CreateQuestions extends AppCompatActivity {

    private final String SECQ1 = "SecurityQuestion1";
    private final String SECQ2 = "SecurityQuestion2";
    private final String SECQ3 = "SecurityQuestion3";
    private final String SECA1 = "SecurityAnswer1";
    private final String SECA2 = "SecurityAnswer2";
    private final String SECA3 = "SecurityAnswer3";

    SharedPreferences preferences;

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

        //if existing questions, then user wants to edit rather than create new questions so fill
        //fields with current data first
        if (!checkSecQuestions().equals("")) {
            String existingData;
            secqField[3] = (TextView)findViewById(R.id.seca1);
            secqField[4] = (TextView)findViewById(R.id.seca2);
            secqField[5] = (TextView)findViewById(R.id.seca3);
            for (int i = 1; i < 4; i++) {
                preferences = getSharedPreferences("SecurityQuestion" + i, MODE_PRIVATE);
                existingData = preferences.getString("SecurityQuestion" + i, "");
                secqField[i-1].setText(existingData);
            }
            for (int i = 1; i < 4; i++) {
                preferences = getSharedPreferences("SecurityAnswer" + i, MODE_PRIVATE);
                existingData = preferences.getString("SecurityAnswer" + i, "");
                secqField[i+2].setText(existingData);
            }
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

    private String checkSecQuestions() {
        preferences = getSharedPreferences("SecurityQuestion1", MODE_PRIVATE);
        return preferences.getString("SecurityQuestion1", "");
    }

}
