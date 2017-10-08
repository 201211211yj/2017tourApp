package com.sangmyung.tourapp2017.getGPS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class GpsData {
    private String addr1;
    private String addr2;
    private URL firstimage;
    private String mapx;
    private String mapy;
    private String tel;
    private String title;
    void setAddr1(String st){
        addr1 = st;
    }
    void setAddr2(String st){
        addr2 = st;
    }
    void setFirstimage(String st){
        try {
            firstimage = new URL(st);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    void setMapx(String st){ mapx = st; }
    void setMapy(String st){
        mapy = st;
    }
    void setTel(String st){
        tel = st;
    }
    void setTitle(String st){
        title = st;
    }
    String getAddr1(){
        return addr1;
    }
    String getAddr2(){
        return addr2;
    }
    String getMapx(){
        return mapx;
    }
    String getMapy(){
        return mapy;
    }
    URL getFirstimage(){
        return firstimage;
    }
    String getTel(){
        return tel;
    }
    String getTitle(){
        return title;
    }
}
