package com.sangmyung.tourapp2017.getGPS;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseFeedParser implements FeedParser {

    static final String ITEM = "item";

    static final String ADDR1 = "addr1";
    static final String ADDR2 = "addr2";
    static final String FIRSTIMAGE = "firstimage";
    static final String MAPX = "mapx";
    static final String MAPY = "mapy";
    static final String TEL = "tel";
    static final String TITLE = "title";

    static final String ITEMS = "items";

    final URL feedUrl;

    protected BaseFeedParser(String feedUrl){
        try {
            this.feedUrl = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected InputStream getInputStream() {
        try {
            return feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
