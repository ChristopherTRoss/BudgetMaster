package com.budgetmaster.budgetmaster;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 11/26/2016.
 */

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.ViewHolder> {
    private Transaction[] transactions;

    public TransactionRecyclerAdapter(Transaction[] dataArgs) {
        transactions = dataArgs;
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
        holder.titleTextView.setText(transactions[position].getTitle());
        holder.dateTextView.setText(transactions[position].getDate());
        holder.priceTextView.setText("$"+transactions[position].getAmount());
        if (transactions[position].isExpense()) {
            holder.priceTextView.setTextColor(Color.parseColor("#DA4336"));
            System.out.println(transactions[position].getTitle() + " is expense");
        } else {
            holder.priceTextView.setTextColor(Color.parseColor("#3f8a43"));
            System.out.println(transactions[position].getTitle() + " is income");
        }
    }

    @Override
    public int getItemCount() {
        return transactions.length;
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
                    contextMenu.setHeaderTitle("Edit " + MainActivity.transactions[position].getTitle() + "?");
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
