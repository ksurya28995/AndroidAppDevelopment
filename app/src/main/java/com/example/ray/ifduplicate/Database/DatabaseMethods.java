package com.example.ray.ifduplicate.Database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatabaseMethods {

    private static List<String> tabsList = new ArrayList<>();
    private static List<PackDetailsVariables> eachTabData = new ArrayList<>();
    private static LinkedHashMap<String, PackDetailsVariables> packsData = new LinkedHashMap<>();

    public static List<String> getTablist(DataSnapshot dataSnapshot) {
        IdeaTabVariables dbVariables = new IdeaTabVariables();
        DataSnapshot dsTabList = dataSnapshot.child("/TabLists");
        tabsList.clear();
        for (DataSnapshot ds : dsTabList.getChildren()) {
            dbVariables.setTabName(ds.getValue(IdeaTabVariables.class).getTabName());
            Log.d("PacksGroup", "TabsList: " + dbVariables.getTabName());
            tabsList.add(dbVariables.getTabName());
        }
        return tabsList;
    }

    public static LinkedHashMap<String, PackDetailsVariables> getTabsContentDatalist(DataSnapshot dataSnapshot) {
        packsData.clear();
        DataSnapshot ds = dataSnapshot.child("/Details");
        for (DataSnapshot each : ds.getChildren()) {
            PackDetailsVariables pkVariables = new PackDetailsVariables();
            pkVariables.setPrice(each.getValue(PackDetailsVariables.class).getPrice());
            pkVariables.setTalktime(each.getValue(PackDetailsVariables.class).getTalktime());
            pkVariables.setValidity(each.getValue(PackDetailsVariables.class).getValidity());
            pkVariables.setMessage(each.getValue(PackDetailsVariables.class).getMessage());
            pkVariables.setCategory(each.getValue(PackDetailsVariables.class).getCategory());
            packsData.put(pkVariables.getPrice(), pkVariables);
        }
        for (Map.Entry<String, PackDetailsVariables> eachMap : packsData.entrySet()) {
            Log.d("Packs", "Key: " + eachMap.getKey());
            Log.d("Packs", "PackObjects: " + eachMap.getValue());
        }
        return packsData;
    }

    public static void addToDatabase(DatabaseReference databaseReference, String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        databaseReference.push().setValue(map);
    }

    public static void addToDatabase(DatabaseReference databaseReference, Map<String, PackDetailsVariables> map) {
        databaseReference.setValue(map);
    }

    public static List<PackDetailsVariables> loadPacksData(String currentTab){
        eachTabData.clear();
        for (LinkedHashMap.Entry<String, PackDetailsVariables> each : packsData.entrySet()) {
            if (each.getValue().getCategory().contains(currentTab)) {
                eachTabData.add(each.getValue());
            }
        }
        return eachTabData;

    }

}
