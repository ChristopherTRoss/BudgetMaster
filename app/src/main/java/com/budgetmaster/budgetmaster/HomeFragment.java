package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
/* 11/27/2016  Ross Thompson                      Hide sorting menu (spinner) if on this fragment
/*
/*
/****************************************************************************************/

/**
 * Created by scine on 11/12/2016.
 */

public class HomeFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.home_fragment, container, false);
        TextView spendInc = (TextView) inflatedView.findViewById(R.id.spendable_income);
        spendInc.setText(String.format("$%.2f", (double) MainActivity.spendableInc));

        //Todo load categories of transactions from DB, temp data now
        String[] home_categories = MainActivity.categories;
        String[] home_currAmounts = MainActivity.categoryCurrentAmounts;
        String[] home_totalAmounts = MainActivity.categoryTotalAmounts;
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeRecyclerAdapter(home_categories);
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

    }
}
