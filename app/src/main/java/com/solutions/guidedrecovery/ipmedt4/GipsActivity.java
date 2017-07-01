package com.solutions.guidedrecovery.ipmedt4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.solutions.guidedrecovery.ipmedt4.models.Fase1ActieModel;
import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;

import java.util.ArrayList;
import java.util.List;

public class GipsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<Fase1ActieModel> mDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gips);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mAdapter = new MainAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    // ***----- timeline data -----*** //
    public void getTitleGipsActivity()
    {
        ArrayList<String> fase1Acties = new ArrayList<String>();
        fase1Acties.add("Afspraak met de gipsmeester");
        fase1Acties.add("Verdoving");
        fase1Acties.add("Ingipsen");
        fase1Acties.add("Rontgenfoto");
        fase1Acties.add("Krukken");

        ArrayList<String> fase1Omschrijvingen = new ArrayList<String>();
        fase1Omschrijvingen.add("Fase 1");
        fase1Omschrijvingen.add("Fase 2");
        fase1Omschrijvingen.add("Fase 3");
        fase1Omschrijvingen.add("Fase 4");
        fase1Omschrijvingen.add("Fase 5");


        for(int i = 0; i < fase1Acties.size(); i++)
        {
            Fase1ActieModel fase1Titles = new Fase1ActieModel(fase1Acties.get(i), fase1Omschrijvingen.get(i));
            mDataset.add(fase1Titles);
        }
    }


}



