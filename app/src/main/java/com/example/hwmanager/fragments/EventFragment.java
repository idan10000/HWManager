package com.example.hwmanager.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hwmanager.R;
import com.example.hwmanager.support_classes.EventListItem;
import com.example.hwmanager.support_classes.TinyDB;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class EventFragment extends Fragment {

    private EditText textET, dateET, timeET;
    private AutoCompleteTextView courseACTV;
    private Button saveBT;

    private Context context;
    private List<String> courses;
    private final Calendar myCalendar = Calendar.getInstance();
    private String eventID;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public EventFragment(String eventID) {
        this.eventID = eventID;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
        TinyDB tinydb = new TinyDB(context);
        courses = tinydb.getListString("courses");

        textET = getActivity().findViewById(R.id.FAE_submissionTextET);
        dateET = getActivity().findViewById(R.id.FAE_dateET);
        timeET = getActivity().findViewById(R.id.FAE_timeET);
        courseACTV = getActivity().findViewById(R.id.FAE_courseTAC);
        saveBT = getActivity().findViewById(R.id.FAE_saveBT);

        db.collection("Events").document(eventID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                EventListItem item = documentSnapshot.toObject(EventListItem.class);
                initFields(item);
            }
        });
    }

    private void initFields(EventListItem item) {
        if (item != null) {
            myCalendar.set(item.getDate().get(Calendar.YEAR),
                    item.getDate().get(Calendar.MONTH), item.getDate().get(Calendar.DAY_OF_MONTH),
                    item.getTime().getHour(), item.getTime().getMinute());
            updateDateLabel();
            textET.setText(item.getText());
            courseACTV.setText(item.getCourse());
            timeET.setText(item.getTime().toString());
        }
        courseACTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseACTV.showDropDown();
            }
        });
        courseACTV.setAdapter(new ArrayAdapter<>(
                context, android.R.layout.simple_list_item_1, courses));
        courseACTV.setCursorVisible(false);
        courseACTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                courseACTV.setText((String) adapterView.getItemAtPosition(i));
            }
        });

        // Date dialog setup
        final DatePickerDialog.OnDateSetListener dateDialog = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateLabel();
            }
        };

        dateET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, dateDialog, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Time dialog setup
        timeET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                final int minute = myCalendar.get(Calendar.MINUTE);
                TimePickerDialog TimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeET.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                TimePicker.setTitle("Select Time");
                TimePicker.show();
            }
        });
    }

    private void updateDateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        dateET.setText(sdf.format(myCalendar.getTime()));
    }
}
