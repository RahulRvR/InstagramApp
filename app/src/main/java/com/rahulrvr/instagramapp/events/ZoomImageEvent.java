package com.rahulrvr.instagramapp.events;


public class ZoomImageEvent {

    private String zoomImage;
    public ZoomImageEvent(String imageURL)
    {
        zoomImage = imageURL;
    }


    public String getZoomImage()
    {
        return zoomImage;
    }

}
