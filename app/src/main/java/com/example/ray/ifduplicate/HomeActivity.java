package com.example.ray.ifduplicate;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
    private TextView networkName;
    private String currentNetwork;

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

        networkName = findViewById(R.id.networkName);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        drawerButton = findViewById(R.id.drawerButton);
        fragmentManager = getSupportFragmentManager();
        networkSelectionBtn = findViewById(R.id.networkSelectionBtn);
        currentNetwork = preferenceConfig.getCurrentNetwork();

        networkName.setText(preferenceConfig.getCurrentNetwork().replaceAll("/", ""));
        drawerButton.setOnClickListener(this);
        networkSelectionBtn.setOnClickListener(this);

        loadMainPage();
    }

    public void tabsInflation() {
        if (findViewById(R.id.mainFragContainer) != null) {
            TabViewPage tabViewPage = new TabViewPage();
            tabViewPage.TabViewPage(getSupportFragmentManager(), tabsList);
            fragmentManager.beginTransaction().add(R.id.mainFragContainer, tabViewPage, "Tabs").addToBackStack(null).commit();
        }
    }

    public void tabsReinflation() {
        if (findViewById(R.id.mainFragContainer) != null) {
            TabViewPage tabViewPage = new TabViewPage();
            tabViewPage.TabViewPage(getSupportFragmentManager(), tabsList);
            fragmentManager.beginTransaction().replace(R.id.mainFragContainer, tabViewPage, "Tabs").commit();
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
                if (!currentNetwork.equals(data.getStringExtra("currentNetwork"))) {
                    preferenceConfig.setCurrentNetwork(data.getStringExtra("currentNetwork"));
                    currentNetwork = data.getStringExtra("currentNetwork");
                    networkName.setText(preferenceConfig.getCurrentNetwork().replaceAll("/", ""));
                    reloadMainPage();
                }
            }
        }
        Log.d("newNetworkSelected", "network: " + preferenceConfig.getCurrentNetwork());
    }

    public void loadMainPage() {
        databaseReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tabsList = DatabaseMethods.getTablist(dataSnapshot);
                tabsInflation();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void reloadMainPage() {
        databaseReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tabsList = DatabaseMethods.getTablist(dataSnapshot);
                TabViewPage.viewPageAdapter.notifyDataSetChanged();
                TabContents.recyclerAdapterWithoutTalktime.notifyDataSetChanged();
                TabContents.recyclerAdapterWithTalktime.notifyDataSetChanged();
                tabsReinflation();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

