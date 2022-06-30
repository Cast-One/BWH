package com.castillo.breathewithme.Menu.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.breathewithme.Menu.Models.ItemHome;
import com.castillo.breathewithme.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ItemHomeRecyclerViewAdapter adapter;
    List<ItemHome> list_itemsHome = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new ItemHomeRecyclerViewAdapter(list_itemsHome);

        list_itemsHome.add(new ItemHome("¿Qué es una crisis?", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿WHAT SHOULD I CONSIDER WHEN I HAVE A CRISIS?", R.drawable.logo));
        list_itemsHome.add(new ItemHome("¿WHAT ARE EMOTIONS?", R.drawable.image_sea));
        list_itemsHome.add(new ItemHome("ALL EMOTIONS ARE IMPORTANT", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿Qué es una crisis?", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿WHAT SHOULD I CONSIDER WHEN I HAVE A CRISIS?", R.drawable.logo));
        list_itemsHome.add(new ItemHome("¿WHAT ARE EMOTIONS?", R.drawable.image_sea));
        list_itemsHome.add(new ItemHome("ALL EMOTIONS ARE IMPORTANT", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿Qué es una crisis?", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿WHAT SHOULD I CONSIDER WHEN I HAVE A CRISIS?", R.drawable.logo));
        list_itemsHome.add(new ItemHome("¿WHAT ARE EMOTIONS?", R.drawable.image_sea));
        list_itemsHome.add(new ItemHome("ALL EMOTIONS ARE IMPORTANT", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿Qué es una crisis?", R.drawable.image_sun));
        list_itemsHome.add(new ItemHome("¿WHAT SHOULD I CONSIDER WHEN I HAVE A CRISIS?", R.drawable.logo));
        list_itemsHome.add(new ItemHome("¿WHAT ARE EMOTIONS?", R.drawable.image_sea));
        list_itemsHome.add(new ItemHome("ALL EMOTIONS ARE IMPORTANT", R.drawable.image_sun));

        recyclerView.setAdapter(adapter);

        return view;
    }
}