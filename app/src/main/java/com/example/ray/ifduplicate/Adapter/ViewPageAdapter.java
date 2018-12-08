package com.example.ray.ifduplicate.Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.ray.ifduplicate.TabContents;

import java.util.List;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    private List<String> tabLists;
    private Bundle bundle;
    private TabContents tabContents;

    public ViewPageAdapter(FragmentManager fm, List<String> tabLists) {
        super(fm);
        this.tabLists = tabLists;
    }

    @Override
    public Fragment getItem(int position) {
        tabContents = null;
        tabContents = new TabContents();
        bundle = null;
        bundle = new Bundle();
        Log.d("currentTabNow", "tab name: " + tabLists.get(position));
        bundle.putString("currentTab", tabLists.get(position));
        tabContents.setArguments(bundle);
        return tabContents;
    }

    @Override
    public int getCount() {
        return tabLists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLists.get(position);
    }

}
