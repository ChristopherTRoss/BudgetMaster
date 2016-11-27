package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by scine on 11/12/2016.
 */

public class OverviewFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.overview_fragment, container, false);

        //Todo load categories of transactions from DB, temp data now
        String[] overview_categories = {"Gas", "Miscellaneous", "Rent", "Utilities", "Food"};
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OverviewRecyclerAdapter(overview_categories);
        mRecyclerView.setAdapter(mAdapter);

        return inflatedView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
