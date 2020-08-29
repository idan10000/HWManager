package com.example.hwmanager.fragments;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hwmanager.recycler_adapters.EventListItem;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.Calendar;

public class EventFragment extends Fragment {

    private DatePicker date;
    private TextView day;
    private TimePicker time;
    private EditText text;

    private String eventID;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public EventFragment(String eventID) {
        this.eventID = eventID;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db.collection("Events").document(eventID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                EventListItem item = documentSnapshot.toObject(EventListItem.class);
            }
        });
    }

    private void initFields(EventListItem item){

        date.updateDate(item.getDate().get(Calendar.YEAR),item.getDate().get(Calendar.MONTH),item.getDate().get(Calendar.DAY_OF_MONTH));
    }
}
