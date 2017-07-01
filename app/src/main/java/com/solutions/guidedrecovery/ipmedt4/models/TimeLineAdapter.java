package com.solutions.guidedrecovery.ipmedt4.models;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.solutions.guidedrecovery.ipmedt4.GipsActivity;
import com.solutions.guidedrecovery.ipmedt4.LoopGipsActivity;
import com.solutions.guidedrecovery.ipmedt4.MainActivity;
import com.solutions.guidedrecovery.ipmedt4.R;

import java.util.List;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder>
{

    CheckBox cb;
    public static final String PREFS_NAME = "MyPreferencesFile";
    private List<TimeLineModel> actionList;
    TimeLineModel singleAction;
    String data;
    private int counter;
    private int percent;
    TextView mTextView;
    TextView mTextView2;
    ProgressBar mProgress;
    int progressStatus = 0;
    Handler handler = new Handler();
    Context context;


    //**----- constructor -----**//
    public TimeLineAdapter(List<TimeLineModel> actions, TextView hs, TextView timeLeft, ProgressBar prg)

    {
        this.actionList = actions;
        mTextView = hs;
        mProgress = prg;
        mTextView2 = timeLeft;
    }

    public TimeLineAdapter(){

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
                        intent =  new Intent(viewHolder.context2, GipsActivity.class);
                        break;
                    case 1:
                        intent =  new Intent(viewHolder.context2, LoopGipsActivity.class);
                        break;
                    default:
                        intent =  new Intent(viewHolder.context2, MainActivity.class);
                        break;
                }
                viewHolder.context2.startActivity(intent);
            }
        });


        viewHolder.chkSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

                counter = 0;
                cb = (CheckBox) buttonView;
                TimeLineModel touchPoint = (TimeLineModel) cb.getTag();
                touchPoint.setSelected(cb.isChecked());
                actionList.get(pos).setSelected(cb.isChecked());

                for (int i = 0; i < actionList.size(); i++)
                {
                    singleAction = actionList.get(i);

                    if (singleAction.isSelected()) {
                        counter++;
                    }

                    percent = (counter * 100) / actionList.size();

                    new Thread(new Runnable()
                    {
                        @Override
                        public void run()
                        {

                            if(isChecked){

                                for(progressStatus = progressStatus; progressStatus < Math.round(percent); progressStatus++)
                                {
                                    handler.post(new Runnable()
                                    {

                                        public void run()
                                        {
                                            mProgress.setProgress(progressStatus);
                                            mTextView.setText("Voortgang herstel: " + percent + "%");
                                            viewHolder.cv.setBackgroundColor(Color.parseColor("#3AB277"));
                                            viewHolder.tvTitle.setTextColor(Color.WHITE);
                                            viewHolder.tvDescription.setTextColor(Color.WHITE);
                                            viewHolder.chkSelected.setTextColor(Color.WHITE);
                                        }

                                    });
                                    try
                                    {
                                        Thread.sleep(100);
                                    }
                                    catch (InterruptedException e)
                                    {
                                        e.printStackTrace();
                                    }

                                }

                            }
                            else
                            {
                                for(progressStatus = progressStatus; progressStatus > Math.round(percent); progressStatus--)
                                {
                                    handler.post(new Runnable()
                                    {

                                        public void run()
                                        {
                                            mProgress.setProgress(progressStatus);
                                            mTextView.setText("Voortgang herstel: " + percent + "%");
                                            viewHolder.cv.setBackgroundColor(Color.parseColor("#ffffff"));
                                            viewHolder.tvTitle.setTextColor(Color.BLACK);
                                            viewHolder.tvDescription.setTextColor(Color.BLACK);
                                            viewHolder.chkSelected.setTextColor(Color.BLACK);
                                        }

                                    });
                                    try
                                    {
                                        Thread.sleep(100);
                                    }
                                    catch (InterruptedException e)
                                    {
                                        e.printStackTrace();
                                    }

                                }
                            }


                        }
                    }).start();

                    if(percent >= 0 && percent < 30)
                    {
                        mTextView2.setText("Nog ongeveer 6 weken te gaan");

                    }
                    else if(percent >= 30 && percent < 60)
                    {
                        mTextView2.setText("Nog ongeveer 5 weken te gaan");

                    }
                    if(percent >= 60 && percent < 80)
                    {
                        mTextView2.setText("Nog ongeveer 4 weken te gaan");

                    }
                    else if(percent >= 80 && percent < 100)
                    {
                        mTextView2.setText("Nog ongeveer 2 weken te gaan");

                    }
                    else if(percent == 100)
                    {
                        mTextView2.setText("Uw bot is hersteld.");

                    }

                }
            }


        });

    }

    //***----- Return the size arraylist -----***//
    @Override
    public int getItemCount()
    {
        return actionList.size();
    }

    //***----- Save info -----***//
    public void saveInfo(){
        SharedPreferences sharedpref = context.getSharedPreferences("info", 0);
        SharedPreferences.Editor editor  = sharedpref.edit();

        editor.putString("herstelStatus", mTextView.getText().toString());
        editor.apply();
    }


    //***----- Display info -----***//
    public void displayInfo(){
        SharedPreferences sharedpref = context.getSharedPreferences("info", 0);
        String herstelStatus = sharedpref.getString("herstelStatus", "");
        mTextView.setText(herstelStatus);
    }


    //***----- inner class ViewHolder -----***//
    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public final Context context2;
        public TextView tvTitle;
        public TextView tvDescription;
        public CheckBox chkSelected;
        public CardView cv;


        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);

            context2 = itemView.getContext();
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