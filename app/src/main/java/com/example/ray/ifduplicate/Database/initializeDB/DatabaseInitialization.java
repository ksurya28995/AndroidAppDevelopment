package com.example.ray.ifduplicate.Database.initializeDB;

import android.content.Context;
import android.util.Log;

import com.example.ray.ifduplicate.Database.DatabaseConstants;
import com.example.ray.ifduplicate.Database.DatabaseMethods;
import com.example.ray.ifduplicate.Database.PackDetailsVariables;
import com.example.ray.ifduplicate.SharedPreferenceConfig;
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
            DatabaseMethods.addToDatabase(dbReference, DatabaseConstants.TAB_NAME_KEY, each);
        return list;
    }

    public List<String> addVodafoneTabs() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + DatabaseConstants.TAB_LISTS);
        List<String> list = new ArrayList<>();
        list.add("Home");
        list.add("Topup");
        list.add("2G");
        list.add("3G");
        list.add("4G");
        list.add("Local");
        list.add("STD");
        list.add("SMS");
        list.add("Other");
        for (String each : list)
            DatabaseMethods.addToDatabase(dbReference, DatabaseConstants.TAB_NAME_KEY, each);
        return list;
    }

    public void addIdeaPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("9", new PackDetailsVariables("9", "1 day", "", "2G/4G Data: 100 MB; Local, STD & Roaming Calls: Unlimited; All SMS: 100 SMS", "2G, 4G, Local"));
        map.put("10", new PackDetailsVariables("10", "Lifetime", "6.42 Talktime", "", "Topup"));
        map.put("16", new PackDetailsVariables("16", "1 day", "", "2G/4G Data: 1 GB", "2G, 4G"));
        map.put("19", new PackDetailsVariables("19", "2 days", "", "2G/4G Data: 150 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 200 SMS", "Local, 2G, 4G"));
        map.put("28", new PackDetailsVariables("28", "28 days", "", "2G/4G Data: 500 MB", "2G, 4G"));
        map.put("33", new PackDetailsVariables("33", "28 days", "", "All SMS: 350 SMS", "SMS"));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0", "Topup, 2G, 4G, Local"));
        map.put("41", new PackDetailsVariables("41", "28 days", "", "All SMS: 450 SMS", "SMS"));
        map.put("43", new PackDetailsVariables("43", "28 days", "", "Unlimited Dialer Tone", "Other"));
        map.put("45", new PackDetailsVariables("45", "84 days", "", "2G/4G Data: 1 GB", "2G, 4G"));
        map.put("53", new PackDetailsVariables("53", "1 day", "", "2G/4G Data: 3 GB", "2G, 4G"));
        map.put("59", new PackDetailsVariables("59", "7 days", "", "2G/4G Data: 500 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 700 SMS", "2G, 4G, Local"));
        map.put("63", new PackDetailsVariables("63", "28 days", "", "All SMS (100 sms/day): 2800 SMS", "SMS"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0", "Topup, 2G, 4G, Topup"));
        map.put("92", new PackDetailsVariables("92", "7 days", "", "2G/4G Data: 6 GB", "2G, 4G"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Full Talktime", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0", "Topup, 2G, 4G, Local"));
        map.put("98", new PackDetailsVariables("98", "28 days", "", "2G/4G Data: 3 GB", "2G, 4G"));
        map.put("99", new PackDetailsVariables("99", "12 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1200 SMS; Not for Commercial Activity", "Local, SMS, STD"));
        map.put("109", new PackDetailsVariables("109", "14 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1400 SMS; Not for Commercial Activity", "Local, STD, SMS"));
        map.put("119", new PackDetailsVariables("119", "15 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1500 SMS", "Local, STD, SMS"));
        map.put("129", new PackDetailsVariables("129", "16 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1600 SMS; Not for Commercial Activity", "Local, STD, SMS"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Full Talktime", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0", "Topup, 2G, 4G"));
        map.put("149", new PackDetailsVariables("149", "21 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS; Not for Commercial Activity", "Local, SMS, STD"));
        map.put("159", new PackDetailsVariables("159", "21 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS", "STD, SMS, Local"));
        map.put("175", new PackDetailsVariables("175", "25 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2500 SMS; Not for Commercial Activity", "Local, STD, SMS"));
        map.put("179", new PackDetailsVariables("179", "21 days", "", "2G/4G Data: 1 GB; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS", "2G, 4G, Local"));
        map.put("199", new PackDetailsVariables("199", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS", "Local, 2G, 4G"));
        map.put("227", new PackDetailsVariables("227", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Unlimited Dialer Tone; Missed Call Alert", "2G, 4G, Local, Other"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Full Talktime", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0", "Topup, 2G, 4G, Local"));
        map.put("345", new PackDetailsVariables("349", "28 days", "", "2G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS", "2G, 4G, Local"));
        map.put("398", new PackDetailsVariables("398", "70 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 7000 SMS", "Local, 2G, 4G"));
        map.put("449", new PackDetailsVariables("449", "82 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8200 SMS", "2G, 4G, Local"));
        map.put("509", new PackDetailsVariables("509", "90 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS", "Local, 2G, 4G"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Talktime", "", "Topup"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addVodafonePacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("5", new PackDetailsVariables("9", "1 hour", "", "2G Data: Unlimited, Valid for 1 hour; SuperHour : Truly Unlimited Data for 1 hour, anytime !", "2G"));
        map.put("9", new PackDetailsVariables("9", "1 day", "", "2G Data: 100 MB; Local & STD Calls: Unlimited; All SMS: 100 SMS", "Local, 2G"));
        map.put("10", new PackDetailsVariables("10", "Lifetime", "7.47 Talktime", "", "Topup"));
        map.put("16", new PackDetailsVariables("16", "1 day", "", "2G/3G/4G Data: 1 GB", "3G, 4G"));
        map.put("18", new PackDetailsVariables("18", "1 hour", "", "3G Data: Unlimited, Valid for 1 hour; SuperHour : Truly Unlimited Data for 1 hour, anytime !", "3G"));
        map.put("19", new PackDetailsVariables("19", "2 days", "", "2G Data: 150 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 200 SMS", "Local, 2G"));
        map.put("27", new PackDetailsVariables("27", "28 days", "", "Local SMS: 2100 SMS (Daily first SMS @ 1.0/sms); 75 SMS/day", "SMS"));
        map.put("33", new PackDetailsVariables("33", "28 days", "", "2G/3G/4G Data: 500 MB", "3G, 4G"));
        map.put("35", new PackDetailsVariables("35", "28 days", "26 Talktime", "2G/3G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0; Applicable recharge for plan voucher 24", "Local, 4G, 3G, Topup"));
        map.put("38", new PackDetailsVariables("38", "28 days", "", "Local SMS (75 sms/day): 2100 SMS; National SMS (25 sms/day): 700 SMS; All SMS: Daily first SMS @ 1.0/sms", "SMS"));
        map.put("46", new PackDetailsVariables("46", "28 days", "", "3G/4G Data: 3 GB", "3G, 4G"));
        map.put("48", new PackDetailsVariables("48", "28 days", "", "Local SMS (75 sms/day): 2100 SMS; National SMS (25 sms/day): 700 SMS", "SMS"));
        map.put("49", new PackDetailsVariables("49", "28 days", "", "2G/3G/4G Data: 1 GB", "4G, 3G"));
        map.put("61", new PackDetailsVariables("61", "28 days", "", "Tamil Nadu Outgoing call rates applicable across India ; Incoming Free all over India; Applicable on Vodafone network", "Other"));
        map.put("65", new PackDetailsVariables("65", "28 days", "55 Talktime", "2G/3G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0; Applicable recharge for plan voucher 24", "Local, 3G, 4G, Topup"));
        map.put("79", new PackDetailsVariables("79", "7 days", "", "2G Data: 500 MB; Local & STD Calls: Unlimited", "2G, Local"));
        map.put("93", new PackDetailsVariables("93", "7 days", "", "3G/4G Data: 6 GB", "3G, 4G"));
        map.put("95", new PackDetailsVariables("95", "28 days", "95 Full Talktime", "2G/3G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0; Applicable recharge for plan voucher 24", "Local, Topup, 3G, 4G"));
        map.put("98", new PackDetailsVariables("98", "28 days", "", "2G/3G/4G Data: 3 GB; 2GB for 4G Handsets", "3G, 4G"));
        map.put("99", new PackDetailsVariables("99", "12 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS @ Rs.0.25/sms", "Local, STD, SMS"));
        map.put("119", new PackDetailsVariables("119", "15 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS @ Rs.0.25/sms", "SMS, STD, Local"));
        map.put("145", new PackDetailsVariables("145", "42 days", "145 Full Talktime", "2G/3G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0; Applicable recharge for plan voucher 24", "Topup, Local, 3G, 4G"));
        map.put("149", new PackDetailsVariables("149", "18 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1800 SMS", "Local, STD, SMS"));
        map.put("159", new PackDetailsVariables("159", "18 days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1800 SMS", "SMS, STD, Local"));
        map.put("199", new PackDetailsVariables("199", "28 days", "", "3G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Vodafone Play App", "4G, 3G"));
        map.put("209", new PackDetailsVariables("209", "28 days", "", "3G/4G Data: 1.5 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Vodafone Play App", "3G, 4G"));
        map.put("245", new PackDetailsVariables("245", "84 days", "245 Full Talktime", "2G/3G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0; Applicable recharge for plan voucher 24", "Local, 3G, 4G, Topup"));
        map.put("255", new PackDetailsVariables("255", "28 days", "", "3G/4G Data: 2 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Vodafone Play App", "3G, Local, 4G"));
        map.put("349", new PackDetailsVariables("349", "28 days", "", "3G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Vodafone Play App", "Local, 3G, 4G"));
        map.put("399", new PackDetailsVariables("399", "70 days", "", "3G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 7000 SMS; Not for Commercial Activity; Vodafone Play App", "4G, 3G, Local"));
        map.put("458", new PackDetailsVariables("458", "84 days", "", "3G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8400 SMS; Vodafone Play App; Not for Commercial Activity", "Local, 3G, 4G"));
        map.put("479", new PackDetailsVariables("479", "84 days", "", "3G/4G Data: 1.5 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8400 SMS; Not for Commercial Activity; Vodafone Play App", "3G, 4G, Local"));
        map.put("509", new PackDetailsVariables("509", "90 days", "", "3G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS; Vodafone Play App; Not for Commercial Activity", "Local, 3G, 4G"));
        map.put("511", new PackDetailsVariables("511", "84 days", "", "3G/4G Data: 2 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8400 SMS; Not for Commercial Activity; Vodafone Play App", "4G, Local, 3G"));
        map.put("529", new PackDetailsVariables("529", "90 days", "", "3G/4G Data: 1.5 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS; Not for Commercial Activity; Vodafone Play App", "3G, 4G, Local"));
        map.put("569", new PackDetailsVariables("569", "84 days", "", "3G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8400 SMS; Not for Commercial Activity; Vodafone Play App", "Local, 3G, 4G"));
        map.put("995", new PackDetailsVariables("995", "1 year", "", "2G/3G/4G Data: 10 GB", "3G, 4G"));
        map.put("1000", new PackDetailsVariables("1000", "Lifetime", "1000 Full Talktime", "", "Topup"));
        map.put("5000", new PackDetailsVariables("5000", "Lifetime", "5000 Full Talktime", "", "Topup"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }*/
}
