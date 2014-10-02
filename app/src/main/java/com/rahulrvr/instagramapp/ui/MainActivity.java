package com.rahulrvr.instagramapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.rahulrvr.instagramapp.R;
import com.rahulrvr.instagramapp.Runnable.GetHastTagImagesRunnable;
import com.rahulrvr.instagramapp.data.Model;

public class MainActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        getActionBar().setTitle("Main");
        button = (Button)findViewById(R.id.searchImages);

        InputMethodManager iManager = (InputMethodManager)getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        iManager.showSoftInput(button,InputMethodManager.SHOW_IMPLICIT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model.hashTagString = ((TextView)findViewById(R.id.txtHasttag)).getText().toString();
                if( Model.hashTagString ==null ||  Model.hashTagString.length()<=0)
                {
                    Model.hashTagString="soccer";
                }
                new GetHastTagImagesRunnable(getApplicationContext()).execute( Model.hashTagString);
                Intent intent = new Intent(getApplicationContext(),ImagesActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
