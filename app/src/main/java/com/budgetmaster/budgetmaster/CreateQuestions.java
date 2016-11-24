package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ross Thompson on 11/24/2016.
 */

public class CreateQuestions extends AppCompatActivity {

    private final String PINFILE = "PinAndQuestionsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sec_questions);

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
                    SharedPreferences.Editor secqEdit = getSharedPreferences(PINFILE, MODE_PRIVATE).edit();
                    secqEdit.putString(PINFILE, secq1);
                    secqEdit.putString(PINFILE, seca1);
                    secqEdit.putString(PINFILE, secq2);
                    secqEdit.putString(PINFILE, seca2);
                    secqEdit.putString(PINFILE, secq3);
                    secqEdit.putString(PINFILE, seca3);
                    secqEdit.commit();
                    //go to main page
                    Intent mainPageIntent = new Intent(getApplicationContext(), MainActivity.class);
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
