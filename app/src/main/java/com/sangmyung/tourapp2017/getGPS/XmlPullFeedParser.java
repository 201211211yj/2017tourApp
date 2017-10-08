package com.sangmyung.tourapp2017.getGPS;


import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;
import java.util.List;

public class XmlPullFeedParser extends BaseFeedParser {
    public XmlPullFeedParser(String feedUrl) {
        super(feedUrl);
    } //URL 입력은 귀찮으니 나중에~

    public List<GpsData> parse() {
        List<GpsData> gpsDatas = null;
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(this.getInputStream(), null);

            int eventType = parser.getEventType();
            GpsData currentData = null;
            boolean done = false;
            while (eventType != XmlPullParser.END_DOCUMENT && !done){
                String name = null;
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        // 스트림의 시작. 리스트 생성.
                        gpsDatas = new ArrayList<GpsData>();
                        break;
                    case XmlPullParser.START_TAG:
                        // 태그를 식별한 뒤 태그에 맞는 작업을 수행
                        name = parser.getName();
                        if (name.equalsIgnoreCase(ITEM)){
                            currentData = new GpsData();
                        } else if (currentData != null){
                            if (name.equalsIgnoreCase(ADDR1)){
                                currentData.setAddr1(parser.nextText());
                            }else if (name.equalsIgnoreCase(ADDR2)){
                                currentData.setAddr2(parser.nextText());
                            }else if (name.equalsIgnoreCase(FIRSTIMAGE)){
                                currentData.setFirstimage(parser.nextText());
                            }else if (name.equalsIgnoreCase(MAPX)) {
                                currentData.setMapx(parser.nextText());
                            }else if (name.equalsIgnoreCase(MAPY)) {
                                currentData.setMapy(parser.nextText());
                            }else if (name.equalsIgnoreCase(TEL)) {
                                currentData.setTel(parser.nextText());
                            }else if (name.equalsIgnoreCase(TITLE)) {
                                currentData.setTitle(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        // 태그의 마지막을. ITEM을 처리하는 중이면 리스트에 Message를 추가
                        name = parser.getName();
                        if (name.equalsIgnoreCase(ITEM) &&
                                currentData != null){
                            gpsDatas.add(currentData);
                        } else if (name.equalsIgnoreCase(ITEMS)){
                            done = true;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return gpsDatas;//getdata list 반환
    }
}