package com.example.hwmanager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwmanager.R;
import com.example.hwmanager.recycler_adapters.CourseListItem;
import com.example.hwmanager.recycler_adapters.CourseListRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Objects;

public class AllCoursesFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference courseRef = db.collection("Courses");


    private FloatingActionButton addCourseBT;
    private CourseListRecyclerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_all_courses,container,false);
        addCourseBT = fragView.findViewById(R.id.M_addButton);
        initRecycler();
        return fragView;

    }

    private void initRecycler() {
        Query query = courseRef.orderBy("courseName",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<CourseListItem> options = new FirestoreRecyclerOptions.Builder<CourseListItem>().setQuery(query, CourseListItem.class).build();
        adapter = new CourseListRecyclerAdapter(options);
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.mainRecyclerList);
        recyclerView.setAdapter(adapter);
        }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addCourseBT = view.findViewById(R.id.AC_addButton);
    }
}
