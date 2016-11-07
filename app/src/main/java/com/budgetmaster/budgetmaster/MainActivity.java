package com.budgetmaster.budgetmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] tempList = {"Home", "Transaction Log"};
    private float spendableInc;

    private ListView log_list_view;
    private ArrayAdapter log_list_adapter;
    String[] tmpLog = {"Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43","Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43","Buffalo Wild Wings: -$13.23", "Paycheck: +$323.11", "Overwatch: -$43.54", "Birthday Money: -$20.00", "Groceries: -$78.98", "Textbooks: -$325.67", "Video Card: -$205.43" };
    private final String SPENDABLE_INCOME = "SPENDABLE_INCOME";

    private TextView spend_inc_text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        log_list_view = (ListView) findViewById(R.id.log_list_view);
        log_list_adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tmpLog);log_list_view.setAdapter(log_list_adapter);
        spendableInc = loadSpendableInc();
        spend_inc_text_view = (TextView) findViewById(R.id.spend_inc_text_view);
        spend_inc_text_view.setText("$"+Float.toString(spendableInc));

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

    private void saveSpendableInc() {
        SharedPreferences.Editor editer = getSharedPreferences(SPENDABLE_INCOME, MODE_PRIVATE).edit();
        editer.putFloat("SPENDABLE_INCOME", spendableInc);
        editer.commit();
    }

    private float loadSpendableInc() {
        SharedPreferences prefs = getSharedPreferences(SPENDABLE_INCOME, MODE_PRIVATE);
        return prefs.getFloat(SPENDABLE_INCOME, MODE_PRIVATE);
    }

    public void createIncome(View view) {
        Intent intent = new Intent(this, CreateIncome.class);
        startActivity(intent);
    }

    public void createExpense(View view) {
        Intent intent = new Intent(this, CreateExpense.class);
        startActivity(intent);
    }
}
