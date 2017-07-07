package com.solutions.guidedrecovery.ipmedt4.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solutions.guidedrecovery.ipmedt4.R;
import com.solutions.guidedrecovery.ipmedt4.models.FaseActieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipak on 7-7-2017.
 */

public class VervolgAfspraakAdapter extends RecyclerView.Adapter<VervolgAfspraakAdapter.Viewholder>{


    private List<FaseActieModel> infolijst;

    private ArrayList<String> mDataset;

    public VervolgAfspraakAdapter(List<FaseActieModel> listInfo) {
        this.infolijst = listInfo;
    }

    public VervolgAfspraakAdapter(){

    }


    @Override
    public VervolgAfspraakAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        // create a new view
        RecyclerView.ViewHolder vh = new VervolgAfspraakAdapter.Viewholder(v);
        return (VervolgAfspraakAdapter.Viewholder) vh;
    }

    @Override
    public void onBindViewHolder(VervolgAfspraakAdapter.Viewholder holder, int position) {
        holder.mTitle.setText(infolijst.get(position).getTitle());
        holder.mInfo.setText(infolijst.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return infolijst.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mInfo;

        public Viewholder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mInfo = (TextView) itemView.findViewById(R.id.descriptionInfo);
        }
    }


}
