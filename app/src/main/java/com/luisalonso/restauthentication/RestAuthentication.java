package com.luisalonso.restauthentication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class RestAuthentication extends Application {

    static class Config {
        static boolean DEBUG = false;
    }

    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
    }

    public void log(String tag, String message) {
        if (Config.DEBUG) {
            Log.d(tag, message);
        }
    }

    public void log(String message) {
        log(CONTEXT.getString(R.string.app_name), message);
    }
}
