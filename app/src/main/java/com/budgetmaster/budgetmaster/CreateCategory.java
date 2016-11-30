package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/****************************************************************************************/
/*
/* FILE NAME: CreateCategory
/*
/* DESCRIPTION: Class for creating categories
/*
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/27/2016 Jason Williams                       Created the class
/* 11/27/2016 Grant Hardy                          Categories are now correctly added to the database
/*
/*
/****************************************************************************************/

public class CreateCategory extends AppCompatActivity{
    
    SQLiteDatabase db = null;
    Database budDB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        
        //Attempt to load database
        try {
            db = this.openOrCreateDatabase("budgetDB", MODE_PRIVATE, null);
        }
        catch(Exception e) {
            Log.e("BudgetDatabase ERROR", "Error Creating/Loading database");
        }
        budDB = new Database(db);
        budDB.createTables();
    }

    //Pulls data from text fields and creates a category, also adds to db
    public void addCategory(View view) {
        //Text fields
        TextInputEditText titleView = (TextInputEditText) findViewById(R.id.category_name);
        EditText amountView = (EditText) findViewById(R.id.category_amount);

        //Checking if text fields are both filled out
        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            //Trim whitespace, store as string/double, add to db
            String title = titleView.getText().toString().trim();
            double amount = Double.valueOf(amountView.getText().toString());

            try {
                budDB.addCategory(title, "expense", amount);
            }
            catch(Exception e) {
                Log.e("BudgetDatabase ERROR", "Category was not added to DB");
            }
            
            //Directed user back to the home page with a true verification to prevent reentering PIN
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("verified", true);
            Toast.makeText(this, title + " added", Toast.LENGTH_LONG).show();
            startActivity(intent);
            
            //Finish activity to prevent using back button to get back to it
            finish();
        }

    }
}
