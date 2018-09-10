package com.example.minhaj.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.minhaj.demo.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private final int TIME_OUT = 2000; //2sec
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.enableLeanBackFullScreenMode(this);   //enable full screen mode
        setContentView(R.layout.activity_splash);

        context = this;
        //start main activity after delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utils.isActivityRunning(context)){
                    Utils.startMainActivity(context);

                }
            }
        },TIME_OUT);
    }
}
