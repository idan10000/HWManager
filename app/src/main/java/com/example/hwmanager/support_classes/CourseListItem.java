package com.example.hwmanager.support_classes;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseListItem {

    private String courseName;
//    private Boolean checkBoxState; // used to subscribe to a course
    private int stripColor; // used to assign a color to the course

    public CourseListItem() {
    }

    public CourseListItem(String courseName, int stripColor) {
        this.courseName = courseName;
        this.stripColor = stripColor;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getStripColor() {
        return stripColor;
    }
}
