package com.castillo.breathewithme.Menu.Music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.castillo.breathewithme.R;

public class ReproductorActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView button_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        button_play = findViewById(R.id.button_play);
        mediaPlayer = MediaPlayer.create(ReproductorActivity.this, R.raw.sound);

        listeners();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) mediaPlayer.release();
    }

    void listeners(){
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null){
                    mediaPlayer.start();
                }

//                if (mediaPlayer.isPlaying()){
//                    button_play.setImageResource(R.drawable.ic_pause);
//                    mediaPlayer.pause();
//                }else{
//                    mediaPlayer.start();
//                    button_play.setImageResource(R.drawable.ic_play);
//                }

            }
        });
    }
}