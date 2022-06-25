package com.example.chatting.support;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    private static final String My_Shared_Preferences = "My_Shared_Preferences";
    private Context mContext;

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }
    public void putBooleanCheck(String key,boolean value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(My_Shared_Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }
    public boolean getBooleanCheck(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(My_Shared_Preferences,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }
}
