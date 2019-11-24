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

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {

List<HorizontalModels> horizontalModelsList;

    public MoreAdapter(List<HorizontalModels> horizontalModelsList) {
        this.horizontalModelsList = horizontalModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.morelistitem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(horizontalModelsList.get(position).getName());
        holder.tvRating.setText(horizontalModelsList.get(position).getRating()+"");
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+horizontalModelsList.get(position).getPhoto()).into(holder.imgPhoto);

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
