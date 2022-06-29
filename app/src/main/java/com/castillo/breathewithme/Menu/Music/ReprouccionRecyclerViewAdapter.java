package com.castillo.breathewithme.Menu.Music;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castillo.breathewithme.Menu.Models.ItemMusic;
import com.castillo.breathewithme.ToolsApp.Tools;
import com.castillo.breathewithme.databinding.FragmentReproduccionBinding;
import java.util.List;

public class ReprouccionRecyclerViewAdapter extends RecyclerView.Adapter<ReprouccionRecyclerViewAdapter.ViewHolder> {

    private final List<ItemMusic> mValues;
    Activity menuActivity;
    Context context;

    public ReprouccionRecyclerViewAdapter(List<ItemMusic> items, Context context) {
        mValues = items;
        this.context = context;
        menuActivity = (Activity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentReproduccionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.text_title_album.setText(holder.mItem.getTitle());
        holder.text_cont_album.setText(holder.mItem.getDescription());

        holder.button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.nextActivity(ReproductorActivity.class, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;

        public final ImageView image_album;
        public final TextView text_title_album;
        public final TextView text_cont_album;
        public final ImageView button_play;
        public ItemMusic mItem;

        public ViewHolder(FragmentReproduccionBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            image_album = binding.imageAlbum;
            text_title_album = binding.textTitleAlbum;
            text_cont_album = binding.textContAlbum;
            button_play = binding.buttonPlay;

        }
    }
}