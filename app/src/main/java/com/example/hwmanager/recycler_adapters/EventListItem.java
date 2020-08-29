package com.example.hwmanager.recycler_adapters;

import java.util.Calendar;
import java.util.Date;

public class EventListItem {

    private String day, text, time;
    private int eventColor;
    private Calendar date;

    public EventListItem() {
    }

    public EventListItem(Calendar date, String day, String text, String time, int eventColor) {
        this.date = date;
        this.day = day;
        this.text = text;
        this.time = time;
        this.eventColor = eventColor;
    }

    public Calendar getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public int getEventColor() {
        return eventColor;
    }
}
