package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by scine on 11/6/2016.
 */

public class CreateIncome extends AppCompatActivity{
    //Income to be saved when activity is finished
    private Income income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_income);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        EditText descView = (EditText) findViewById(R.id.income_description);
        EditText amountView = (EditText) findViewById(R.id.income_amount);

        String title = "";
        String description = "";
        float amount = 0;

        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            title = titleView.getText().toString().trim();
            description = descView.getText().toString().trim();
            amount = Float.valueOf(amountView.getText().toString());

            income = new Income(amount, description, title);
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
