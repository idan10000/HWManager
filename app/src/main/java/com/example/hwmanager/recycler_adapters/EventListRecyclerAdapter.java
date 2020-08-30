package com.example.hwmanager.recycler_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwmanager.R;
import com.example.hwmanager.support_classes.EventListItem;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.Calendar;

public class EventListRecyclerAdapter extends FirestoreRecyclerAdapter<EventListItem, EventListRecyclerAdapter.EventListViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EventListRecyclerAdapter(@NonNull FirestoreRecyclerOptions<EventListItem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventListViewHolder holder, int position, @NonNull EventListItem model) {
        holder.eventText.setText(model.getText());
        holder.eventDay.setText(model.getDay());
        holder.eventDate.setText(model.getDate().get(Calendar.MONTH) + "." + model.getDate().get(Calendar.DAY_OF_MONTH));
        holder.eventTime.setText(model.getTime().toString());
        holder.eventBackColor.setBackgroundColor(model.getEventColor());
    }

    @NonNull
    @Override
    public EventListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        return new EventListRecyclerAdapter.EventListViewHolder(view);
    }

    public class EventListViewHolder extends RecyclerView.ViewHolder {

        private TextView eventDate;
        private TextView eventDay;
        private ConstraintLayout eventBackColor;
        private TextView eventText;
        private TextView eventTime;

        public EventListViewHolder(@NonNull View itemView) {
            super(itemView);
            eventDate = itemView.findViewById(R.id.ELI_date);
            eventDay = itemView.findViewById(R.id.ELI_dayOfWeek);
            eventBackColor = itemView.findViewById(R.id.ELI_backgroundColor);
            eventText = itemView.findViewById(R.id.ELI_taskText);
            eventTime = itemView.findViewById(R.id.ELI_taskTime);
        }
    }
}
