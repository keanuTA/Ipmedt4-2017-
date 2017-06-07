package com.solutions.guidedrecovery.ipmedt4.models;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import com.solutions.guidedrecovery.ipmedt4.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipak on 5-6-2017.
 */

public class TimeLineModel {

    private String title, description;
    private boolean isChecked;

    public TimeLineModel(){

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public static List<TimeLineModel> getObjectList(){

        List<TimeLineModel> dataList = new ArrayList<>();

        ArrayList<String> acties = new ArrayList<String>();
        acties.add("Gipsen");
        acties.add("Vervolgafspraak");
        acties.add("Loopgips");
        acties.add("Hersteld");

        ArrayList<String> omschrijvingen = new ArrayList<String>();
        omschrijvingen.add("Gips om het been");
        omschrijvingen.add("Afspraak maken bij de receptie");
        omschrijvingen.add("Na 4 weken loopgips");
        omschrijvingen.add("Herstelfase");

        for(int i = 0; i < acties.size(); i++){
            TimeLineModel timeline = new TimeLineModel();
            timeline.setTitle((i+1) + ". " + acties.get(i));
            timeline.setDescription(omschrijvingen.get(i));
            dataList.add(timeline);
        }

        return dataList;
    }
}
