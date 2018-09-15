package com.example.minhaj.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.minhaj.demo.utils.Prefs;
import com.example.minhaj.demo.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private final int TIME_OUT = 2500; //2sec
    private Activity context;
    private Prefs prefs;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.enableLeanBackFullScreenMode(this);   //enable full screen mode
        setContentView(R.layout.activity_splash);

        context = this;
        prefs = new Prefs(this);

        textView = findViewById(R.id.textView);

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

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_splash);
        textView.startAnimation(animation);
    }
}
