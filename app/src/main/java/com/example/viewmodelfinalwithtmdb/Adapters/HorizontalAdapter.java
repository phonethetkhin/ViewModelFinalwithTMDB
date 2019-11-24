package com.example.viewmodelfinalwithtmdb.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelfinalwithtmdb.Models.HorizontalModels;
import com.example.viewmodelfinalwithtmdb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
   List<HorizontalModels> horizontalModelsList;

    public HorizontalAdapter(List<HorizontalModels> horizontalModelsList) {
        this.horizontalModelsList = horizontalModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontallistitem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+horizontalModelsList.get(position).getPhoto()).into(holder.imgPhoto);
        holder.tvName.setText(horizontalModelsList.get(position).getName());
        holder.tvRating.setText("★ "+horizontalModelsList.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return horizontalModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvRating;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgPhoto=v.findViewById(R.id.imgPhoto);
            tvName=v.findViewById(R.id.tvName);
            tvRating=v.findViewById(R.id.tvRating);
        }
    }
}
