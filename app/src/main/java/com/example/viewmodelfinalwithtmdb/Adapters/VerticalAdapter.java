package com.example.viewmodelfinalwithtmdb.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelfinalwithtmdb.Models.VerticalModels;
import com.example.viewmodelfinalwithtmdb.R;
import com.example.viewmodelfinalwithtmdb.UI.More;

import java.util.ArrayList;
import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {
    Context context;
    List<VerticalModels> verticalModelsList;

    public VerticalAdapter(Context context, List<VerticalModels> verticalModelsList) {
        this.context = context;
        this.verticalModelsList = verticalModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.verticallistitem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
holder.tvTitle.setText(verticalModelsList.get(position).getTitle());
holder.tvMore.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(v.getContext(), More.class);
        i.putParcelableArrayListExtra("model", (ArrayList<? extends Parcelable>) verticalModelsList.get(position).getHorizontalModelsList());
        v.getContext().startActivity(i);
    }
});
holder.rvHoriznotal.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
holder.rvHoriznotal.setHasFixedSize(true);
holder.rvHoriznotal.setAdapter(new HorizontalAdapter(verticalModelsList.get(position).getHorizontalModelsList()));
    }

    @Override
    public int getItemCount() {
        return verticalModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvMore;
        RecyclerView rvHoriznotal;
        public ViewHolder(@NonNull View v) {
            super(v);
            tvTitle=v.findViewById(R.id.tvTitle);
            tvMore=v.findViewById(R.id.tvMore);
            rvHoriznotal=v.findViewById(R.id.rvHorizontal);
        }
    }
}
