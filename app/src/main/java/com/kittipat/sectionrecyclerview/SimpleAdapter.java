package com.kittipat.sectionrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class SimpleAdapter extends StatelessSection {

    private ArrayList<String> arrName = new ArrayList<>();
    private String mTitle;

    public SimpleAdapter(ArrayList<String> arrName , String title) {
        super(R.layout.header, R.layout.item);
        this.arrName = arrName;
        this.mTitle = title;
    }

    @Override
    public int getContentItemsTotal() {
        return arrName.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.txtItem.setText(arrName.get(position));
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.txtHeader.setText(mTitle);
    }

    protected class HeaderViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtHeader;

        private HeaderViewHolder(View itemView) {
            super(itemView);
            txtHeader = (TextView) itemView.findViewById(R.id.txtHeader);
        }
    }

    protected class ItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtItem;

        private ItemViewHolder(View itemView) {
            super(itemView);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
        }
    }
}
