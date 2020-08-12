package com.example.hwmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AllCoursesFragment extends Fragment {

    private FloatingActionButton addCourseBT;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_all_courses,container,false);
        addCourseBT = fragView.findViewById(R.id.AC_addButton);
        recyclerView = getActivity().findViewById(R.id.mainRecyclerList);
        initRecycler(recyclerView);
        return fragView;

    }

    private void initRecycler(RecyclerView recyclerView) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addCourseBT = view.findViewById(R.id.AC_addButton);
    }
}
