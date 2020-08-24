package com.example.hwmanager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwmanager.R;
import com.example.hwmanager.recycler_adapters.CourseListItem;
import com.example.hwmanager.recycler_adapters.CourseListRecyclerAdapter;
import com.example.hwmanager.recycler_adapters.EventListItem;
import com.example.hwmanager.recycler_adapters.EventListRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Objects;

public class CoursePage extends Fragment {

    private EventListRecyclerAdapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference courseRef = db.collection("Events");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FloatingActionButton addEventBT = getActivity().findViewById(R.id.M_addButton);
        addEventBT.setOnClickListener(onClickListener);
        initRecycler();
        return inflater.inflate(R.layout.fragment_course_page, container, false);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private void initRecycler() {
        Query query = courseRef
                .whereEqualTo("CourseName", getActivity().getIntent().getStringArrayExtra("CourseName"))
                .orderBy("date", Query.Direction.DESCENDING)
                .orderBy("time", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<EventListItem> options = new FirestoreRecyclerOptions.Builder<EventListItem>().setQuery(query, EventListItem.class).build();
        adapter = new EventListRecyclerAdapter(options);
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.mainRecyclerList);
        recyclerView.setAdapter(adapter);
    }


}
