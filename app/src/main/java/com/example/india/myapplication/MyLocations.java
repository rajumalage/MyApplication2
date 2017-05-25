package com.example.india.myapplication;

/**
 * Created by india on 3/21/2017.
 */

public class MyLocations {
    private float lat=0.0f;
    private float lng=0.0f;
    private String key="";
    private int radius=0;
    private String name="";
    private String audio_file="";

    public MyLocations() {

        float lat = 0.0f;
        float lng = 0.0f;
        String key = "";
        int radius = 0;
        String name = "";
        String audio_file = "";

        this.lat = lat;
        this.lng = lng;
        this.key = key;
        this.radius = radius;
        this.name = name;
        this.audio_file = audio_file;


    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudio_file() {
        return audio_file;
    }

    public void setAudio_file(String audio_file) {
        this.audio_file = audio_file;
    }


}
