package edu.My_5520_team25_project.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class XHApplication extends Application {


    public static Handler mHandler = new Handler();

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }



}
