package com.example.hwmanager.recycler_adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwmanager.R;

public class CourseListRecyclerAdapter extends RecyclerView.Adapter<CourseListRecyclerAdapter.ViewHolder> {




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView courseName;
        private CheckBox checkBox; // used to subscribe to a course
        private LinearLayout colorStrip; // used to assign a color to the course

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.CLI_courseText);
            checkBox = itemView.findViewById(R.id.CLI_subscribeCheckBox);
            colorStrip = itemView.findViewById(R.id.CLI_colorStrip);
        }
    }
}
