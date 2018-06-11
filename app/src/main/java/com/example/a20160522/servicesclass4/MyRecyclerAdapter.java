package com.example.a20160522.servicesclass4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder> {

    private ArrayList<Fruta> items;

    public MyRecyclerAdapter(List<Fruta> items) {
        this.items = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public MyRecycleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_my_card_view, parent, false);
        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view);
        return holder;
    }

    @Override public void onBindViewHolder(@NonNull MyRecycleItemViewHolder holder, int position) {
        Fruta fruta = items.get(position);
        holder.name.setText(fruta.getName());
        holder.description.setText(fruta.getDescription());
        Glide.with(holder.itemView).load(fruta.getImage_url()).into(holder.imageFromUrl);
    }

    @Override public int getItemCount() { return items.size(); }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        String imageUrl;
        ImageView imageFromUrl;

        public MyRecycleItemViewHolder(View itemView) {
            super(itemView);
            imageFromUrl = (ImageView) itemView.findViewById(R.id.my_image_view);
            name = (TextView) itemView.findViewById(R.id.my_name_text_view);
            description = (TextView) itemView.findViewById(R.id.my_description_text_view);
        }
    }
}
