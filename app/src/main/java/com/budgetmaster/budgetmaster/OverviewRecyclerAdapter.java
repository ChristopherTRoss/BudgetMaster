package com.budgetmaster.budgetmaster;

import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/****************************************************************************************/
/*
/* FILE NAME: OverviewRecyclerAdapter
/*
/* DESCRIPTION: The class for recycler adapter on overview fragment
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

public class OverviewRecyclerAdapter extends RecyclerView.Adapter<OverviewRecyclerAdapter.ViewHolder> {
    private Category[] overviewCategories;

    public OverviewRecyclerAdapter(Category[] dataArgs) {
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
        //capitalizes categories
        String[] categoryNames = new String[overviewCategories.length];
        for (int i = 0; i < overviewCategories.length; i++) {
            char[] charArray = overviewCategories[i].getTitle().toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            categoryNames[i] = new String(charArray);
        }
        holder.overview_categoryTextView.setText(categoryNames[position]);
        holder.overview_currAmntTextView.setText("$"+overviewCategories[position].getCurrentAmount());
        holder.overview_totalAmntTextView.setText("$"+overviewCategories[position].getTotalAmount());
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

            //allows longclicks on categories to open context menu (edit or delete)
            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    int position = getAdapterPosition();
                    contextMenu.setHeaderTitle("Edit " + MainActivity.categories[position].getTitle() + "?");
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
