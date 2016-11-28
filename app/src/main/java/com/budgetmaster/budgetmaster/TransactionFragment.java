package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static android.content.Context.MODE_PRIVATE;

/****************************************************************************************/
/*
/* FILE NAME: TransactionFragment
/*
/* DESCRIPTION: The TransactionFragment class.
/*
/*
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========    =============    ===========       =============
/* 11/12/2016  Jason Williams   72CF: LE          Created the class.
/* 11/26/2016  Adrian Colon                       Implemented recycler view
/* 11/27/2016  Ross Thompson                      Added spinner menu functionality for selecting
/*                                                sorting methods from menu
/*
/*
/****************************************************************************************/


/**
 * Created by scine on 11/12/2016.
 */

public class TransactionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    SQLiteDatabase db = null;
    Database budDB = null;
    Transaction[] transactions = MainActivity.transactions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflatedView = inflater.inflate(R.layout.transaction_fragment, container, false);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, transaction_titles);
        //setListAdapter(adapter);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TransactionRecyclerAdapter(transactions);
        mRecyclerView.setAdapter(mAdapter);
        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.sortSpinner).setVisible(true);
        super.onPrepareOptionsMenu(menu);
        //populates the spinner menu
        MenuItem item = menu.findItem(R.id.sortSpinner);
        Spinner spinner = (Spinner)item.getActionView();
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sorting_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    //Assign new values to arrays
                    sortByDate();
                    mAdapter.notifyDataSetChanged();
                } else if (pos == 1) {
                    //assign new values to arrays
                    sortByAmount();
                    mAdapter.notifyDataSetChanged();
                }
            }
            //Mandatory method, dont need so leaving empty
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void sortByAmount()
    {
        int size = transactions.length;

        int i;
        int j;
        for(i = 0; i<size; i++)
        {
            for(j = 1; j<size-i;j++)
            {
                if(transactions[j-1].getAmount() < transactions[j].getAmount())
                {
                    Transaction temp = transactions[j-1];
                    transactions[j-1] = transactions[j];
                    transactions[j] = temp;
                }
            }
        }
    }

    public void sortByDate()
    {
        //sort by dates
        ArrayList<Transaction> dateSort = new ArrayList<Transaction>(Arrays.asList(transactions));
        Collections.sort(dateSort, new Comparator<Transaction>() {
            DateFormat f = new SimpleDateFormat("MMM dd yyyy");
            @Override
            public int compare(Transaction o1, Transaction o2) {
                try {
                    return f.parse(o1.getDate()).compareTo(f.parse(o2.getDate()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        //convert arraylist to array
        transactions = dateSort.toArray(transactions);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int clickedItemPosition = item.getOrder();
        deleteTransactionFromDB(clickedItemPosition);
        return super.onContextItemSelected(item);
    }

    //Todo load db and remove
    private void deleteTransactionFromDB(int position)
    {
        try {
            db = getActivity().openOrCreateDatabase("budgetDB", MODE_PRIVATE, null);
        }
        catch(Exception e)
        {
            System.out.println("It got caught....");
            Log.e("BudgetDatabase ERROR", "Error Creating/Loading database");
        }
        budDB = new Database(db);
        budDB.createTables();
        String name = MainActivity.transactions[position].getTitle();
        try {
            budDB.removeTransaction(name);
        }
        catch(Exception e) {
            Log.e("BudgetDatabase ERROR", "Transaction was not deleted");
        }
        refreshTransactions();
        mAdapter.notifyItemRemoved(position);
    }

    private void refreshTransactions() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        Bundle extras = new Bundle();
        extras.putBoolean("verified", true);
        extras.putBoolean("loadTransaction", true);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
