package com.example.ray.ifduplicate.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ray.ifduplicate.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    private Context context;
    private List<String>list;
    private TextView textView;

    public ListViewAdapter(Context context, List<String>list) {
        super(context, R.layout.fragment_network_type_list, list);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_network_type_list, parent, false);
        textView = view.findViewById(R.id.networkTypeList);
        textView.setText(list.get(position));
        return view;
    }


}
