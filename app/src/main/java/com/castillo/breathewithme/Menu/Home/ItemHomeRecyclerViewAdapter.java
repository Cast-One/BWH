package com.castillo.breathewithme.Menu.Home;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castillo.breathewithme.Menu.Models.ItemHome;
import com.castillo.breathewithme.R;
import com.castillo.breathewithme.databinding.FragmentItemHomeBinding;

import java.util.List;

public class ItemHomeRecyclerViewAdapter extends RecyclerView.Adapter<ItemHomeRecyclerViewAdapter.ViewHolder> {

    private final List<ItemHome> mValues;

    public ItemHomeRecyclerViewAdapter(List<ItemHome> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentItemHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.texto.setText(holder.mItem.getTitulo());
        holder.image.setImageResource(holder.mItem.getImagen());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemHome mItem;
        ImageView image;
        TextView texto;

        public ViewHolder(FragmentItemHomeBinding binding) {
            super(binding.getRoot());

            image = binding.imageHome;
            texto = binding.textTitle;

        }

    }
}