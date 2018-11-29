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
        for (DataSnapshot ds : dsTabList.getChildren()){
            dbVariables.setTabName(ds.getValue(IdeaTabVariables.class).getTabName());
            Log.d("DB", "showTabListData: " + dbVariables.getTabName());
            tabsList.add(dbVariables.getTabName());
        }
        return tabsList;
    }

    public static void addToDatabase(DatabaseReference databaseReference, String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        databaseReference.push().setValue(map);
    }

    public static void addToDatabase(DatabaseReference databaseReference, Map<String, PackDetailsVariables>map) {
        databaseReference.setValue(map);
    }
}
