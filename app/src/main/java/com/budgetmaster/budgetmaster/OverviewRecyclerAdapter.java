package com.budgetmaster.budgetmaster;

import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 11/26/2016.
 */

public class OverviewRecyclerAdapter extends RecyclerView.Adapter<OverviewRecyclerAdapter.ViewHolder> {
    private String[] overviewCategories;

    public OverviewRecyclerAdapter(String[] dataArgs) {
        overviewCategories = dataArgs;
    }

    @Override
    public OverviewRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_overview_page, parent, false);

        OverviewRecyclerAdapter.ViewHolder viewHolder = new OverviewRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OverviewRecyclerAdapter.ViewHolder holder, int position) {
        holder.categoryTextView.setText(overviewCategories[position]);

    }

    @Override
    public int getItemCount() {
        return overviewCategories.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView categoryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryTextView = (TextView) itemView.findViewById(R.id.category_text_overview);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
