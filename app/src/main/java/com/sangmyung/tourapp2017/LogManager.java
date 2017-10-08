package com.sangmyung.tourapp2017;

/**
 * Created by 신영준 on 2017-10-01.
 */

import android.util.Log;


public class LogManager
{
    public static final boolean _DEBUG = true;

    private static final String _TAG = "TMAP_OPEN_API";


    public static void printLog(String text)
    {
        if ( _DEBUG )
        {
            Log.d(_TAG, text);
        }
    }


    public static void printError(String text)
    {
        if(_DEBUG)
            Log.e(_TAG, "**ERROR** : " + text);
    }

}
