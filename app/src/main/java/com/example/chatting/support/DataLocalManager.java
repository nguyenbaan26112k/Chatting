package com.example.chatting.support;

import android.content.Context;



public class DataLocalManager {
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setCheckLogin(boolean checkLogin) {
        DataLocalManager.getInstance().mySharedPreferences.putBooleanCheck(Keyname.PREF_FIRST_INSTALL, checkLogin);
    }

    public static boolean getCheckLogin() {

        boolean booleanCheck = DataLocalManager.getInstance().mySharedPreferences.getBooleanCheck(Keyname.PREF_FIRST_INSTALL);

        return booleanCheck;

    }
}
