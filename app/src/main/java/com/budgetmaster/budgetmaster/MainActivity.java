package com.budgetmaster.budgetmaster;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.Calendar;

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
/*
/*
/*
/****************************************************************************************/

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db  = null;
    //Key for the shared preference file
    public static final String SPENDABLE_INCOME = "SPENDABLE_INCOME";
    //Total income, static because fragments need access
    public static float spendableInc;
    private boolean isVerified;

    //Used to calculate how long user is idle
    private double idleStart, idleFinish;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle getVerified = getIntent().getExtras();
        //Todo: when user confirms pin, pass extra in the intent with key "verified" and boolean value True
        //This code checks if isVerified is false, or if the activity has just been created, and forces user to enter pin if either are true
      //try{
      //    isVerified = getVerified.getBoolean("verified");
      //    if(!isVerified)
      //        forceEnterPin();
      //} catch (Exception e) {
      //    forceEnterPin();
      //}

     //We create the db in the main class
     try {
         db = this.openOrCreateDatabase("BudgetDataBase", MODE_PRIVATE, null);
         Database budDB = new Database(db);
         budDB.createTables();
     }
     catch(Exception e)
     {
         Log.e("BudgetDatabase ERROR", "Error Creating/Loading database");
     }


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 // public static void saveInqList(Context context, ArrayList<Inquiry> inqList) {
 //     SharedPreferences mPrefs = context.getSharedPreferences("INQUIRYLIST", context.MODE_PRIVATE);
 //     SharedPreferences.Editor prefsEditor = mPrefs.edit();
 //     Gson gson = new Gson();
 //     String json = gson.toJson(inqList);
 //     prefsEditor.putString("JsonInqList", json);
 //     prefsEditor.commit();
 // }


   //public static ArrayList<Inquiry> loadSharedPrefInquiryList(Context context) {
   //    ArrayList<Inquiry> inqList= new ArrayList<Inquiry>();
   //    SharedPreferences mPrefs = context.getSharedPreferences("INQUIRYLIST", context.MODE_PRIVATE);
   //    Gson gson = new Gson();
   //    String json = mPrefs.getString("JsonInqList", "");
   //    if(json.isEmpty()) {
   //        inqList = new ArrayList<Inquiry>();
   //    } else {
   //        Type type = new TypeToken<ArrayList<Inquiry>>(){}.getType();
   //        inqList = gson.fromJson(json, type);
   //    }
   //    return inqList;
   //}

    public void saveSpendableInc(float amt) {
        SharedPreferences.Editor editer = getSharedPreferences(SPENDABLE_INCOME, MODE_PRIVATE).edit();
        editer.putFloat(SPENDABLE_INCOME, amt);
        editer.commit();
    }

    private float loadSpendableInc() {
        SharedPreferences prefs = getSharedPreferences(SPENDABLE_INCOME, MODE_PRIVATE);
        return prefs.getFloat(SPENDABLE_INCOME, MODE_PRIVATE);
    }

    public void createIncome(View view) {
        Intent intent = new Intent(this, CreateIncome.class);
        intent.putExtra(SPENDABLE_INCOME, spendableInc);
        startActivity(intent);
    }

    public void createExpense(View view) {
        Intent intent = new Intent(this, CreateExpense.class);
        intent.putExtra(SPENDABLE_INCOME, spendableInc);
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
        isVerified = false;
        idleStart = 0;
        idleFinish = 0;
    }

    //Forces user to create pin and ends the main activity so the user can't use the back button to get to home screen
    private void forceEnterPin() {
        isVerified = false;
        Intent intent = new Intent(this, EnterPin.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Calendar tmpCalendar = Calendar.getInstance();
        idleStart = tmpCalendar.get(Calendar.MINUTE);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Calendar tmpCalendar = Calendar.getInstance();

        //If app went straight to stop phase, start at 0
        //If app started at pause and then went to stop, add time from before
        if(idleStart == 0)
            idleStart = tmpCalendar.get(Calendar.MINUTE);
        else
            idleStart += tmpCalendar.get(Calendar.MINUTE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Use calendar object to get the current time in minutes
        Calendar tmpCalendar = Calendar.getInstance();
        idleFinish = tmpCalendar.get(Calendar.MINUTE);
        if(idleFinish - idleStart >= 30)
            forceEnterPin();

        //Reset idle times because user started app again
        idleStart = 0;
        idleFinish = 0;
    }
}


