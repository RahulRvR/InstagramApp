package com.rahulrvr.instagramapp.ui;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;

import com.rahulrvr.instagramapp.R;
import com.rahulrvr.instagramapp.Runnable.GetNextHasTagImagesRunnable;
import com.rahulrvr.instagramapp.adapter.MyImageAdapter;
import com.rahulrvr.instagramapp.data.Images;
import com.rahulrvr.instagramapp.data.Model;
import com.rahulrvr.instagramapp.di.DIContainer;
import com.rahulrvr.instagramapp.events.LoadImagesEvent;
import com.rahulrvr.instagramapp.events.ZoomImageEvent;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends Activity{

    GridView gridView;
    List<Images> imagesList;
    MyImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_activity_layout);
        getActionBar().setTitle("#" + Model.hashTagString);
        imagesList = new ArrayList<Images>();
         gridView = (GridView) findViewById(R.id.gridImages);

        adapter = new MyImageAdapter(getApplicationContext(),imagesList);

        gridView.setAdapter(adapter);


        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {


            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if(!Model.loading &&  totalItemCount>0 && (totalItemCount - firstVisibleItem) < 10)
                {
                    Model.loading = true;
                    new GetNextHasTagImagesRunnable(getApplicationContext()).execute(Model.hashTagString,Model.tag_id);
                }

            }
        });
    }

    private void zoomImage(String url)
    {
        final ImageView imageView = (ImageView) findViewById(R.id.zoomView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
                Animation animator = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                imageView.startAnimation(animator);
            }
        });

        Picasso.with(getApplicationContext()).load(url).into(imageView);
        imageView.setVisibility(View.VISIBLE);
        Animation animator = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animator);


    }

    @Override
    protected void onResume() {
        super.onResume();
        DIContainer.getInstance().getEventBus().register(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        DIContainer.getInstance().getEventBus().unregister(this);
    }

    @Subscribe
    public void ImagesLoaded(LoadImagesEvent event)
    {
       imagesList.addAll(event.getImagesList());
        adapter.notifyDataSetChanged();

    }

    @Subscribe
    public void zoomImage(ZoomImageEvent event)
    {
        zoomImage(event.getZoomImage());
    }
}
