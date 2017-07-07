package com.solutions.guidedrecovery.ipmedt4.models;

/**
 * Created by Dipak on 19-6-2017.
 */

public class FaseActieModel {

    private String title;
    private String description;

    public FaseActieModel(String title, String description)
    {
        this.title = title;
        this.description = description;
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


}
