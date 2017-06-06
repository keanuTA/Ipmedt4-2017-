package com.solutions.guidedrecovery.ipmedt4.models;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solutions.guidedrecovery.ipmedt4.R;

import java.util.List;

/**
 * Created by Dipak on 5-6-2017.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.MyViewHolder> {

    private List<TimeLineModel> objectList;
    private LayoutInflater inflater;

    public TimeLineAdapter(Context context, List<TimeLineModel> objectList){
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_timeline, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        TimeLineModel current = objectList.get(position);
        holder.setData(current, position);

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView title, description;
        private int position;
        private TimeLineModel currentObject;

        public MyViewHolder(View itemView){
            super(itemView);
            title = (AppCompatTextView) itemView.findViewById(R.id.text_timeline_title);
            description = (AppCompatTextView) itemView.findViewById(R.id.text_timeline_date);
        }

        public void setData(TimeLineModel currentObject, int position) {

            this.title.setText(currentObject.getTitle());
            this.description.setText(currentObject.getDescription());
            this.position = position;
            this.currentObject = currentObject;

        }
    }

}
