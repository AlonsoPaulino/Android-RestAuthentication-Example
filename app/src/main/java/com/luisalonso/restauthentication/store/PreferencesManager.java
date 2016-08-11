package com.luisalonso.restauthentication.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.luisalonso.restauthentication.RestAuthentication;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class PreferencesManager {

    private static final String PREFERENCES_NAME = "my_preferences";

    private static final String SESSION_EXIST = "session_exist";

    public static boolean sessionExist() {
        Context context = RestAuthentication.CONTEXT;
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .getBoolean(SESSION_EXIST, false);
    }

    public static void setSessionState(boolean state) {
        Context context = RestAuthentication.CONTEXT;
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(SESSION_EXIST, state);
        editor.apply();
    }
}
