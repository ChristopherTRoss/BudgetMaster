package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by scine on 11/12/2016.
 */

public class TransactionFragment extends ListFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.transaction_fragment, container, false);

      ////Todo load titles of transactions from DB, temp data now
      //String[] transaction_titles = {"Transaction 1", "Transaction 2", "Transaction 3", "Transaction 4", "Transaction 5","Transaction 1", "Transaction 2", "Transaction 3", "Transaction 4", "Transaction 5","Transaction 1", "Transaction 2", "Transaction 3", "Transaction 4", "Transaction 5"};
      //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, transaction_titles);
      //setListAdapter(adapter);

        return inflatedView;
    }
}
