package com.solutions.guidedrecovery.ipmedt4.models;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.solutions.guidedrecovery.ipmedt4.GipsActivity;
import com.solutions.guidedrecovery.ipmedt4.LoopGipsActivity;
import com.solutions.guidedrecovery.ipmedt4.MainActivity;
import com.solutions.guidedrecovery.ipmedt4.R;

import java.util.List;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder>
{
    private Context context;
    CheckBox cb;
    public static final String PREFS_NAME = "MyPreferencesFile";
    private List<TimeLineModel> actionList;



    //**----- constructor -----**//
    public TimeLineAdapter(List<TimeLineModel> actions)

    {
        this.actionList = actions;
    }


    //***----- Create new views -----***//
    @Override
    public TimeLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }






    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position)
    {
        final int pos = position;
        viewHolder.tvTitle.setText(actionList.get(position).getTitle());
        viewHolder.tvDescription.setText(actionList.get(position).getDescription());
        viewHolder.chkSelected.setChecked(actionList.get(position).isSelected());
        viewHolder.chkSelected.setTag(actionList.get(position));
        viewHolder.cv.setTag(actionList.get(position));

        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent;
                switch (pos){
                    case 0:
                        intent =  new Intent(viewHolder.context, GipsActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(viewHolder.context, LoopGipsActivity.class);
                        break;
                    default:
                        intent =  new Intent(viewHolder.context, MainActivity.class);
                        break;
                }
                viewHolder.context.startActivity(intent);
            }
        });


        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                cb = (CheckBox) v;
                TimeLineModel touchPoint = (TimeLineModel) cb.getTag();

                touchPoint.setSelected(cb.isChecked());
                actionList.get(pos).setSelected(cb.isChecked());

            }

        });


    }

    //***----- Return the size arraylist -----***//
    @Override
    public int getItemCount()
    {
        return actionList.size();
    }


    //***----- inner class ViewHolder -----***//
    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public final Context context;
        public TextView tvTitle;
        public TextView tvDescription;
        public CheckBox chkSelected;
        public CardView cv;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);

            context = itemView.getContext();
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.text_timeline_title);
            tvDescription = (TextView) itemLayoutView.findViewById(R.id.text_timeline_date);
            chkSelected = (CheckBox) itemLayoutView.findViewById(R.id.checkBox2);
            cv = (CardView) itemLayoutView.findViewById(R.id.cardAction);

        }

    }

    //***----- method to access in activity after updating selection -----***//
    public List<TimeLineModel> getActionList()
    {
        return actionList;
    }

}