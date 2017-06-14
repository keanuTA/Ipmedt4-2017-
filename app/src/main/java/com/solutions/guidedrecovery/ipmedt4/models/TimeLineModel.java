/**
 *  Created by Dipak
 *  10-06-2017
 */


package com.solutions.guidedrecovery.ipmedt4.models;

import java.io.Serializable;

public class TimeLineModel implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private boolean isSelected;
    private TrajectStatusActivity status;

    public TimeLineModel()
    {

    }

    public TimeLineModel(String title, String description)
    {

    }

    public TimeLineModel(String title, String description, boolean isSelected, TrajectStatusActivity status)
    {

        this.title = title;
        this.description = description;
        this.isSelected = isSelected;
        this.status = status;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String emailId)
    {
        this.description = emailId;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }

    public TrajectStatusActivity getStatus()
    {
        return status;
    }

    public void setStatus(TrajectStatusActivity status)
    {
        this.status = status;
    }

}