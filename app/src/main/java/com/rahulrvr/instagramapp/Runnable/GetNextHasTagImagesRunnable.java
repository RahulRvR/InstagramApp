package com.rahulrvr.instagramapp.Runnable;


import android.content.Context;
import android.os.AsyncTask;

import com.rahulrvr.instagramapp.apiretrofit.GetHashTagApi;
import com.rahulrvr.instagramapp.data.Datum;
import com.rahulrvr.instagramapp.data.ImageInfo;
import com.rahulrvr.instagramapp.data.Images;
import com.rahulrvr.instagramapp.data.Model;
import com.rahulrvr.instagramapp.di.DIContainer;
import com.rahulrvr.instagramapp.events.LoadImagesEvent;

import java.util.ArrayList;
import java.util.List;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class GetNextHasTagImagesRunnable extends AsyncTask<String,Void,ImageInfo>{

    private  static final String TOKEN = "852593503.b802507.c8dcae7af3df452f90d62c7e2b146fd5";
    private  String ENDPOINT = "https://api.instagram.com/v1/tags";
    private Context context;

    public GetNextHasTagImagesRunnable(Context context)
    {
        this.context = context;
    }


    @Override
    protected ImageInfo doInBackground(String... strings) {

        String hashtag = strings[0];

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ENDPOINT).setErrorHandler(new ErrorHandler() {
            @Override
            public Throwable handleError(RetrofitError cause) {
                return null;
            }
        }).build();

        GetHashTagApi service = adapter.create(GetHashTagApi.class);


       ImageInfo imageInfo= service.getNextHashTagImages(hashtag,TOKEN, Model.tag_id);

        return imageInfo;

    }


    @Override
    protected void onPostExecute(ImageInfo imageInfo) {
        super.onPostExecute(imageInfo);
        List<Images> imagesList = new ArrayList<Images>();

        for(Datum datum:imageInfo.getData())
        {
            imagesList.add(datum.getImages());
        }

        Model.loading = false;
        DIContainer.getInstance().getEventBus().post(new LoadImagesEvent(imagesList));
    }
}
