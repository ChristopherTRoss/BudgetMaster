package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ross Thompson on 11/25/2016.
 */

public class ForgotPIN extends AppCompatActivity {
    private String[] questions = new String[3];
    private String[] answers = new String[3];
    private int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pin);

        //Retrieve each question/answer string from preferences using keys and then store in arrays
        SharedPreferences preferences;
        for (int i = 1; i < 4; i++) {
            preferences = getSharedPreferences("SecurityQuestion" + i, MODE_PRIVATE);
            questions[i-1] = preferences.getString("SecurityQuestion" + i, "Error");
            preferences = getSharedPreferences("SecurityAnswer" + i, MODE_PRIVATE);
            answers[i-1] = preferences.getString("SecurityAnswer" + i, "Error");
        }

        //set text to show first question
        TextView question = (TextView)findViewById(R.id.question);
        question.setText(questions[0]);

        final Button button = (Button) findViewById(R.id.submitAns);
        button.setOnClickListener(new View.OnClickListener() {
            int index = 0;
            int numAttempts = 0;
            Toast toast;
            public void onClick(View v) {
                TextView answer = (TextView)findViewById(R.id.answer);
                //if text field matches stored answer
                numAttempts++;
                if (answer.getText().toString().equals(answers[index])) {
                    correct++;
                    //if 2nd correct answer, allow pin creation
                    if (correct == 2) {
                        if (toast != null)
                            toast.cancel();
                        toast = Toast.makeText(getApplicationContext(), "Success, make a new PIN", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), CreatePin.class);
                        intent.putExtra("remake", true);
                        startActivity(intent);
                        finish();
                    }
                    //else go to the next question
                    if (toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getApplicationContext(), "Correct, next question", Toast.LENGTH_SHORT);
                    toast.show();
                    numAttempts = 0;
                    index++;
                    TextView question = (TextView)findViewById(R.id.question);
                    question.setText(questions[index]);
                } else {
                    //if last attempt for current question
                    if (numAttempts == 3) {
                        numAttempts = 0;
                        //if last question, PIN change failed due to incorrect answers
                        if (index == 2) {
                            if (toast != null)
                                toast.cancel();
                            toast = Toast.makeText(getApplicationContext(), "Failed, returning to PIN screen", Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), EnterPin.class);
                            startActivity(intent);
                            finish();
                        } else {
                            //else go to next question
                            index++;
                            TextView question = (TextView)findViewById(R.id.question);
                            question.setText(questions[index]);
                            if (toast != null)
                                toast.cancel();
                            toast = Toast.makeText(getApplicationContext(), "No more attempts, try next question", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else {
                        //else increase numAttempts and repeat the same question
                        if (toast != null)
                            toast.cancel();
                        toast = Toast.makeText(getApplicationContext(), "Incorrect, " + (3-numAttempts) + " attempts remaining", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

    }
}
