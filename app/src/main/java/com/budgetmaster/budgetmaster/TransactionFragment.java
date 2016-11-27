package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

/****************************************************************************************/
/*
/* FILE NAME: TransactionFragment
/*
/* DESCRIPTION: The TransactionFragment class.
 */

/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========    =============    ===========       =============
/* 11/12/2016  Jason Williams   72CF: LE          Created the class.
/*
/*
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.transaction_fragment, container, false);

        //RecyclerView recList = (RecyclerView) inflatedView.findViewById(R.id.transactionList);
        //recList.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(inflatedView.getContext());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //recList.setLayoutManager(llm);

        //Todo load titles of transactions from DB, temp data now
        String[] transaction_titles = {"Transaction 1", "Transaction 2", "Transaction 3", "Transaction 4", "Transaction 5", "Transaction 6", "Transaction 7"};
        //Todo load dates of transactions from DB, temp data now
        String[] transaction_dates = {"Date 1", "Date 2", "Date 3", "Date 4", "Date 5", "Date 6", "Date 7"};
        //Todo load prices of transactions from DB, temp data now
        String[] transaction_prices = {"$###.##", "$###.##", "$###.##", "$###.##", "$###.##", "$###.##", "$###.##"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, transaction_titles);
        //setListAdapter(adapter);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TransactionRecyclerAdapter(transaction_titles, transaction_dates, transaction_prices);
        mRecyclerView.setAdapter(mAdapter);


        return inflatedView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
