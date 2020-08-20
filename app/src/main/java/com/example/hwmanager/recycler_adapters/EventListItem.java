package com.example.hwmanager.recycler_adapters;

public class EventListItem {

    private String date, day, text, time;
    private int eventColor;

    public EventListItem() {
    }

    public EventListItem(String date, String day, String text, String time, int eventColor) {
        this.date = date;
        this.day = day;
        this.text = text;
        this.time = time;
        this.eventColor = eventColor;
    }

    public String getDate() {
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
