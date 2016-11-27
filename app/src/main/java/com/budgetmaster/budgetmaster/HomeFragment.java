package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        String[] home_categories = {"Food", "Gas", "Rent", "Miscellaneous", "Utilities"};
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeRecyclerAdapter(home_categories);
        mRecyclerView.setAdapter(mAdapter);

        return inflatedView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
