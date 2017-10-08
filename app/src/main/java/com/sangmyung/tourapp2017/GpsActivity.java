package com.sangmyung.tourapp2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.sangmyung.tourapp2017.getGPS.XmlPullFeedParser;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 신영준 on 2017-10-06.
 */

public class GpsActivity extends AppCompatActivity{
    URL findURL;
    String st = null;
    protected void onCreate(Bundle savedInstanceState) {
        try {
            findURL = new URL(st);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
    }
}
