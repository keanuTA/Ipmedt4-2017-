package com.solutions.guidedrecovery.ipmedt4.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.solutions.guidedrecovery.ipmedt4.R;
import com.solutions.guidedrecovery.ipmedt4.adapters.MainAdapter;
import com.solutions.guidedrecovery.ipmedt4.models.FaseActieModel;

import java.util.ArrayList;
import java.util.List;

public class VervolgAfspraakActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> mDataset;
    private List<FaseActieModel> infoList;
    Button back;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vervolg_afspraak);
        back = (Button) findViewById(R.id.btnBack);
        context = this.getBaseContext();
        ArrayList<String> infoTitle = new ArrayList<String>();
        infoTitle.add("Vervanging gips");
        infoTitle.add("röntgenfoto’s");


        ArrayList<String> infoDescription = new ArrayList<String>();
        infoDescription.add("Tijdens deze afspraak zal het gips dat u de afgelopen 1 a 2 weken heeft gebruikt vervangen worden. Allereerst zal u naar de gipskamer gaan en zal het huidige gips verwijderd worden.\n\n" +
                "Hierna zal het loopgips worden aangebracht. Het loopgips wordt, in tegenstelling tot het uw oude gips, al na 30 minuten hard. U zal dan ook aanwezig moeten blijven en wachten tot het is uitgehard.\n\n" +
                "Eventueel krijgt u de optie om weer wat te oefenen met dit gips aangezien u met dit gips wat meer druk mag uitoefenen op uw been en u zal waarschijnlijk ook uw krukken niet meer nodig hebben.");
        infoDescription.add("Let op: Er worden eventueel röntgenfoto’s gemaakt om herstel te controleren indien u klachten heeft ondervonden in de tussenperiode." +
                "De gipsspalk wordt aangebracht om de zojuist terug gezette botdelen op hun plaats te houden.\n\n" +
                "Het gips wordt aangebracht aan uw been.\n\n" +
                "Er wordt een röntgenfoto gemaakt om te controleren of alles goed op zijn plaats zit.\n\n" +
                "Als het gips goed aangebracht is en het bot op de goede plek zit bent u hier klaar. Mocht dit niet het geval zijn moet het gips opnieuw aangebracht worden en een nieuwe röntgenfoto gemaakt worden.\n\n" +
                "Let op: het ontvangen gips is soms pas na 48 uur hard dus wees extra voorzichtig met dit gips gedurende de eerste 2 dagen.");


        infoList = new ArrayList<>();

        for (int i = 0; i < infoTitle.size(); i++) {
            FaseActieModel infoModel = new FaseActieModel(infoTitle.get(i), infoDescription.get(i));
            infoList.add(infoModel);
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(infoList);
        mRecyclerView.setAdapter(mAdapter);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TrajectKeuzeActivity.class);
                startActivity(intent);
            }
        });
    }
}