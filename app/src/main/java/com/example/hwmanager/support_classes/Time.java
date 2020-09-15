package com.example.hwmanager.support_classes;

public class Time {
    private int hour;
    private int minute;

    public Time(){

    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}
