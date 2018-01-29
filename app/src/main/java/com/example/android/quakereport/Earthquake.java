package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Toki on 23/01/2018.
 */

public class Earthquake {
    // private global variables

    // magnitude of the earthquake
    private float mMagnitude;

    // place where earthquake occurred
    private String mPlace;

    // time in milliseconds from 1970
    private long mTime;

    // url for the details of the earthquake
    private String mUrl;

    /**
     * Constructor
     * @param magnitude magnitude of the earthquake
     * @param place place where earthquake occurred
     * @param time time in seconds from 1970
     * @param url for the details of the earthquake
     */
    public Earthquake (float magnitude, String place, long time, String url) {
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        mUrl = url;
    }

    /**
     *
     * @return double mMagnitude
     */
    public float getmMagnitude() {
        return mMagnitude;
    }

    /**
     *
     * @return String mPlace
     */
    public String getmPlace () {
        return mPlace;
    }

    /**
     *
     * @return String mUrl
     */
    public String getmUrl () {
        return mUrl;
    }

    /**
     *
     * @return long Mtime in seconds
     */
    public long getmTimeSec () {
        return mTime/1000;
    }

    /**
     *
     * @return long Mtime in milliseconds
     */
    public long getmTimeMill () {
        return mTime;
    }

    /**
     *
     * @param time in milliseconds
     * @return date in format MM dd, yyyy hh:mm
     */
    public String getDate (long time){
        long t = time; // it must be in milliseconds
        Date d = new java.util.Date(t);
        String date = new SimpleDateFormat("MMM dd, yyyy").format(d);
        return date;
    }

    /**
     *
     * @param time in milliseconds
     * @return time in format hh:mm:ss
     */
    public String getTime (long time){
        long t = time; // it must be in milliseconds
        Date d = new java.util.Date(t);
        String timeHM = new SimpleDateFormat("HH:mm").format(d);
        return timeHM;
    }

}
