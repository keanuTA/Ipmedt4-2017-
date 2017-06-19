package com.solutions.guidedrecovery.ipmedt4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by keanuTA on 19-06-17.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.Viewholder> {

    private ArrayList<String> mDataset;

    public MainAdapter(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public MainAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        // create a new view
        RecyclerView.ViewHolder vh = new Viewholder(v);
        return (Viewholder) vh;
    }

    @Override
    public void onBindViewHolder(MainAdapter.Viewholder holder, int position) {
        holder.mTitle.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView mTitle;

        public Viewholder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
