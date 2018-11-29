package com.example.ray.ifduplicate;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ray.ifduplicate.Database.DatabaseMethods;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private List<String> tabsList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        //toolbar inflation
        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.toolbarContainer) != null) {
            fragmentManager.beginTransaction().add(R.id.toolbarContainer, new CustomToolbar(), "toolbar").commit();
        }

        //Database Initializtion
        /*DatabaseInitialization dbInitialize = new DatabaseInitialization(getApplicationContext());
        dbInitialize.addIdeaTabs();
        dbInitialize.addTabContentsData();*/


        databaseReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tabsList = DatabaseMethods.getTablist(dataSnapshot);
                tabsInflate();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void tabsInflate(){
        if (findViewById(R.id.mainFragContainer) != null) {
            TabViewPage tabViewPage = new TabViewPage();
            tabViewPage.TabViewPage(getSupportFragmentManager(), tabsList);
            fragmentManager.beginTransaction().add(R.id.mainFragContainer, tabViewPage, "Tabs").commit();
        }
    }

}

