package com.example.hwmanager.recycler_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwmanager.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CourseListRecyclerAdapter extends FirestoreRecyclerAdapter<CourseListItem, CourseListRecyclerAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CourseListRecyclerAdapter(@NonNull FirestoreRecyclerOptions<CourseListItem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull CourseListItem model) {
        holder.colorStrip.setBackgroundColor(model.getStripColor());
        holder.courseName.setText(model.getCourseName());
        holder.checkBox.setSelected(false); // TODO: add state from local file
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(view);
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
