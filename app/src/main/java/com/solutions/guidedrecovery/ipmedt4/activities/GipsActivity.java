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

public class GipsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_gips);
        back = (Button) findViewById(R.id.btnBack);
        context = this.getBaseContext();
        ArrayList<String> infoTitle = new ArrayList<String>();
        infoTitle.add("Verdoving");
        infoTitle.add("Behandeling");
        infoTitle.add("Gebruik van krukken");
        infoTitle.add("Medicatie");



        ArrayList<String> infoDescription = new ArrayList<String>();
        infoDescription.add("Ten eerste zal u pijnstillers of een verdoving krijgen om de pijn te verminderen indien u deze nog niet had ontvangen.");
        infoDescription.add("Het bot wordt in de goede stand teruggezet zodat de gebroken botdelen weer aan elkaar kunnen gaan groeien.\n\n" +
                "De gipsspalk wordt aangebracht om de zojuist terug gezette botdelen op hun plaats te houden.\n\n" +
                "Het gips wordt aangebracht aan uw been.\n\n" +
                "Er wordt een röntgenfoto gemaakt om te controleren of alles goed op zijn plaats zit.\n\n" +
                "Als het gips goed aangebracht is en het bot op de goede plek zit bent u hier klaar. Mocht dit niet het geval zijn moet het gips opnieuw aangebracht worden en een nieuwe röntgenfoto gemaakt worden.\n\n" +
                "Let op: het ontvangen gips is soms pas na 48 uur hard dus wees extra voorzichtig met dit gips gedurende de eerste 2 dagen.");
        infoDescription.add("Nu het been in het gips is geplaatst kunt u bijna het ziekenhuis verlaten maar er moeten nog enkele zaken afgehandeld worden.\n\n" +
                "Allereerst krijgt u krukken. Het is belangrijk dat er zo min mogelijk druk op uw been uitgeoefent wordt tijdens het herstel en u zal dus gebruik moeten maken van krukken om u over grotere afstanden te verplaatsen. Zorg dat u deze tijd gebruikt om voldoende te oefenen met het gebruik van de krukken.");
        infoDescription.add("U zal ook een recept voor medicatie ontvangen om zo wat beter door de eerste dagen van het herstel heen te komen. De medicatie betreft normaal gesproken pijnstillers.");

        infoList = new ArrayList<>();

        for(int i = 0; i < infoTitle.size(); i++)
        {
            FaseActieModel infoModel = new FaseActieModel(infoTitle.get(i), infoDescription.get(i));
            infoList.add(infoModel);
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
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
