package com.example.hwmanager.fragments;

import android.content.SharedPreferences;
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
import com.example.hwmanager.recycler_adapters.EventListItem;
import com.example.hwmanager.recycler_adapters.EventListRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class MyCoursesFragment extends Fragment {

    private String id;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference courseRef = db.collection("Events");
    private EventListRecyclerAdapter adapter;
    private SharedPreferences preferences = getActivity().getPreferences(MODE_PRIVATE);


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        id = preferences.getString("id","");
        return inflater.inflate(R.layout.fragment_my_courses,container,false);
    }

    private void initRecycler() {
        Query query = courseRef
                .whereArrayContains("subscribed", id)
                .orderBy("date",Query.Direction.DESCENDING)
                .orderBy("time",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<EventListItem> options = new FirestoreRecyclerOptions.Builder<EventListItem>().setQuery(query, EventListItem.class).build();
        adapter = new EventListRecyclerAdapter(options);
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.mainRecyclerList);
        recyclerView.setAdapter(adapter);
    }

}
