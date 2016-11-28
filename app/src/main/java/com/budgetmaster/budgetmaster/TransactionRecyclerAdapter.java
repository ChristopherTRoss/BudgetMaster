package com.budgetmaster.budgetmaster;

import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.priceTextView.setText("$"+transactionPrices[position]);

    }

    @Override
    public int getItemCount() {
        return transactionTitles.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleTextView;
        protected TextView dateTextView;
        protected TextView priceTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.transaction_text);
            dateTextView = (TextView) itemView.findViewById(R.id.date_text);
            priceTextView = (TextView) itemView.findViewById(R.id.price_text);

            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    int position = getAdapterPosition();
                    contextMenu.setHeaderTitle("Edit " + MainActivity.transaction_titles[position] + "?");
                    contextMenu.add(0, 0, position, "Delete");
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
