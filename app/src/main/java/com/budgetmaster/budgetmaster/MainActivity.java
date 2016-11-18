package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.util.Date;

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
    private String[] tempList = {"Home", "Transaction Log"};
    SQLiteDatabase db  = null;
    public static final String SPENDABLE_INCOME = "SPENDABLE_INCOME";
    public static float spendableInc;
    TextView spendableIncText;
    private ListView log_list_view;
    private ArrayAdapter log_list_adapter;
    String[] tmpLog = {"Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43","Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43","Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43" };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     //We create the db in the main class
     try {
         db = this.openOrCreateDatabase("BudgetDataBase", MODE_PRIVATE, null);
     }
     catch(Exception e)
     {
         Log.e("CONTACTS ERROR", "Error Creating/Loading database");
     }
        Database budDB = new Database(db);
        budDB.createTables();


        spendableInc = loadSpendableInc();
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        trans.add(R.id.frag_container, homeFragment, "home").commit();


        //Navigation menu
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frag_container);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getFragmentManager();
            final FragmentTransaction transaction = manager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.action_home:
                    final HomeFragment homeFragment = new HomeFragment();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
     */
    @Override
    protected void onDestroy(){
        db.close();
        super.onDestroy();
    }


}


