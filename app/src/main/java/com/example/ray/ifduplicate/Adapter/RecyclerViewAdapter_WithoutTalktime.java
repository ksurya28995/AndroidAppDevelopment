package com.example.ray.ifduplicate.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ray.ifduplicate.Database.PackDetailsVariables;
import com.example.ray.ifduplicate.R;

import java.util.List;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

public class RecyclerViewAdapter_WithoutTalktime extends RecyclerView.Adapter<RecyclerViewAdapter_WithoutTalktime.myViewHolder> {
    private List<PackDetailsVariables> list;

    public RecyclerViewAdapter_WithoutTalktime(List<PackDetailsVariables> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_list_without_talktime_layout, parent, false);
        myViewHolder myViewHolder = new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.price.setText(list.get(position).getPrice());
        holder.validity.setText(list.get(position).getValidity());
        holder.message.setText(list.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        TextView validity;
        TextView message;
        public myViewHolder(View view) {
            super(view);
            price = view.findViewById(R.id.price);
            validity = view.findViewById(R.id.validity);
            message = view.findViewById(R.id.message);
        }
    }

}
