package com.example.ray.ifduplicate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class SearchFunctionality extends AppCompatActivity implements View.OnClickListener {

    private EditText searchText;
    private ImageButton backbtn, searchContentIcon;
    private TextView searchTitle;
    private FragmentManager fragmentManager;
    private String oldSearchKey = null;
    private Map<String, String> fragmentTags = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_functionality);
        backbtn = findViewById(R.id.searchBackBtn);
        searchTitle = findViewById(R.id.searchTitle);
        searchText = findViewById(R.id.searchText);
        searchContentIcon = findViewById(R.id.searchContentIcon);
        fragmentManager = getSupportFragmentManager();

        String searchTitleVal = HomeActivity.preferenceConfig.getCurrentNetwork().replaceAll("/", "");
        searchTitleVal = "Search " + searchTitleVal + ", TN";
        searchTitle.setText(searchTitleVal);
        searchContentIcon.setOnClickListener(this);
        backbtn.setOnClickListener(this);

    }

    public void displaySearchResults() {
        String searchTextValue = searchText.getText().toString();
        Log.d("Search Text", "text: " + searchTextValue);
        Fragment fragment = getFragment(searchTextValue);
        if (findViewById(R.id.SearchResultsFragmentContainer) != null) {
            if (oldSearchKey == null) {
                fragmentManager.beginTransaction().add(R.id.SearchResultsFragmentContainer, fragment, "SearchResults").commit();
            } else {
                SearchResultFragment.recyclerSearchResultAdapter.notifyDataSetChanged();
                fragmentManager.beginTransaction().replace(R.id.SearchResultsFragmentContainer, fragment, "SearchResults").commit();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.searchBackBtn:
                finish();
                break;
            case R.id.searchContentIcon:
                displaySearchResults();
                break;

        }
    }

    public Fragment getFragment(String searchTextValue) {
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString("searchText", searchTextValue);
        oldSearchKey = searchTextValue;
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }

}
