package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/17/2016  Jason Williams       CI1                Created income class
/* 11/18/2016  Jason Williams       CI2               Made it to where incomes are being stored and shown on main screen (Minus DB)
/* 11/26/2016  Grant Hardy          CI3               Added database functionality to the class so that when incomes are made
/*                                                       they are stored in the database.
 */
/*
/*
/****************************************************************************************/

public class CreateIncome extends AppCompatActivity{
    SQLiteDatabase db = null;
    Database budDB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_income);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            db = this.openOrCreateDatabase("budgetDB", MODE_PRIVATE, null);
            System.out.println("Success!!!!!!!");

        }
        catch(Exception e)
        {
            System.out.println("It got caught....");
            Log.e("BudgetDatabase ERROR", "Error Creating/Loading database");
        }
        budDB = new Database(db);
        budDB.createTables();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_income_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_accept) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Saves data inputted in text fields of create_income Activity
     * @param item
     */
    public void saveIncome(MenuItem item) {
        EditText titleView = (EditText) findViewById(R.id.income_title);
        EditText amountView = (EditText) findViewById(R.id.income_amount);

        String title = "";
        String description = "";
        float amount = 0;

        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            title = titleView.getText().toString().trim();
            amount = Float.valueOf(amountView.getText().toString());
            Date date = new Date();
            try{
                budDB.addTransaction(title,amount,"income", date, "", false, "income"); // todo: gas is a placeholder, implement a way to choose correct category later
            }
            catch(Exception e)
            {
                System.out.println("It got caught....");
                Log.e("BudgetDatabase ERROR", "Transaction was not added");
            }

            //Notify user the income was added
            Toast.makeText(this, "Income added", Toast.LENGTH_LONG).show();

            //Get application context and retrieve spendable income
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            float spendableInc = extras.getFloat(MainActivity.SPENDABLE_INCOME);

            //Updated spendable income and save changes
            spendableInc += amount;
            SharedPreferences.Editor editor = getSharedPreferences(MainActivity.SPENDABLE_INCOME, MODE_PRIVATE).edit();
            editor.putFloat(MainActivity.SPENDABLE_INCOME, spendableInc);
            editor.commit();


            //todo Update database here with @amount, @description, @title
            //todo May consider importing the date class to log the time this occurred
            //Create intent to navigated home, pass verified as true to prevent re-entering pin
            Intent returnHome = new Intent(this, MainActivity.class);
            returnHome.putExtra("verified", true);
            startActivity(returnHome);
            finish();
        }

    }
}
