package com.rahulrvr.instagramapp.events;

import com.rahulrvr.instagramapp.data.Images;

import java.util.List;


public class LoadImagesEvent {

    private List<Images> imagesList;


    public  LoadImagesEvent(List<Images> imagesList)
    {
        this.imagesList = imagesList;
    }




    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }
}
