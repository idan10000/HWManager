package com.example.hwmanager.support_classes;

import java.util.Calendar;

public class EventListItem {

    private String day, text;
    private int eventColor;
    private Calendar date;
    private Time time;

    public EventListItem() {
    }

    public EventListItem(Calendar date, String day, String text, Time time, int eventColor) {
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

    public Time getTime() {
        return time;
    }

    public int getEventColor() {
        return eventColor;
    }
}
