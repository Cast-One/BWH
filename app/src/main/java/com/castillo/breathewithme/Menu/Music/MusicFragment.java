package com.castillo.breathewithme.Menu.Music;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.castillo.breathewithme.Menu.Models.ItemMusic;
import com.castillo.breathewithme.R;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    RecyclerView recyclerView;
    List<ItemMusic> list_Music = new ArrayList<>();
    ReprouccionRecyclerViewAdapter adapter;

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        TextView text_title = view.findViewById(R.id.text_title);
        TextView text_description = view.findViewById(R.id.text_description);
        EditText edit_search = view.findViewById(R.id.edit_search);
        recyclerView = view.findViewById(R.id.list);

        for (int i = 0; i < 10; i++) {
            list_Music.add(new ItemMusic("", "Titulo" + i, "Descripción " + i));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ReprouccionRecyclerViewAdapter(list_Music, getContext());
        recyclerView.setAdapter(adapter);

        text_title.setText(R.string.title_music);
        text_description.setText(R.string.music_description);

        return view;
    }
}