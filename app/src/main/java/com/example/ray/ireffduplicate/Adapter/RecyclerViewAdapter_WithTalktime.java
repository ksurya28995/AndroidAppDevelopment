package com.example.ray.ireffduplicate.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ray.ireffduplicate.Database.PackDetailsVariables;
import com.example.ray.ireffduplicate.R;

import java.util.List;

public class RecyclerViewAdapter_WithTalktime extends RecyclerView.Adapter<RecyclerViewAdapter_WithTalktime.myViewHolder> {
    private List<PackDetailsVariables> list;

    public RecyclerViewAdapter_WithTalktime(List<PackDetailsVariables> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_list_with_talktime_layout, parent, false);
        myViewHolder myViewHolder = new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.price.setText(list.get(position).getPrice());
        holder.validity.setText(list.get(position).getValidity());
        holder.talktime.setText(list.get(position).getTalktime());
        holder.message.setText(list.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        TextView validity;
        TextView talktime;
        TextView message;
        public myViewHolder(View view) {
            super(view);
            price = view.findViewById(R.id.price);
            validity = view.findViewById(R.id.validity);
            talktime = view.findViewById(R.id.talktime);
            message = view.findViewById(R.id.message);
        }
    }
}
