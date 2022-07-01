package com.castillo.breathewithme.Menu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.castillo.breathewithme.Contactos.MyConactosRecyclerViewAdapter;
import com.castillo.breathewithme.Menu.Models.ItemContacto;
import com.castillo.breathewithme.R;
import com.hsalf.smileyrating.SmileyRating;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

import java.util.ArrayList;

public class AnimateStateFragment extends Fragment {

    SeekBar seekBar;
    SmileyRating smile_rating;
    TextView text_state;
    MenuActivity activity;

    TextView button_addContact;

    ArrayList<ItemContacto> listItemsContactos;
    RecyclerView recyclerViewContactos;
    MyConactosRecyclerViewAdapter adapterContactos;

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
        button_addContact = view.findViewById(R.id.button_addContact);
        seekBar = view.findViewById(R.id.seekBar);
        seekBar.setMax(5);
        seekBar.setMin(1);
        activity = (MenuActivity)getContext();

        listItemsContactos = new ArrayList<>();
        fillList();

        recyclerViewContactos = view.findViewById(R.id.list);
        recyclerViewContactos.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterContactos = new MyConactosRecyclerViewAdapter(listItemsContactos);
        recyclerViewContactos.setAdapter(adapterContactos);

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
        listeners();
        return view;
    }

    private void listeners() {
        new ClickShrinkEffect(button_addContact);
        button_addContact.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                //abrir alerta
                openDialog();
            }
        });

    }

    void openDialog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.alert_add_contact_layout);
        dialog.getWindow().setBackgroundDrawable(activity.getDrawable(R.drawable.back_dialog));

        EditText edit_name = dialog.findViewById(R.id.edit_name);
        EditText edit_phone = dialog.findViewById(R.id.edit_phone);
        TextView button_add = dialog.findViewById(R.id.button_add);
        dialog.setCancelable(false);
        dialog.show();

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                String phone = edit_phone.getText().toString();
                addContact(name,phone);
                dialog.dismiss();
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    void addContact(String name , String phone){
        if(!name.isEmpty() && !phone.isEmpty() ){
            listItemsContactos.add(new ItemContacto(name,phone));
            adapterContactos.notifyDataSetChanged();
        }
    }

    private void fillList() {
        listItemsContactos.add(new ItemContacto("Uriel", "5556139494"));
        listItemsContactos.add(new ItemContacto("Gabi", "55561300000"));
        listItemsContactos.add(new ItemContacto("Lis", "55561311111"));
        listItemsContactos.add(new ItemContacto("Mariam", "555612222"));
        listItemsContactos.add(new ItemContacto("Andres", "5556555555"));
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