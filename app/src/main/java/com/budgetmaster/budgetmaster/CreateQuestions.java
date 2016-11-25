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

    private final String QUESTIONSFILE = "QuestionsFile";

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
                    SharedPreferences.Editor secqEdit = getSharedPreferences(QUESTIONSFILE, MODE_PRIVATE).edit();
                    secqEdit.putString(QUESTIONSFILE, secq1);
                    secqEdit.putString(QUESTIONSFILE, seca1);
                    secqEdit.putString(QUESTIONSFILE, secq2);
                    secqEdit.putString(QUESTIONSFILE, seca2);
                    secqEdit.putString(QUESTIONSFILE, secq3);
                    secqEdit.putString(QUESTIONSFILE, seca3);
                    secqEdit.commit();
                    //go to main page
                    Intent mainPageIntent = new Intent(getApplicationContext(), MainActivity.class);
                    mainPageIntent.putExtra("verified", true);
                    startActivity(mainPageIntent);
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
