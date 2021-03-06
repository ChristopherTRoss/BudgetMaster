package com.budgetmaster.budgetmaster;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


/****************************************************************************************/
/*
/* FILE NAME: Main Activity
/*
/* DESCRIPTION: The homepage of the app that allows users to add incomes and
/#   expenses.  It also is will create and hold the sqllite database
 */
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/6/2014   Jason Williams   72CF: LS           Created the class, started on basic UI
/* 11/7/2016  Grant Hardy      72CF: LE           Started to add the database functionality
/* 11/12/2016  Jason Williams                      Added bottom navigation menu
/* 11/13/2016  Jason Williams                      Creating expense/incomes now works and updates balance
/* 11/18/2016  Grant Hardy                         Database updates
/* 11/25/2016  Ross Thompson                       Added manual logout
/* 11/26/2016  Ross Thompson                       Added security question editing
/* 11/27/2016  Ross Thompson                       Updated OO structure
/* 11/27/2016  Jason Williams                      Fixed rounding errors
/****************************************************************************************/

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db  = null;
    //Key for the shared preference file
    public static final String SPENDABLE_INCOME = "SPENDABLE_INCOME";
    //Total income, static because fragments need access
    public static float spendableInc;

    //Create static arrays that can be publicly accessed by the fragments
    public static String[] categoryStrings;
    public static Transaction[] transactions;
    public static Category[] categories;
    private boolean isVerified;
    Database budDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Auto-generated code for activity to load toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        //get verified key from intent activity was started with, set false if key not found
        isVerified = getIntent().getBooleanExtra("verified", false);
        if (!isVerified)
            forceEnterPin();



     //We create the db in the main class
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

        //Load categories and transactions
        loadDB();

        //Loading variables, settings the first fragment to the home screen
        spendableInc = loadSpendableInc();
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        trans.add(R.id.frag_container, homeFragment, "home").commit();


        //Settings functionality for the bottom navigation bar
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frag_container);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getFragmentManager();
            final FragmentTransaction transaction = manager.beginTransaction();
            //Handling clicks on home, transaction, or overview
            switch (item.getItemId()) {
                case R.id.action_home:
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.frag_container, homeFragment, "home").commit();
                    break;
                case R.id.action_transactions:
                    TransactionFragment transactionFragment = new TransactionFragment();
                    transaction.replace(R.id.frag_container, transactionFragment, "transaction").commit();
                    break;
                case R.id.action_overview:
                    OverviewFragment overviewFragment = new OverviewFragment();
                    transaction.replace(R.id.frag_container, overviewFragment, "overview").commit();
                    break;
            }
            return false;
        }
    });

    }

    /**
     * Auto-generated method for toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Auto-generated method for toolbar
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.editSec) {
            Intent intent = new Intent(getApplicationContext(), CreateQuestions.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            forceEnterPin();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
        
    //Loads the spendable income to display in the HomeFragment
    private float loadSpendableInc() {
        SharedPreferences prefs = getSharedPreferences(SPENDABLE_INCOME, MODE_PRIVATE);
        return prefs.getFloat(SPENDABLE_INCOME, MODE_PRIVATE);
    }

    //Directes user to createIncome activity with spendable income extra
    public void createIncome(View view) {
        Intent intent = new Intent(this, CreateIncome.class);
        intent.putExtra(SPENDABLE_INCOME, spendableInc);
        startActivity(intent);
    }

    //Directs user to createIncome activity with spendable income and the list of categories
    public void createExpense(View view) {
        Intent intent = new Intent(this, CreateExpense.class);
        Bundle extras = new Bundle();
        //Store data in a bundle and pass to intent
        extras.putFloat(SPENDABLE_INCOME, spendableInc);
        extras.putStringArray("categories", categoryStrings);
        intent.putExtras(extras);
        startActivity(intent);
    }

    /**
     * Closes the database when the application is terminated
     * Set verified to false to force
     */
    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.close();
        getIntent().putExtra("verified", false);
    }

    //Forces user to create pin and ends the main activity so the user can't use the back button to get to home screen
    private void forceEnterPin() {
        getIntent().putExtra("verified", false);
        Intent intent = new Intent(getApplicationContext(), EnterPin.class);
        startActivity(intent);
        finish();
    }

    //Method that is called when user comes from a pause or stop
    @Override
    protected void onResume(){
        super.onResume();
        loadDB();
    }

    /**
     * Updates the transaction data
     */
    public void loadDB() {
        transactions = budDB.getAllTransactions();
        categories = budDB.getCategories();
        categoryStrings = budDB.getCategoryNames();
    }

    //Directs user to createCategory activity
    public void createCategory(View view) {
        Intent intent = new Intent(this, CreateCategory.class);
        startActivity(intent);
    }
}


