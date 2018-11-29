package com.example.ray.ifduplicate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ray.ifduplicate.Adapter.ListViewAdapter;

import java.util.Arrays;
import java.util.List;

public class NetworkTypeList extends Fragment {

    private ListViewAdapter listViewAdapter;
    private List<String>networkTypeList;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network_type_list, container, false);
        networkTypeList = Arrays.asList(getResources().getStringArray(R.array.ideaNetOffers));
        listViewAdapter = new ListViewAdapter(view.getContext(), networkTypeList);
        listView = view.findViewById(R.id.typelist);
        listView.setAdapter(listViewAdapter);
        return view;
    }

}
