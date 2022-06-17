package edu.My_5520_team25_project.utils;

import android.content.Context;
import android.os.Handler;

import edu.My_5520_team25_project.application.XHApplication;


public class UIutils {


    public static Context getApplication() {

        return XHApplication.mContext;
    }


    public static Handler getHandler() {

        return XHApplication.mHandler;
    }

}
