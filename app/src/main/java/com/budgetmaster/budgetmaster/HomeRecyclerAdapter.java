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
    private Category[] categories;

    public HomeRecyclerAdapter(Category[] dataArgs) {
        categories = dataArgs;
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
        String[] categoryNames = new String[categories.length];
        for (int i = 0; i < categories.length; i++) {
            char[] charArray = categories[i].getTitle().toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            categoryNames[i] = new String(charArray);
        }
        holder.home_categoryTextView.setText(categoryNames[position]);
        holder.home_currentAmntsTextView.setText("$"+categories[position].getCurrentAmount());
        holder.home_totalAmntsTextView.setText("$"+categories[position].getTotalAmount());
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView home_categoryTextView;
        protected TextView home_currentAmntsTextView;
        protected TextView home_totalAmntsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            home_categoryTextView = (TextView) itemView.findViewById(R.id.category_text_home);
            home_currentAmntsTextView = (TextView) itemView.findViewById(R.id.current_price_text_home);
            home_totalAmntsTextView = (TextView) itemView.findViewById(R.id.total_price_text_home);

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
