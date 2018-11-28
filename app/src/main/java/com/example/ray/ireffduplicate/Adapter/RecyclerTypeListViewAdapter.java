package com.example.ray.ireffduplicate.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ray.ireffduplicate.R;

import java.util.List;

public class RecyclerTypeListViewAdapter extends RecyclerView.Adapter<RecyclerTypeListViewAdapter.myViewHolder> {
    private List<String> list;

    public RecyclerTypeListViewAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerTypeListViewAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_network_type_list, parent, false);
        RecyclerTypeListViewAdapter.myViewHolder myViewHolder = new RecyclerTypeListViewAdapter.myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerTypeListViewAdapter.myViewHolder holder, int position) {
        holder.networkTypeList.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView networkTypeList;

        public myViewHolder(View view) {
            super(view);
            networkTypeList = view.findViewById(R.id.networkTypeList);
        }
    }
}
