package com.example.ray.ifduplicate;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ray.ifduplicate.Adapter.ViewPageAdapter;

import java.util.List;

public class TabViewPage extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    public static ViewPageAdapter viewPageAdapter;
    private FragmentManager fragmentManager;
    private List<String> tabsList;

    public void loadTabViewPage(FragmentManager fm, List<String> tabsList) {
        this.tabsList = tabsList;
        fragmentManager = fm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_view_page, container, false);
        viewPageAdapter = new ViewPageAdapter(fragmentManager, tabsList);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPageAdapter);
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
