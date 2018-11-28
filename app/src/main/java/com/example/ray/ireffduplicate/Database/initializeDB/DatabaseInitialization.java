package com.example.ray.ireffduplicate.Database.initializeDB;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ray.ireffduplicate.Database.DatabaseConstants;
import com.example.ray.ireffduplicate.Database.DatabaseMethods;
import com.example.ray.ireffduplicate.Database.PackDetailsVariables;
import com.example.ray.ireffduplicate.SharedPreferenceConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseInitialization {

    private DatabaseReference dbReference;
    private SharedPreferenceConfig preferenceConfig;

    public DatabaseInitialization(Context context) {
        preferenceConfig = new SharedPreferenceConfig(context);
    }
/*

    public void addTabContentsData() {
        addIdeaTopupPacksContents();
    }

    public void addIdeaTopupPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/Topup");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdea2gPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdea4gPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaLocalPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaStdPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaSmsPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.42 Talktime", ""));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", ""));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public List<String> addIdeaTabs() {
        Log.d("yes", "addIdeaTabs: " + preferenceConfig.getCurrentNetwork() + DatabaseConstants.TAB_LISTS);
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + DatabaseConstants.TAB_LISTS);
        List<String> list = new ArrayList<>();
        list.add("Home");
        list.add("Topup");
        list.add("2G");
        list.add("4G");
        list.add("Local");
        list.add("STD");
        list.add("SMS");
        list.add("Other");
        for (String each : list)
            DatabaseMethods.addToDatabase(dbReference, DatabaseConstants.IDEA_TAB_NAME_KEY, each);
        return list;
    }
*/

}
