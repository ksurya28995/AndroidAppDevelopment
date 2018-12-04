package com.example.ray.ifduplicate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ray.ifduplicate.Database.DatabaseMethods;
import com.example.ray.ifduplicate.Database.initializeDB.DatabaseInitialization;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private List<String> tabsList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private SharedPreferenceConfig preferenceConfig;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton drawerButton, networkSelectionBtn;
    private int messageCode = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Shared preferences Initialization
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        /*
        //Database Initializtion
        DatabaseInitialization dbInitialize = new DatabaseInitialization(getApplicationContext());

        preferenceConfig.setCurrentNetwork("/Idea");
        dbInitialize.addIdeaTabs();
        dbInitialize.addIdeaTabContentsData();

        preferenceConfig.setCurrentNetwork("/Vodafone");
        dbInitialize.addVodafoneTabs();
        dbInitialize.addVodafoneTabContentsData();
        */
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        drawerButton = findViewById(R.id.drawerButton);
        fragmentManager = getSupportFragmentManager();
        networkSelectionBtn = findViewById(R.id.networkSelectionBtn);

        drawerButton.setOnClickListener(this);
        networkSelectionBtn.setOnClickListener(this);

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

    public void tabsInflate() {
        if (findViewById(R.id.mainFragContainer) != null) {
            TabViewPage tabViewPage = new TabViewPage();
            tabViewPage.TabViewPage(getSupportFragmentManager(), tabsList);
            fragmentManager.beginTransaction().add(R.id.mainFragContainer, tabViewPage, "Tabs").commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drawerButton:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.networkSelectionBtn:
                startActivityForResult(new Intent(this, NetworkSelection.class), messageCode);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == messageCode) {
            if (resultCode == RESULT_OK) {
                preferenceConfig.setCurrentNetwork(data.getStringExtra("currentNetwork"));
                databaseReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork());

            }
        }
        Log.d("newNetworkSelected", "network: "+preferenceConfig.getCurrentNetwork());
    }
}

