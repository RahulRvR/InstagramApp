package com.rahulrvr.instagramapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahulrvr.instagramapp.R;
import com.rahulrvr.instagramapp.data.Images;
import com.rahulrvr.instagramapp.di.DIContainer;
import com.rahulrvr.instagramapp.events.ZoomImageEvent;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyImageAdapter extends BaseAdapter{

    private List<Images> list ;
    private Context context;

    public MyImageAdapter(Context context,List<Images> imagesList)
    {
        list = imagesList;
        this.context = context;

    }


    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i,View layoutView, ViewGroup viewGroup) {
        final Images image = list.get(i);
        LayoutInflater inflater = LayoutInflater.from(context);
        if(layoutView == null)
        {
            layoutView = inflater.inflate(R.layout.grid_image_layout,viewGroup,false);
        }

        TextView textView = (TextView) layoutView.findViewById(R.id.imageName);
        final ImageView imageView = ((ImageView)layoutView.findViewById(R.id.hashtagImage));

        textView.setText("Image " + Integer.toString(i));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DIContainer.getInstance().getEventBus().post(new ZoomImageEvent(image.getStandardResolution().getUrl()));
            }
        });

        Picasso.with(context).load(image.getLowResolution().getUrl()).into(imageView);
        return layoutView;
    }



    @Override
    public int getCount() {
        return list.size();
    }
}
