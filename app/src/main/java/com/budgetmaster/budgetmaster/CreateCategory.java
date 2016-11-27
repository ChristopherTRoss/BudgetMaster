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


public class CreateCategory extends AppCompatActivity{

    SQLiteDatabase db = null;
    Database budDB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        try {
            db = this.openOrCreateDatabase("budgetDB", MODE_PRIVATE, null);
        }
        catch(Exception e)
        {
            System.out.println("It got caught....");
            Log.e("BudgetDatabase ERROR", "Error Creating/Loading database");
        }
        budDB = new Database(db);
        budDB.createTables();
    }

    public void addCategory(View view) {
        TextInputEditText titleView = (TextInputEditText) findViewById(R.id.category_name);
        EditText amountView = (EditText) findViewById(R.id.category_amount);

        if(titleView.getText().toString().trim().length() == 0 || amountView.getText().toString().trim().length() == 0)
            Toast.makeText(this, "Please fill out every field", Toast.LENGTH_LONG).show();
        else {
            String title = titleView.getText().toString().trim();
            double amount = Double.valueOf(amountView.getText().toString());

            try {
                budDB.addCategory(title, "expense", amount);
            }
            catch(Exception e) {
                Log.e("BudgetDatabase ERROR", "Category was not added to DB");
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("verified", true);
            Toast.makeText(this, title + " added", Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }

    }
}
