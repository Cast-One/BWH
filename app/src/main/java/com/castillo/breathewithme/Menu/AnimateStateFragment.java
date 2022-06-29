package com.castillo.breathewithme.Menu;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.castillo.breathewithme.R;
import com.hsalf.smileyrating.SmileyRating;

public class AnimateStateFragment extends Fragment {

    SeekBar seekBar;
    SmileyRating smile_rating;
    TextView text_state;
    MenuActivity activity;

    public AnimateStateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animate_state, container, false);
        smile_rating = view.findViewById(R.id.smile_rating);
        text_state = view.findViewById(R.id.text_state);
        seekBar = view.findViewById(R.id.seekBar);
        seekBar.setMax(5);
        seekBar.setMin(1);
        activity = (MenuActivity)getContext();
        smile_rating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {
                switch (type.getRating()){
                    case 1:
                        text_state.setText("Terrible");
                        break;
                    case 2:
                        text_state.setText("mal");
                        break;
                    case 3:
                        text_state.setText("normal");
                        break;
                    case 4:
                        text_state.setText("bien");
                        break;
                    case 5:
                        text_state.setText("super bien");
                        break;

                }
                seekBar.setProgress(type.getRating());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if(i != 0){
                    smile_rating.setRating(i, true);
                }else{
                    smile_rating.setRating(1, true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        customBar();
        return view;
    }

    private void customBar() {
        smile_rating.setTitle(SmileyRating.Type.GREAT, "Awesome");
        smile_rating.setFaceColor(SmileyRating.Type.GREAT, activity.getColor(R.color.black));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.GREAT, activity.getColor(R.color.white));
        smile_rating.setFaceColor(SmileyRating.Type.BAD, activity.getColor(R.color.black));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.BAD, activity.getColor(R.color.white));
        smile_rating.setFaceColor(SmileyRating.Type.GOOD, activity.getColor(R.color.black));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.GOOD, activity.getColor(R.color.white));
        smile_rating.setFaceColor(SmileyRating.Type.OKAY, activity.getColor(R.color.black));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.OKAY, activity.getColor(R.color.white));
        smile_rating.setFaceColor(SmileyRating.Type.TERRIBLE, activity.getColor(R.color.black));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.TERRIBLE, activity.getColor(R.color.white));
        smile_rating.setFaceColor(SmileyRating.Type.NONE, activity.getColor(R.color.red));
        smile_rating.setFaceBackgroundColor(SmileyRating.Type.NONE, activity.getColor(R.color.red));
    }


}