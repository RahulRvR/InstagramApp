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


public class GetHastTagImagesRunnable extends AsyncTask<String,Void,ImageInfo> {

    private Context context;

    public GetHastTagImagesRunnable(Context context)
    {
        this.context = context;
    }

    @Override
    protected ImageInfo doInBackground(String... strings) {

        String hashtag = strings[0];

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Model.ENDPOINT).setErrorHandler(new ErrorHandler() {
            @Override
            public Throwable handleError(RetrofitError cause) {
                return null;
            }
        }).build();

        GetHashTagApi service = adapter.create(GetHashTagApi.class);

        ImageInfo imageInfo = service.getHashTagImages(hashtag, Model.TOKEN);

        Model.tag_id = imageInfo.getPagination().getNextMaxId();

        return imageInfo;
    }


    @Override
    protected void onPostExecute(ImageInfo images) {
        super.onPostExecute(images);

        List<Images> imagesList = new ArrayList<Images>();

        for(Datum datum:images.getData())
        {
            imagesList.add(datum.getImages());
        }

        Model.loading = false;
        DIContainer.getInstance().getEventBus().post(new LoadImagesEvent(imagesList));
    }
}
