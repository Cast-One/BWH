package com.castillo.breathewithme.ToolsApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.breathewithme.R;
import com.sn.lib.NestedProgress;


public class ProgressFragment extends Fragment {
    public ProgressFragment() {
        // Required empty public constructor
         }
        NestedProgress nestedProgress;
         View view_progress;
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        view_progress = view.findViewById(R.id.view_progress);
        nestedProgress = view.findViewById(R.id.nestedProgress);
        nestedProgress.setOuterLoaderColor(R.color.black);
        nestedProgress.setInnerLoaderColor(R.color.white);

        view_progress.setOnClickListener(view1 -> {

        });
        return view;
    }
}