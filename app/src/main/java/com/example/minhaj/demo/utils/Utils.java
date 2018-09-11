package com.example.minhaj.demo.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.minhaj.demo.MainActivity;

/**
 * Created by Minhaj on 10/09/2018.
 */
public class Utils {

    /*
        enable full screen mode. usually for splash screen
     */
    public static void enableLeanBackFullScreenMode(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }

    /*
        check if activity running
     */
    public static boolean isActivityRunning(Activity activity){
        return activity.getWindow().getDecorView().getRootView().isShown();
    }

    /*
        start main activity
     */
    public static void startMainActivity(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    /*
        check for login
     */
    public static boolean isLogin(Prefs prefs){
        return prefs.getBool(Constants.PREF_IS_LOGIN,false);
    }
}
