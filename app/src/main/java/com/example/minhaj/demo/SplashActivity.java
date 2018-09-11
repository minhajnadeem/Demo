package com.example.minhaj.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.minhaj.demo.utils.Prefs;
import com.example.minhaj.demo.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private final int TIME_OUT = 2000; //2sec
    private Activity context;
    private Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.enableLeanBackFullScreenMode(this);   //enable full screen mode
        setContentView(R.layout.activity_splash);

        context = this;
        prefs = new Prefs(this);
        //start main activity after delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utils.isActivityRunning(context)){
                    if (Utils.isLogin(prefs)){
                        Utils.startMainActivity(context);
                    }else {
                        Intent intent = new Intent(context,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        },TIME_OUT);
    }
}
