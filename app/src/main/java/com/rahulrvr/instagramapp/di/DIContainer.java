package com.rahulrvr.instagramapp.di;


import android.content.Context;

import com.squareup.otto.Bus;

public class DIContainer {

    private Bus eventBus;
    private static DIContainer container;



    private DIContainer()
    {

    }

    public static DIContainer getInstance()
    {
        if(container == null)
        {
            container =  new DIContainer();
        }

        return container;
    }



    public Bus getEventBus() {
        return eventBus;
    }

    public void setEventBus(Bus eventBus) {
        this.eventBus = eventBus;
    }

    public void loadObjects(Context context)
    {
        eventBus = new Bus();
    }





}
