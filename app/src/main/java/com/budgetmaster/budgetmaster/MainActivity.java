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
    SQLiteDatabase contactsDB = null;
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

        //Create or Open the Budget Database
        //Create Tables User, Budget, Category, Transaction, Security Question with the allotted fields.
     // try{
     //     contactsDB = this.openOrCreateDatabase("BudgetDataBase", MODE_PRIVATE, null);

     //     contactsDB.execSQL("CREATE TABLE IF NOT EXISTS User " + "(userID integer primary key, pin integer, Status boolean, lastLogin date");
     //     contactsDB.execSQL("CREATE TABLE IF NOT EXISTS Budget " + ("budgetID integer primary key, netMoney double, UserID foreign key"));
     //     contactsDB.execSQL("CREATE TABLE IF NOT EXISTS Category " + ("catID integer primary key, name varchar(30), type varchar(10), maxAmount double, curAmountSpent double, BudgetID integer foreign key"));
     //     contactsDB.execSQL("CREATE TABLE IF NOT EXISTS Transaction " + ("tranID integer primary key, price double, type varchar(10), date Date, description varchar(50), recurring boolean, budgetID integer foreign key, categoryID integer foreign key"));
     //     contactsDB.execSQL("CREATE TABLE IF NOT EXISTS Security Question " + ("SQID integer primary key, question varchar(75), answer varchar(75), userID integer foreign key"));




     //     //Creates default user, with userID 1
     //     Date date = new Date();
     //     int pin = 0000;
     //     contactsDB.execSQL("INSERT INTO User (userID, pin, status, lastLogin) VALUES ('"+ 1 + "', '" + pin + "', '" + false + "', '" + date + "');");




     //     //Create Master Budget with budgetID 1
     //     contactsDB.execSQL("INSERT INTO Budget (budgetID, netMoney, UserID) VALUES ('" + 1 + "', '"+ 0 + "', '" + 1 + "');");



     //     //Create default Categories
     //     contactsDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Gas', '"
     //     + false + "', '" + 100.00 + "', '"+ 0 + "', '"+ 1 + "');");
     //     contactsDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Rent', '"
     //             + false + "', '" + 600.00 + "', '"+ 0 + "', '"+ 1 + "');");
     //     contactsDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Utilities', '"
     //             + false + "', '" + 200.00 + "', '"+ 0 + "', '"+ 1 + "');");
     //     contactsDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Food', '"
     //             + false + "', '" + 300.00 + "', '"+ 0 + "', '"+ 1 + "');");
     //     contactsDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Miscellaneous', '"
     //             + false + "', '" + 100.00 + "', '"+ 0 + "', '"+ 1 + "');");




     //     //Enter in a Transaction
     //     //Adds the Transaction into a category budget and master budget with id 1.
     //     //In order to get the correct cat id, we query for the catID by searching for the one that matches
     //     //             the Category named entered i.e. Gas or Rent...
     //     String cat = "Gas"; //Just using gas as an example for whatever category the transaction falls under
     //     Expense buffaloWildWings = new Expense(15.00, "Buffalo Wild Wings", "Ate them tasty wings");
     //     Cursor cursor = contactsDB.rawQuery("SELECT catID, recurring, type FROM Category WHERE name = " + cat, null);
     //     int catID = cursor.getInt(cursor.getColumnIndex("catID"));
     //     int budgetID = cursor.getInt(cursor.getColumnIndex("budgetID"));
     //     date = new Date();
     //     double price = buffaloWildWings.getAmount();
     //     //Categorical Budget
     //     contactsDB.execSQL("INSERT INTO Transaction (price,type, date, description, recurring, budgetID, catID) VALUES" +
     //             "('"+ price + "', '" + false + "', '" + date + "', "+ buffaloWildWings.getDescription() +", '" +false + "', '"+ budgetID+ "', '"
     //             + catID + "');");
     //     //Master Budget
     //     contactsDB.execSQL("INSERT INTO Transaction (type, date, description, recurring, budgetID, catID) VALUES" +
     //             "('"+ price + "', '" + false + "', '" + date + "', "+ buffaloWildWings.getDescription() +", '" +false + "', '"+ 1 + "', '"
     //             + catID + "');");
     //     //We need to update the Budgets with the new price
     //     //In order to do this, we obtain the current net amount of each the master and category budget
     //     //Then determine whether the transaction was an income or expense, and update accordingly
     //     cursor = contactsDB.rawQuery("SELECT netMoney FROM Budget WHERE budgetID = 1", null);
     //     double netMoneyMaster = cursor.getDouble(cursor.getColumnIndex("netMoney"));
     //     cursor = contactsDB.rawQuery("SELECT netMoney FROM Budget WHERE budgetID = "+catID, null);
     //     double netMoneyCategory = cursor.getDouble(cursor.getColumnIndex("netMoney"));
     //     if(buffaloWildWings.isIncome()) {
     //         netMoneyMaster += price;
     //         netMoneyCategory += price;
     //         contactsDB.execSQL("UPDATE Budget SET netMoney = " + netMoneyMaster + " WHERE budgetID = 1");
     //         contactsDB.execSQL("UPDATE Budget SET netMoney = " + netMoneyCategory + " WHERE budgetID = "+catID);
     //     }
     //     else {
     //         netMoneyMaster -= price;
     //         netMoneyCategory -= price;
     //         contactsDB.execSQL("UPDATE Budget SET netMoney = " + netMoneyMaster + " WHERE budgetID = 1");
     //         contactsDB.execSQL("UPDATE Budget SET netMoney = " + netMoneyCategory + " WHERE budgetID = "+catID);
     //     }




     // }
     // catch(Exception e)
     // {
     //     Log.e("CONTACTS ERROR", "Error Creating/Loading database");
     // }
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
        //contactsDB.close();
        super.onDestroy();
    }


}

//Here I am going to write code for different possible database entries and queries so that we can implement them at the correct spots later.
