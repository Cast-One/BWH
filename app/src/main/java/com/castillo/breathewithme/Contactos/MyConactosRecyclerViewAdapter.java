package com.castillo.breathewithme.Contactos;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.castillo.breathewithme.Menu.Models.ItemContacto;
import com.castillo.breathewithme.databinding.FragmentContactosBinding;

import java.util.List;

public class MyConactosRecyclerViewAdapter extends RecyclerView.Adapter<MyConactosRecyclerViewAdapter.ViewHolder> {

    private final List<ItemContacto> mValues;

    public MyConactosRecyclerViewAdapter(List<ItemContacto> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentContactosBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.text_name.setText(holder.mItem.getName());
        holder.text_phone.setText(holder.mItem.getTelefono());

        holder.image_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("llamnado a " + holder.mItem.getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView text_name;
        public final TextView text_phone;
        public final ImageView image_phone;

        public ItemContacto mItem;

        public ViewHolder(FragmentContactosBinding binding) {
            super(binding.getRoot());
            text_name = binding.textName;
            text_phone = binding.textPhone;
            image_phone = binding.imagePhone;
        }

    }
}