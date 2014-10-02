package com.rahulrvr.instagramapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rahulrvr.instagramapp.R;
import com.rahulrvr.instagramapp.di.DIContainer;


public class SplashActivity extends Activity {
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        DIContainer.getInstance().loadObjects(getApplicationContext());
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splashfade);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }



    private Runnable delaySplash = new Runnable() {
        @Override
        public void run() {
          try
          {
              Thread.sleep(4000);
          }
          catch (Exception e)
          {

          }
            finally {
            showMainActivity();
          }
        }
    };

    private void showMainActivity()
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.splashIcon).startAnimation(animation);
        Thread thread = new Thread(delaySplash);

        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        animation.reset();
        animation.cancel();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
