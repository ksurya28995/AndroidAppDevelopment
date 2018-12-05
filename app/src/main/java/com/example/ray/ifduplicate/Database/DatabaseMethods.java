package com.example.ray.ifduplicate.Database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMethods {

    private static List<String>tabsList = new ArrayList<>();

    public static List<String> getTablist(DataSnapshot dataSnapshot) {
        IdeaTabVariables dbVariables = new IdeaTabVariables();
        DataSnapshot dsTabList = dataSnapshot.child("/TabLists");
        tabsList.clear();
        for (DataSnapshot ds : dsTabList.getChildren()){
            dbVariables.setTabName(ds.getValue(IdeaTabVariables.class).getTabName());
            Log.d("DB", "showTabListData: " + dbVariables.getTabName());
            tabsList.add(dbVariables.getTabName());
        }
        return tabsList;
    }
}
