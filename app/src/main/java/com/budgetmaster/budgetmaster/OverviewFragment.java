package com.budgetmaster.budgetmaster;

import android.app.Fragment;
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

import static android.content.Context.MODE_PRIVATE;


/****************************************************************************************/
/*
/* FILE NAME: OverviewFragment
/*
/* DESCRIPTION: The OverviewFragment class
/*
/*
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========    =============    ===========       =============
/* 11/12/2016  Jason Williams                     Created the class.
/* 11/26/2016  Adrian Colon                       Implemented recycler view
/* 11/27/2016  Ross Thompson                      Hide transaction sorting menu (spinner) if on this fragment
/* 11/27/2016  Grant Hardy                        Implemented sorting algorithm for overview
/* 11/27/2016  Ross Thompson                      Fixed issue with sorting algorithm
/*
/****************************************************************************************/

public class OverviewFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    SQLiteDatabase db = null;
    Database budDB = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.overview_fragment, container, false);

        //Todo load categories of transactions from DB, temp data now
        Category[] overview_categories = MainActivity.categories;
        sortCatsByNearestCompletion(overview_categories);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OverviewRecyclerAdapter(overview_categories);
        mRecyclerView.setAdapter(mAdapter);

        return inflatedView;
    }

    //These 2 methods hide the sort menu when on this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    //see above comment
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.sortSpinner).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int clickedItemPosition = item.getOrder();
        deleteCategoryFromDB(clickedItemPosition);
        return super.onContextItemSelected(item);
    }

    //Todo load db and remove
    private void deleteCategoryFromDB(int position){
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
        String name = MainActivity.categories[position].getTitle();
        try {
            budDB.removeCategory(name);
        }
        catch(Exception e) {
            Log.e("BudgetDatabase ERROR", "Transaction was not deleted");
        }


    }

    private Category [] sortCatsByNearestCompletion(Category[] unsorted)
    {
        int size = unsorted.length;
        int i, j;
        Category temp;
        for(i = 0; i< size; i++) {
            for (j = 1; j < size - i; j++) {
                if (getPercentofAmountAlloted(unsorted[j-1]) < getPercentofAmountAlloted(unsorted[j])) {
                    temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
        return unsorted;
    }

    private double getPercentofAmountAlloted(Category cat)
    {
        double curAmount = cat.getCurrentAmount();
        double amountAlloted = cat.getTotalAmount();
        return curAmount/amountAlloted;
    }

}
