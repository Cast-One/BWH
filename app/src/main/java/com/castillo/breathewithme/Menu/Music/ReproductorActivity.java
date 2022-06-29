package com.castillo.breathewithme.Menu.Music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.castillo.breathewithme.R;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

import java.io.IOException;

public class ReproductorActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView button_play;
    String myUri;
    SeekBar seekbar_player;
    TextView textCurrentTime;
    TextView textTotalDuration;
    //        prepareMediaPlayer();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        button_play = findViewById(R.id.button_play);
        textCurrentTime = findViewById(R.id.textCurrentTime);
        textTotalDuration = findViewById(R.id.textTotalDuration);
        seekbar_player = findViewById(R.id.seekbar_player);

//        mediaPlayer = new MediaPlayer();

        listeners();
        prepareMediaPlayerLocal();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            button_play.setImageResource(R.drawable.ic_pause);
            updateSeekBar();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            button_play.setImageResource(R.drawable.ic_play);
        }
    }

    @Override
    public void onDestroy(){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
        super.onDestroy();
    }

    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
            if(mediaPlayer != null){
                long currentDuration = mediaPlayer.getCurrentPosition();
                textCurrentTime.setText(milliSecondsToTimer(currentDuration));
            }
        }
    };

    private void updateSeekBar(){
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                seekbar_player.setProgress((int)(((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
                handler.postDelayed(updater,1000);
            }
        }
    }

    private String milliSecondsToTimer(long milliseconds){
        String timerString = "";
        String secondsString= "";
        int hours = (int) ((milliseconds / (100 * 60 * 60 )));
        int minutes = (int) ((milliseconds % (100 * 60 * 60 )) / (1000 * 60));
        int seconds = (int) ((milliseconds % (100 * 60 * 60 )) % (1000 * 60) /1000);

        if(hours > 0){
            timerString = hours + ":";
        }else{
            secondsString = "00:";
        }
        if(seconds < 10){
            secondsString = secondsString + "0" + seconds;
        }else{
            secondsString = ""+seconds;
        }
        timerString = timerString + minutes+":"+secondsString;
        return timerString;
    }

    private void listeners() {
        new ClickShrinkEffect(button_play);
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    button_play.setImageResource(R.drawable.ic_play);
                }else {
                    button_play.setImageResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    updateSeekBar();
                }
            }
        });

    }

    void prepareMediaPlayerLocal(){
        mediaPlayer = MediaPlayer.create(ReproductorActivity.this, R.raw.linkin_park_final_masquerade);
        textTotalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
    }


    void prepareMediaPlayer(){
        myUri = "https://file-examples.com/storage/fe6916ffee62b87a8a0091a/2017/11/file_example_MP3_1MG.mp3"; // initialize Uri here
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource( myUri);
            mediaPlayer.prepare();
            textTotalDuration.setText(milliSecondsToTimer( mediaPlayer.getDuration()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}