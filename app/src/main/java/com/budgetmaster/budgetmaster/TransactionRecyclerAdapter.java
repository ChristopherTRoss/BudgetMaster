package com.budgetmaster.budgetmaster;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/****************************************************************************************/
/*
/* FILE NAME: TransactionRecyclerAdapter
/*
/* DESCRIPTION: The class for recycler adapter on transaction fragment
/*
/*
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========    =============    ===========       =============
/* 11/26/2016  Adrian Colon                       Created the class and implemented recycler adapter
/* 11/27/2016  Ross Thompson                      Updated object structure
/*
/****************************************************************************************/


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
        holder.priceTextView.setText(String.format("$%.2f", transactions[position].getAmount()));
        //updates color of text depending on type of transaction (expense or income)
        if (transactions[position].getType().equals("expense"))
            holder.priceTextView.setTextColor(Color.parseColor("#DA4336"));
        else
            holder.priceTextView.setTextColor(Color.parseColor("#3f8a43"));
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

            //allows longclicks on transactions to open context menu (edit or delete)
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
