package com.budgetmaster.budgetmaster;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 11/26/2016.
 */

public class OverviewRecyclerAdapter extends RecyclerView.Adapter<OverviewRecyclerAdapter.ViewHolder> {
    private String[] overviewCategories, currAmounts, totalAmounts;

    public OverviewRecyclerAdapter(String[] dataArgs1, String[] dataArgs2, String[] dataArgs3) {
        overviewCategories = dataArgs1;
        currAmounts = dataArgs2;
        totalAmounts = dataArgs3;
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
        for (int i = 0; i < overviewCategories.length; i++) {
            char[] stringArray = overviewCategories[i].toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            overviewCategories[i] = new String(stringArray);
        }
        holder.overview_categoryTextView.setText(overviewCategories[position]);
        holder.overview_currAmntTextView.setText("$"+currAmounts[position]);
        holder.overview_totalAmntTextView.setText("$"+totalAmounts[position]);
    }

    @Override
    public int getItemCount() {
        return overviewCategories.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView overview_categoryTextView;
        protected TextView overview_currAmntTextView;
        protected TextView overview_totalAmntTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            overview_categoryTextView = (TextView) itemView.findViewById(R.id.category_text_overview);
            overview_currAmntTextView = (TextView) itemView.findViewById(R.id.current_price_text_overview);
            overview_totalAmntTextView = (TextView) itemView.findViewById(R.id.total_price_text_overview);

            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    int position = getAdapterPosition();
                    contextMenu.setHeaderTitle("Edit " + MainActivity.categories[position] + "?");
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
