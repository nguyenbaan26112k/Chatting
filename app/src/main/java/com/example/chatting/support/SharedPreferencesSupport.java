package com.example.chatting.support;

import android.app.Application;

public class SharedPreferencesSupport extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
