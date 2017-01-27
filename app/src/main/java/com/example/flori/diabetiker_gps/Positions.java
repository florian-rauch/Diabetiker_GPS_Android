package com.example.flori.diabetiker_gps;

/**
 * Created by flori on 27.01.2017.
 */

public class Positions {
    String longitude;
    String latitude;
    String date;
    String time;

    public Positions(String longitude, String latitude, String date, String time) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "longitude='" + longitude + '\n' +
                ", latitude='" + latitude + '\n' +
                ", date='" + date + " "+time;
    }
}
