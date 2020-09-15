package com.example.hwmanager.support_classes;

import java.util.Calendar;

public class EventListItem {

    private String day, text, course;
    private int eventColor;
    private Calendar date;
    private Time time;

    public EventListItem() {
    }

    public EventListItem(Calendar date, String day, String text, Time time, int eventColor, String course) {
        this.date = date;
        this.day = day;
        this.text = text;
        this.time = time;
        this.eventColor = eventColor;
        this.course = course;
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

    public String getCourse() {
        return course;
    }
}
