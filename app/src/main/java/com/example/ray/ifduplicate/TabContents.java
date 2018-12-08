package com.example.ray.ifduplicate;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ray.ifduplicate.Adapter.RecyclerViewAdapter_WithTalktime;
import com.example.ray.ifduplicate.Adapter.RecyclerViewAdapter_WithoutTalktime;
import com.example.ray.ifduplicate.Adapter.ViewPageAdapter;
import com.example.ray.ifduplicate.Database.DatabaseMethods;
import com.example.ray.ifduplicate.Database.PackDetailsVariables;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TabContents extends Fragment {

    public static RecyclerViewAdapter_WithTalktime recyclerAdapterWithTalktime = new RecyclerViewAdapter_WithTalktime(null);
    public static RecyclerViewAdapter_WithoutTalktime recyclerAdapterWithoutTalktime = new RecyclerViewAdapter_WithoutTalktime(null );
    private List<PackDetailsVariables> tabDataArray = new ArrayList<>();
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tablist_layout, container, false);
        bundle = null;
        bundle = getArguments();
        String currentTab = null;
        currentTab = bundle.getString("currentTab");
        tabDataArray = null;
        tabDataArray = DatabaseMethods.loadPacksData(currentTab);
        recyclerView = view.findViewById(R.id.recyclerContainer);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        if (currentTab.contains("Home")) {

        } else if (currentTab.contains("Topup")) {
            recyclerAdapterWithTalktime = null;
            recyclerAdapterWithTalktime = new RecyclerViewAdapter_WithTalktime(tabDataArray);
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(recyclerAdapterWithTalktime);
        } else {
            recyclerAdapterWithoutTalktime = null;
            recyclerAdapterWithoutTalktime = new RecyclerViewAdapter_WithoutTalktime(tabDataArray);
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(recyclerAdapterWithoutTalktime);
        }
        return view;
    }

}

