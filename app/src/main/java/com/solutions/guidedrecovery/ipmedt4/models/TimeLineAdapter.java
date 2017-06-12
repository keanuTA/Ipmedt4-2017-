/**
 *  Created by Dipak
 *  10-06-2017
 */

package com.solutions.guidedrecovery.ipmedt4.models;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.vipulasri.timelineview.TimelineView;
import com.solutions.guidedrecovery.ipmedt4.R;
import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder>
{

    private List<TimeLineModel> actionList;

    public TimeLineAdapter(List<TimeLineModel> actions)
    {
        this.actionList = actions;

    }

    // Create new views
    @Override
    public TimeLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {

        final int pos = position;

        viewHolder.tvName.setText(actionList.get(position).getTitle());
        viewHolder.tvEmailId.setText(actionList.get(position).getDescription());
        viewHolder.chkSelected.setChecked(actionList.get(position).isSelected());
        viewHolder.chkSelected.setTag(actionList.get(position));

        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                CheckBox cb = (CheckBox) v;
                TimeLineModel contact = (TimeLineModel) cb.getTag();

                contact.setSelected(cb.isChecked());
                actionList.get(pos).setSelected(cb.isChecked());
            }
        });

    }

    // Return the size arraylist
    @Override
    public int getItemCount()
    {
        return actionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView tvName;
        public TextView tvEmailId;
        public CheckBox chkSelected;


        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);

            tvName = (TextView) itemLayoutView.findViewById(R.id.text_timeline_title);
            tvEmailId = (TextView) itemLayoutView.findViewById(R.id.text_timeline_date);
            chkSelected = (CheckBox) itemLayoutView.findViewById(R.id.checkBox2);

        }

    }

    // method to access in activity after updating selection
    public List<TimeLineModel> getActionList()
    {
        return actionList;
    }

}