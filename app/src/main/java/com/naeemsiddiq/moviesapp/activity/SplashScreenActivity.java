package com.naeemsiddiq.moviesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.naeemsiddiq.moviesapp.R;

/**
 * Created by Sakhi on 6/30/2017.
 */

public class SplashScreenActivity extends AppCompatActivity{
    private static int SPLASH_TIME_OUT=1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },SPLASH_TIME_OUT);
    }
}
