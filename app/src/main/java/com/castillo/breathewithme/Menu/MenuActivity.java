package com.castillo.breathewithme.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.castillo.breathewithme.Menu.Music.MusicFragment;
import com.castillo.breathewithme.R;
import com.castillo.breathewithme.ToolsApp.Tools;

public class MenuActivity extends AppCompatActivity {

    MusicFragment musicFragment;
    HomeFragment homeFragment;
    AnimateStateFragment animateStateFragment;

    //Items menu
    ImageView item_home;
    ImageView item_play;
    ImageView item_user;
    ImageView item_leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        musicFragment = new MusicFragment();
        homeFragment = new HomeFragment();
        animateStateFragment = new AnimateStateFragment();

        item_home = findViewById(R.id.item_home);
        item_play = findViewById(R.id.item_play);
        item_user = findViewById(R.id.item_user);
        item_leave = findViewById(R.id.item_leave);
        listeners();
    }

    void listeners(){
        item_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflar home
                Tools.openFragment(R.id.fragment_menu,homeFragment,getSupportFragmentManager().beginTransaction());
            }
        });

        item_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.openFragment(R.id.fragment_menu, musicFragment, getSupportFragmentManager().beginTransaction());
            }
        });
        item_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.openFragment(R.id.fragment_menu, animateStateFragment, getSupportFragmentManager().beginTransaction());
            }
        });

        item_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}