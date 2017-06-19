package com.solutions.guidedrecovery.ipmedt4;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.solutions.guidedrecovery.ipmedt4.models.TimeLineModel;

import java.util.ArrayList;
import java.util.List;

import static com.solutions.guidedrecovery.ipmedt4.models.TrajectStatus.INACTIVE;

public class GipsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<TimeLineModel> actionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gips);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.icons_container), iconFont);

        getStappenplan();

        mRecyclerView = (RecyclerView) findViewById(R.id.stappenplan_gipsen);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getStappenplan() {
        ArrayList<String> acties = new ArrayList<String>();
        acties.add("De breuk is bekend, het is nu zaak om het been in gips te plaatsen zodat het bot kan herstellen. ");
        acties.add("Als u aan de beurt bent zal u zich bij de gipskamer moeten melden en zal het volgende gebeuren.");
        acties.add("Ten eerste zal u pijnstillers of een verdoving krijgen om de pijn te verminderen indien u deze nog niet had ontvangen.");
        acties.add("Het bot wordt in de goede stand teruggezet zodat de gebroken botdelen weer aan elkaar kunnen gaan groeien.");
        acties.add("De gipsspalk wordt aangebracht om de zojuist terug gezette botdelen op hun plaats te houden.");
        acties.add("Het gips wordt aangebracht aan uw been.");
        acties.add("Er wordt een röntgenfoto gemaakt om te controleren of alles goed op zijn plaats zit.");
        acties.add("Als het gips goed aangebracht is en het bot op de goede plek zit bent u hier klaar. Mocht dit niet het geval zijn moet het gips opnieuw aangebracht worden en een nieuwe röntgenfoto gemaakt worden.");

        ArrayList<String> omschrijvingen = new ArrayList<String>();
        omschrijvingen.add("Breuk bekend");
        omschrijvingen.add("Gipskamer");
        omschrijvingen.add("Pijnstillers");
        omschrijvingen.add("Bot recht zetten");
        omschrijvingen.add("De gipsspalk");
        omschrijvingen.add("Gipsen");
        omschrijvingen.add("Röntgenfoto maken");
        omschrijvingen.add("Röntgenfoto uitslag en vervolg");

        for(int i = 0; i < acties.size(); i++)
        {
            TimeLineModel timeline = new TimeLineModel(acties.get(i), omschrijvingen.get(i), false, INACTIVE);
            actionList.add(timeline);
        }
    }
}
