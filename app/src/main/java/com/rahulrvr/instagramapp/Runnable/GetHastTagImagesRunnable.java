package com.rahulrvr.instagramapp.Runnable;

import android.content.Context;

import com.rahulrvr.instagramapp.data.ImageInfo;
import com.rahulrvr.instagramapp.data.Model;


public class GetHastTagImagesRunnable extends MainRunnable {

    public GetHastTagImagesRunnable(Context context)
    {
        super(context);
    }

    @Override
    protected ImageInfo doInBackground(String... strings) {
        ImageInfo imageInfo = service.getHashTagImages(strings[0], Model.TOKEN);
        tag_id = imageInfo.getPagination().getNextMaxTagId();
        return imageInfo;
    }

}
