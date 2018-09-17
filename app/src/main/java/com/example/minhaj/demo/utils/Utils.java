package com.example.minhaj.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.minhaj.demo.LoginActivity;
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
    public static boolean isActivityRunning(Activity activity) {
        return activity.getWindow().getDecorView().getRootView().isShown();
    }

    /*
        start main activity
     */
    public static void startMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    /*
        check for login
     */
    public static boolean isLogin(Prefs prefs) {
        return prefs.getBool(Constants.PREF_IS_LOGIN, false);
    }

    public static void logout(Activity activity,Prefs prefs) {
        prefs.clear();
        startNewLoginActivity(activity);
    }
    /*
        start new login activity
     */
    public static void startNewLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    /*
        get device height in pixel
     */
    public static int getDeviceHeight(Activity context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /*
        get device width in pixel
     */
    public static int getDeviceWidth(Activity context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
