package com.example.ray.ifduplicate.Database.initializeDB;

import android.content.Context;

import com.example.ray.ifduplicate.SharedPreferenceConfig;
import com.google.firebase.database.DatabaseReference;

public class DatabaseInitialization {

    private DatabaseReference dbReference;
    private SharedPreferenceConfig preferenceConfig;

    public DatabaseInitialization(Context context) {
        preferenceConfig = new SharedPreferenceConfig(context);
    }
/*

    public void addTabContentsData() {
        addIdeaTopupPacksContents();
        addIdea2gPacksContents();
        addIdea4gPacksContents();
        addIdeaLocalPacksContents();
        addIdeaStdPacksContents();
        addIdeaSmsPacksContents();
        addOtherPacksContents();
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
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/2G");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("9", new PackDetailsVariables("9", "1 day", "", "2G/4G Data: 100 MB; Local, STD & Roaming Calls: Unlimited; All SMS: 100 SMS"));
        map.put("16", new PackDetailsVariables("16", "1 day", "", "2G/4G Data: 1 GB"));
        map.put("19", new PackDetailsVariables("19", "2 days", "", "2G/4G Data: 150 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 200 SMS"));
        map.put("28", new PackDetailsVariables("28", "28 days", "", "2G/4G Data: 500 MB"));
        map.put("35", new PackDetailsVariables("35", "28 days", "", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("45", new PackDetailsVariables("45", "84 days", "", "2G/4G Data: 1 GB"));
        map.put("53", new PackDetailsVariables("53", "1 day", "", "2G/4G Data: 3 GB"));
        map.put("59", new PackDetailsVariables("59", "7 days", "", "2G/4G Data: 500 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 700 SMS"));
        map.put("65", new PackDetailsVariables("65", "28 days", "", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("92", new PackDetailsVariables("92", "7 days", "", "2G/4G Data: 6 GB"));
        map.put("95", new PackDetailsVariables("95", "28 days", "", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("98", new PackDetailsVariables("98", "28 days", "", "2G/4G Data: 3 GB"));
        map.put("145", new PackDetailsVariables("145", "42 days", "", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("179", new PackDetailsVariables("179", "21 days", "", "2G/4G Data: 1 GB; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("199", new PackDetailsVariables("199", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("227", new PackDetailsVariables("227", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Unlimited Dialer Tone; Missed Call Alert"));
        map.put("245", new PackDetailsVariables("245", "84 days", "", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("345", new PackDetailsVariables("349", "28 days", "", "2G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("398", new PackDetailsVariables("398", "70 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 7000 SMS"));
        map.put("449", new PackDetailsVariables("449", "82 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8200 SMS"));
        map.put("509", new PackDetailsVariables("509", "90 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdea4gPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/4G");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("9", new PackDetailsVariables("9", "1 day", "", "2G/4G Data: 100 MB; Local, STD & Roaming Calls: Unlimited; All SMS: 100 SMS"));
        map.put("16", new PackDetailsVariables("16", "1 day", "", "2G/4G Data: 1 GB"));
        map.put("19", new PackDetailsVariables("19", "2 days", "", "2G/4G Data: 150 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 200 SMS"));
        map.put("28", new PackDetailsVariables("28", "28 days", "", "2G/4G Data: 500 MB"));
        map.put("35", new PackDetailsVariables("35", "28 days", "", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("45", new PackDetailsVariables("45", "84 days", "", "2G/4G Data: 1 GB"));
        map.put("53", new PackDetailsVariables("53", "1 day", "", "2G/4G Data: 3 GB"));
        map.put("59", new PackDetailsVariables("59", "7 days", "", "2G/4G Data: 500 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 700 SMS"));
        map.put("65", new PackDetailsVariables("65", "28 days", "", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("92", new PackDetailsVariables("92", "7 days", "", "2G/4G Data: 6 GB"));
        map.put("95", new PackDetailsVariables("95", "28 days", "", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("98", new PackDetailsVariables("98", "28 days", "", "2G/4G Data: 3 GB"));
        map.put("145", new PackDetailsVariables("145", "42 days", "", "2G/4G Data: 1 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.145.0"));
        map.put("179", new PackDetailsVariables("179", "21 days", "", "2G/4G Data: 1 GB; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("199", new PackDetailsVariables("199", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("227", new PackDetailsVariables("227", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Unlimited Dialer Tone; Missed Call Alert"));
        map.put("245", new PackDetailsVariables("245", "84 days", "", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("345", new PackDetailsVariables("349", "28 days", "", "2G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("398", new PackDetailsVariables("398", "70 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 7000 SMS"));
        map.put("449", new PackDetailsVariables("449", "82 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8200 SMS"));
        map.put("509", new PackDetailsVariables("509", "90 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaLocalPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/Local");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("99", new PackDetailsVariables("99", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1200 SMS; Not for Commercial Activity"));
        map.put("109", new PackDetailsVariables("109", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1400 SMS; Not for Commercial Activity"));
        map.put("119", new PackDetailsVariables("119", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1500 SMS"));
        map.put("129", new PackDetailsVariables("129", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1600 SMS; Not for Commercial Activity"));
        map.put("149", new PackDetailsVariables("149", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS; Not for Commercial Activity"));
        map.put("159", new PackDetailsVariables("159", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("175", new PackDetailsVariables("175", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2500 SMS; Not for Commercial Activity"));
        map.put("9", new PackDetailsVariables("9", "1 day", "", "2G/4G Data: 100 MB; Local, STD & Roaming Calls: Unlimited; All SMS: 100 SMS"));
        map.put("19", new PackDetailsVariables("19", "2 days", "", "2G/4G Data: 150 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 200 SMS"));
        map.put("35", new PackDetailsVariables("35", "28 days", "", "2G/4G Data: 100 MB; Local & STD Calls @ 0.025/sec; Talktime: Rs.26.0"));
        map.put("59", new PackDetailsVariables("59", "7 days", "", "2G/4G Data: 500 MB; Local, STD & Roaming Calls: Unlimited; All SMS (100 SMS/day): 700 SMS"));
        map.put("65", new PackDetailsVariables("65", "28 days", "", "2G/4G Data: 200 MB; Local & STD Calls @ 0.6/min; Talktime: Rs.55.0"));
        map.put("95", new PackDetailsVariables("95", "28 days", "", "2G/4G Data: 500 MB; Local & STD Calls @ 0.3/min; Talktime: Rs.95.0"));
        map.put("179", new PackDetailsVariables("179", "21 days", "", "2G/4G Data: 1 GB; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("199", new PackDetailsVariables("199", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("227", new PackDetailsVariables("227", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Unlimited Dialer Tone; Missed Call Alert"));
        map.put("245", new PackDetailsVariables("245", "84 days", "", "2G/4G Data: 2 GB; Local & STD Calls @ 0.3/min; Talktime: Rs.245.0"));
        map.put("345", new PackDetailsVariables("349", "28 days", "", "2G/4G Data: 3 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS"));
        map.put("398", new PackDetailsVariables("398", "70 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 7000 SMS"));
        map.put("449", new PackDetailsVariables("449", "82 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 8200 SMS"));
        map.put("509", new PackDetailsVariables("509", "90 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 9000 SMS"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaStdPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/STD");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("99", new PackDetailsVariables("99", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1200 SMS; Not for Commercial Activity"));
        map.put("109", new PackDetailsVariables("109", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1400 SMS; Not for Commercial Activity"));
        map.put("119", new PackDetailsVariables("119", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1500 SMS"));
        map.put("129", new PackDetailsVariables("129", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1600 SMS; Not for Commercial Activity"));
        map.put("149", new PackDetailsVariables("149", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS; Not for Commercial Activity"));
        map.put("159", new PackDetailsVariables("159", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("175", new PackDetailsVariables("175", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2500 SMS; Not for Commercial Activity"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addIdeaSmsPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/SMS");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("33", new PackDetailsVariables("33", "28 days", "", "All SMS: 350 SMS"));
        map.put("41", new PackDetailsVariables("41", "28 days", "", "All SMS: 450 SMS"));
        map.put("63", new PackDetailsVariables("63", "28 days", "", "All SMS (100 sms/day): 2800 SMS"));
        map.put("99", new PackDetailsVariables("99", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1200 SMS; Not for Commercial Activity"));
        map.put("109", new PackDetailsVariables("109", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1400 SMS; Not for Commercial Activity"));
        map.put("119", new PackDetailsVariables("119", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1500 SMS"));
        map.put("129", new PackDetailsVariables("129", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 1600 SMS; Not for Commercial Activity"));
        map.put("149", new PackDetailsVariables("149", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS; Not for Commercial Activity"));
        map.put("159", new PackDetailsVariables("159", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2100 SMS"));
        map.put("175", new PackDetailsVariables("175", " days", "", "Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2500 SMS; Not for Commercial Activity"));
        DatabaseMethods.addToDatabase(dbReference, map);
    }

    public void addOtherPacksContents() {
        dbReference = FirebaseDatabase.getInstance().getReference(preferenceConfig.getCurrentNetwork() + "/Details/Other");
        Map<String, PackDetailsVariables> map = new HashMap<>();
        map.put("43", new PackDetailsVariables("43", "28 days", "", "Unlimited Dialer Tone"));
        map.put("227", new PackDetailsVariables("227", "28 days", "", "2G/4G Data: 1.4 GB / Day; Local, STD & Roaming Calls: Unlimited; All SMS (100 sms/day): 2800 SMS; Not for Commercial Activity; Unlimited Dialer Tone; Missed Call Alert"));
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
