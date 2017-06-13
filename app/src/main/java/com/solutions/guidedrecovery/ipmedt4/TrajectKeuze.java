/**
 *  Created by Dipak
 *  10-06-2017
 */

package com.solutions.guidedrecovery.ipmedt4;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter;
import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;

import static com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter.PREFS_NAME;
import static com.solutions.guidedrecovery.ipmedt4.models.TrajectStatusActivity.INACTIVE;

public class TrajectKeuze extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<TimeLineModel> actionList = new ArrayList<>();
    public Button btnSelection;
    private int counter;
    private TextView hs;
    private int percent;
    TimeLineModel singleAction;
    String data;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traject_keuze);

        hs = (TextView) findViewById(R.id.herstelStatus);
        btnSelection = (Button) findViewById(R.id.save);

        //*** get all the data ***//
        getTimeLine();




        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /*** use this setting to improve performance if you know that changes
         in content do not change the layout size of the RecyclerView ***/
        mRecyclerView.setHasFixedSize(true);


        //*** use a linear layout manager ***//
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //*** create an Object for Adapter ***//
        mAdapter = new TimeLineAdapter(actionList);


        //*** set the adapter object to the Recyclerview ***//
        mRecyclerView.setAdapter(mAdapter);



        final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final SharedPreferences.Editor editor = settings.edit();
        hs.setText(settings.getString("hs", "0%"));



        btnSelection.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                data = "";


                for (int i = 0; i < actionList.size(); i++)
                {
                    singleAction = actionList.get(i);
                    if (singleAction.isSelected())
                    {
                        data = data + "\n" + singleAction.getTitle().toString();
                        editor.putBoolean("isChecked", singleAction.isSelected());

                    }

                    calculatePercentage();


                    Toast.makeText(TrajectKeuze.this, "U heeft de volgende fases afgerond: \n" + data, Toast.LENGTH_SHORT).show();
                    editor.putString("hs", hs.getText().toString());
                    editor.apply();

                }

            }

        });

    }

    @Override
    protected void onStop(){
        super.onStop();

    }

    // ***----- calculate progress in percentage -----***//
    public void calculatePercentage()
    {

        hs = (TextView) findViewById(R.id.herstelStatus);
        counter = 0;

        for (int j = 0; j < actionList.size(); j++)
        {

            if (actionList.get(j).isSelected())
            {
                counter++;
            }

            percent = (counter * 100) / actionList.size();
            hs.setText("U bent al " + percent + "% hersteld!");
        }
    }



    // ***----- timeline data -----*** //
    public void getTimeLine()
    {
        ArrayList<String> acties = new ArrayList<String>();
        acties.add("Gips om mijn been");
        acties.add("Loopgips");
        acties.add("Gip mag eraf");

        ArrayList<String> omschrijvingen = new ArrayList<String>();
        omschrijvingen.add("Na de diagnose van een dwarse botbreuk");
        omschrijvingen.add("1 week later");
        omschrijvingen.add("4 weken later");

        for(int i = 0; i < acties.size(); i++)
        {
            TimeLineModel timeline = new TimeLineModel((i+1) + ". " + acties.get(i), omschrijvingen.get(i), false, INACTIVE);
            actionList.add(timeline);
        }
    }

}