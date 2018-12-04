package com.example.ray.ifduplicate.Adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.ray.ifduplicate.TabContents;

import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private List<String> tabLists;

    public ViewPageAdapter(FragmentManager fm, List<String> tabLists) {
        super(fm);
        this.tabLists = tabLists;
    }

    @Override
    public Fragment getItem(int position) {
        TabContents tabContents = new TabContents();
        Bundle bundle = new Bundle();
        bundle.putString("currentTab", "/Details/" + tabLists.get(position));
        Log.d("eachTab", "getItem: " + tabLists.get(position));
        tabContents.setArguments(bundle);
        return tabContents;
    }

    @Override
    public int getCount() {
        return tabLists.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabLists.get(position);
    }
}
