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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter;
import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;

import org.w3c.dom.Text;

import static com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter.PREFS_NAME;
import static com.solutions.guidedrecovery.ipmedt4.models.TrajectStatusActivity.INACTIVE;

public class TrajectKeuze extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<TimeLineModel> actionList = new ArrayList<>();
    TextView hs;
    TextView timeLeft;
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traject_keuze);
        hs = (TextView) findViewById(R.id.herstelStatus);
        timeLeft = (TextView) findViewById(R.id.geschatteTijd);
        prg = (ProgressBar) findViewById(R.id.progressBar);

        //*** get all the data ***//
        getTimeLine();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /*** use this setting to improve performance if you know that changes
         in content do not change the layout size of the RecyclerView ***/
        mRecyclerView.setHasFixedSize(true);


        //*** use a linear layout manager ***//
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //*** create an Object for Adapter ***//
        mAdapter = new TimeLineAdapter(actionList, hs, timeLeft, prg);


        //*** set the adapter object to the Recyclerview ***//
        mRecyclerView.setAdapter(mAdapter);

    }




    // ***----- timeline data -----*** //
    public void getTimeLine()
    {
        ArrayList<String> acties = new ArrayList<String>();
        acties.add("Gips om mijn been");
        acties.add("Loopgips");
        acties.add("Gip mag eraf");
        acties.add("Gips om mijn been");
        acties.add("Loopgips");
        acties.add("Gip mag eraf");

        ArrayList<String> omschrijvingen = new ArrayList<String>();
        omschrijvingen.add("Na de diagnose van een dwarse botbreuk");
        omschrijvingen.add("1 week later");
        omschrijvingen.add("4 weken later");
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