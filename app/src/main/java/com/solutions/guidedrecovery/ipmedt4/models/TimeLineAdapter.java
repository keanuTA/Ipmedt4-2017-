/**
 *  Created by Dipak
 *  10-06-2017
 */

package com.solutions.guidedrecovery.ipmedt4.models;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.vipulasri.timelineview.TimelineView;
import com.solutions.guidedrecovery.ipmedt4.R;
import com.solutions.guidedrecovery.ipmedt4.TrajectKeuze;

import java.util.List;

import static android.R.attr.data;
import static com.solutions.guidedrecovery.ipmedt4.R.id.save;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder>
{
    CheckBox cb;
    public static final String PREFS_NAME = "MyPreferencesFile";
    private List<TimeLineModel> actionList;
    Context context;




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
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        final int pos = position;

        viewHolder.tvTitle.setText(actionList.get(position).getTitle());
        viewHolder.tvDescription.setText(actionList.get(position).getDescription());
        viewHolder.chkSelected.setChecked(actionList.get(position).isSelected());
        viewHolder.chkSelected.setTag(actionList.get(position));


        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("blabla", "blabla" + pos);
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

        public TextView tvTitle;
        public TextView tvDescription;
        public CheckBox chkSelected;
        public CardView cv;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);

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