package com.solutions.guidedrecovery.ipmedt4;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.solutions.guidedrecovery.ipmedt4.models.TimeLineAdapter;
import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;



public class TrajectKeuze extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traject_keuze);

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        TimeLineAdapter adapter = new TimeLineAdapter(this, TimeLineModel.getObjectList());
        recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        recyclerview.setItemAnimator(new DefaultItemAnimator());



    }
}
