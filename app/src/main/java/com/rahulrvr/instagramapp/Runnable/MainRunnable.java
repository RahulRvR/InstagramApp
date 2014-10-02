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

/**
 * Created by rvijay004c on 10/2/14.
 */
public class MainRunnable extends AsyncTask<String,Void,ImageInfo> {

    private Context context;
    public RestAdapter adapter;
    public GetHashTagApi service;
    public static String tag_id = null;


    public MainRunnable(Context context)
    {
        this.context = context;
        adapter = new RestAdapter.Builder().setEndpoint(Model.ENDPOINT).setErrorHandler(new ErrorHandler() {
            @Override
            public Throwable handleError(RetrofitError cause) {
                return null;
            }
        }).build();
        service = adapter.create(GetHashTagApi.class);
    }

    @Override
    protected ImageInfo doInBackground(String... strings) {

        return  null;
    }

    @Override
    protected void onPostExecute(ImageInfo imageInfo) {
        super.onPostExecute(imageInfo);

        if(imageInfo !=null)
        {
            List<Images> imagesList = new ArrayList<Images>();
            for(Datum datum:imageInfo.getData())
            {
                imagesList.add(datum.getImages());
            }
            Model.loading = false;
            DIContainer.getInstance().getEventBus().post(new LoadImagesEvent(imagesList));
        }

    }
}
