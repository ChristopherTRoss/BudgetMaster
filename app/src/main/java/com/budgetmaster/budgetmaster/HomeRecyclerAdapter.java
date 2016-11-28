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

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private String[] homeCategories;

    public HomeRecyclerAdapter(String[] dataArgs) {
        homeCategories = dataArgs;
    }

    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_page, parent, false);

        HomeRecyclerAdapter.ViewHolder viewHolder = new HomeRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.ViewHolder holder, int position) {
        for (int i = 0; i < homeCategories.length; i++) {
            char[] stringArray = homeCategories[i].toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            homeCategories[i] = new String(stringArray);
        }
        holder.home_categoryTextView.setText(homeCategories[position]);
    }

    @Override
    public int getItemCount() {
        return homeCategories.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView home_categoryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            home_categoryTextView = (TextView) itemView.findViewById(R.id.category_text_home);

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
