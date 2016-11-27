package com.budgetmaster.budgetmaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 11/26/2016.
 */

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.ViewHolder> {
    private String[] transactionTitles;
    private String[] transactionDates;
    private String[] transactionPrices;

    public TransactionRecyclerAdapter(String[] dataArgs) {
        transactionTitles = dataArgs;
    }

    public TransactionRecyclerAdapter(String[] dataArgs1, String[] dataArgs2, String[] dataArgs3) {
        transactionTitles = dataArgs1;
        transactionDates = dataArgs2;
        transactionPrices = dataArgs3;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transaction_page, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(transactionTitles[position]);
        holder.dateTextView.setText(transactionDates[position]);
        holder.priceTextView.setText(transactionPrices[position]);
    }

    @Override
    public int getItemCount() {
        return transactionTitles.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleTextView;
        protected TextView dateTextView;
        protected TextView priceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.transaction_text);
            dateTextView = (TextView) itemView.findViewById(R.id.date_text);
            priceTextView = (TextView) itemView.findViewById(R.id.price_text);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
