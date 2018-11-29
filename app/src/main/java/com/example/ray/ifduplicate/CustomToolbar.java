package com.example.ray.ifduplicate;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class CustomToolbar extends Fragment implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton  drawerButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
        drawerLayout = view.findViewById(R.id.drawer);
        navigationView = view.findViewById(R.id.navigationView);
        drawerButton =  view.findViewById(R.id.drawerButton);
        drawerButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.drawerButton:
                drawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
