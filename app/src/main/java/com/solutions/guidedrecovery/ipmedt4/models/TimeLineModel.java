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

        String[] acties = new String[5];
        acties[0] = "Gipsen";
        acties[1] = "Afspraak";
        acties[2] = "Krukken";
        acties[3] = "Loopgips";
        acties[4] = "Herstel";

        String[] omschrijvingen = new String[5];
        omschrijvingen[0] = "Gips om het been";
        omschrijvingen[1] = "Afspraak maken bij de receptie";
        omschrijvingen[2] = "Krukken verkrijgen";
        omschrijvingen[3] = "Oud gips eraf, nieuw loopgips om het been";
        omschrijvingen[4] = "Herstelfase";



        for(int i = 1; i < acties.length; i++){
            TimeLineModel timeline = new TimeLineModel();
            timeline.setTitle(i + ". " + acties[i]);
            timeline.setDescription(omschrijvingen[i]);
            dataList.add(timeline);
        }

        return dataList;
    }
}
