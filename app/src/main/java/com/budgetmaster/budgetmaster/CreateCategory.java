package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CreateCategory extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
    }

    public void addCategory(View view) {
        TextInputEditText titleView = (TextInputEditText) findViewById(R.id.category_name);
        EditText amountView = (EditText) findViewById(R.id.category_amount);

        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            String title = titleView.getText().toString().trim();
            double amount = Double.valueOf(amountView.getText().toString());

            //todo add to DB
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
