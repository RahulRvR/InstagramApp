package com.rahulrvr.instagramapp.Runnable;


import android.content.Context;

import com.rahulrvr.instagramapp.data.ImageInfo;
import com.rahulrvr.instagramapp.data.Model;

public class GetNextHasTagImagesRunnable extends MainRunnable
{
    public GetNextHasTagImagesRunnable(Context context)
    {
        super(context);
    }

    @Override
    protected ImageInfo doInBackground(String... strings) {

        if(tag_id !=null) {
            ImageInfo imageInfo = service.getNextHashTagImages(strings[0], Model.TOKEN, tag_id);
            tag_id = imageInfo.getPagination().getNextMaxTagId();
            return imageInfo;
        }

        return  null;

    }


}
