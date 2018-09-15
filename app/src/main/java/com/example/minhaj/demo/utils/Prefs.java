package com.example.minhaj.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Minhaj on 12/09/2018.
 */
public class Prefs {

    private final String PREFERENCE_FILE_KEY = "com.example.minhaj.demo";
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Prefs (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setString(String key,String value){
        editor.putString(key,value);
        editor.apply();
    }

    public String getString(String key,String defaultValue){
        return sharedPreferences.getString(key,defaultValue);
    }

    public void setBool(String key,boolean value){
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean getBool(String key,boolean defaultValue){
        return sharedPreferences.getBoolean(key,defaultValue);
    }

    public void clear(){
        editor.clear();
        editor.apply();
    }
}
