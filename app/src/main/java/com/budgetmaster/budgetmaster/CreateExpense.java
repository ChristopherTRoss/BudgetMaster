package com.budgetmaster.budgetmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class CreateExpense extends AppCompatActivity {
    //Expense to be saved when activity is finished
    private Expense expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates menu at top, uses same menu as income
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
        EditText titleView = (EditText) findViewById(R.id.expense_title);
        EditText descView = (EditText) findViewById(R.id.expense_description);
        EditText amountView = (EditText) findViewById(R.id.expense_amount);

        String title = "";
        String description = "";
        float amount = 0;

        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            //Get values and add them to an Expense object
            title = titleView.getText().toString().trim();
            description = descView.getText().toString().trim();
            amount = Float.valueOf(amountView.getText().toString());
            expense = new Expense(amount, title, description);

            //Load values passed to this Activity through the intent object
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            //Load spendable income, edit it, and commit changes
            float spendableInc = extras.getFloat(MainActivity.SPENDABLE_INCOME);
            spendableInc -= amount;
            SharedPreferences.Editor editer = getSharedPreferences(MainActivity.SPENDABLE_INCOME, MODE_PRIVATE).edit();
            editer.putFloat(MainActivity.SPENDABLE_INCOME, spendableInc);
            editer.commit();

            //Notify user the changes have been made
            Toast.makeText(this, "Expense added", Toast.LENGTH_LONG).show();

            //todo Update database here with @amount, @description, @title
            //todo May consider importing the date class to log the time this occurred
            Intent returnHome = new Intent(this, MainActivity.class);
            returnHome.putExtra("verified", true);
            startActivity(returnHome);
        }

    }
}
