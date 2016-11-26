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

/**
 * Created by scine on 11/6/2016.
 */

public class CreateIncome extends AppCompatActivity{
    //Income to be saved when activity is finished
    private Income income;
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

            income = new Income(amount, description, title);

            Date date = new Date();
            budDB.addTransaction(title,amount,"income", date, "", false, "gas"); // todo: gas is a placeholder, implement a way to choose correct category later

            Toast.makeText(this, "Income added", Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            float spendableInc = extras.getFloat(MainActivity.SPENDABLE_INCOME);
            spendableInc += amount;
            SharedPreferences.Editor editer = getSharedPreferences(MainActivity.SPENDABLE_INCOME, MODE_PRIVATE).edit();
            editer.putFloat(MainActivity.SPENDABLE_INCOME, spendableInc);
            editer.commit();


            //todo Update database here with @amount, @description, @title
            //todo May consider importing the date class to log the time this occurred
            Intent returnHome = new Intent(this, MainActivity.class);
            returnHome.putExtra("verified", true);
            startActivity(returnHome);
            finish();
        }

    }
}
