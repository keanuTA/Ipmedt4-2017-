package com.solutions.guidedrecovery.ipmedt4;

/**
 * Created by keanuTA on 19-06-17.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter;
import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;

import static com.solutions.guidedrecovery.ipmedt4.models.TrajectStatus.INACTIVE;

public class TrajectKeuzeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<TimeLineModel> actionList = new ArrayList<>();
    TextView hs;
    TextView timeLeft;
    ProgressBar prg;
    SharedPreferences sharedpref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traject_keuze);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.icons_container), iconFont);

        hs = (TextView) findViewById(R.id.herstelStatus);
        timeLeft = (TextView) findViewById(R.id.geschatteTijd);
        prg = (ProgressBar) findViewById(R.id.progressBar);

//        String herstelStatus = sharedpref.getString("herstelStatus", "");
//        hs.setText(herstelStatus);

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

//    @Override
//    public  void onPause(){
//        super.onPause();
//
//            editor  = sharedpref.edit();
//            editor.putString("herstelStatus", hs.getText().toString());
//            editor.commit();
//
//
//    }


    // ***----- timeline data -----*** //
    public void getTimeLine()
    {
        ArrayList<String> acties = new ArrayList<String>();
        acties.add("Been laten gipsen");
        acties.add("Vervolgafspraak");
        acties.add("Loopgips");
        acties.add("Gips mag eraf");
        acties.add("Fysio");


        ArrayList<String> omschrijvingen = new ArrayList<String>();
        omschrijvingen.add("Fase 1");
        omschrijvingen.add("Fase 2");
        omschrijvingen.add("Fase 3");
        omschrijvingen.add("Fase 4");
        omschrijvingen.add("Fase 5");

        for(int i = 0; i < acties.size(); i++)
        {
            TimeLineModel timeline = new TimeLineModel(acties.get(i), omschrijvingen.get(i), false, INACTIVE);
            actionList.add(timeline);
        }
    }


}