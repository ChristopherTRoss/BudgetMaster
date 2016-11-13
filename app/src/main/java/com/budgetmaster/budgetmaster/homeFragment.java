package com.budgetmaster.budgetmaster;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by scine on 11/12/2016.
 */

public class HomeFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.home_fragment, container, false);
        TextView spendInc = (TextView) inflatedView.findViewById(R.id.spendable_income);
        spendInc.setText("$" + MainActivity.spendableInc);

        return inflatedView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
