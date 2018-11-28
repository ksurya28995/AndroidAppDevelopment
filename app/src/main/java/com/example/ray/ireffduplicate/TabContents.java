package com.example.ray.ireffduplicate;


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

import com.example.ray.ireffduplicate.Adapter.RecyclerViewAdapter;
import com.example.ray.ireffduplicate.Database.DatabaseConstants;
import com.example.ray.ireffduplicate.Database.PackDetailsVariables;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TabContents extends Fragment {

    private RecyclerViewAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private String currentTab;
    private SharedPreferenceConfig preferenceConfig;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseReference databaseReference;
    List<PackDetailsVariables> tabContentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tablist_layout, container, false);
        preferenceConfig = new SharedPreferenceConfig(getContext());
        Bundle bundle = getArguments();
        currentTab = bundle.getString("currentTab");
        Log.d("nowTab", "onCreateView: "+currentTab);
        recyclerView = view.findViewById(R.id.recyclerContainer);
        Log.d("currNet", "onCreateView: "+preferenceConfig.getCurrentNetwork());
        databaseReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                DataSnapshot ds = dataSnapshot.child(currentTab);
                for (DataSnapshot each : ds.getChildren()) {
                    PackDetailsVariables pkVariables = new PackDetailsVariables();
                    pkVariables.setPrice(each.getValue(PackDetailsVariables.class).getPrice());
                    pkVariables.setTalktime(each.getValue(PackDetailsVariables.class).getTalktime());
                    pkVariables.setValidity(each.getValue(PackDetailsVariables.class).getValidity());
                    pkVariables.setMessage(each.getValue(PackDetailsVariables.class).getMessage());
                    tabContentList.add(pkVariables);
                    Log.d("nowdetails", "onDataChange: "+tabContentList);
                }
                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                recyclerAdapter = new RecyclerViewAdapter(tabContentList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return view;
    }

}
