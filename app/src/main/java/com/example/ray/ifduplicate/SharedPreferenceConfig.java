package com.example.ray.ifduplicate;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences preferences;
    private Context context;
    private SharedPreferences.Editor editor;

    public SharedPreferenceConfig(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(context.getResources().getString(R.string.networkPreference), context.MODE_PRIVATE);
    }

    public String getCurrentNetwork() {
        String defaultNetwork = "/Idea/Tamilnadu";
        defaultNetwork = preferences.getString(context.getResources().getString(R.string.currentNetworkPreference), defaultNetwork);
        return defaultNetwork;
    }

    public void setCurrentNetwork(String network) {
        editor = preferences.edit();
        editor.putString(context.getResources().getString(R.string.currentNetworkPreference), network);
        editor.commit();
    }

}
