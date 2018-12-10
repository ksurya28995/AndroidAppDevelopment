package com.example.ray.ifduplicate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ray.ifduplicate.Adapter.RecyclerViewAdapter_WithTalktime;
import com.example.ray.ifduplicate.Adapter.RecyclerViewAdapter_WithoutTalktime;
import com.example.ray.ifduplicate.Database.DatabaseMethods;
import com.example.ray.ifduplicate.Database.PackDetailsVariables;

import java.util.ArrayList;
import java.util.List;

public class SearchResultFragment extends Fragment {

    public static RecyclerViewAdapter_WithoutTalktime recyclerSearchResultAdapter = new RecyclerViewAdapter_WithoutTalktime(null);
    private List<PackDetailsVariables> tabDataArray = new ArrayList<>();
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public SearchResultFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        recyclerView = view.findViewById(R.id.recyclerSearchResultContainer);
        layoutManager = new LinearLayoutManager(view.getContext());

        Bundle bundle = getArguments();
        String searchText = bundle.getString("searchText");
        tabDataArray = null;
        tabDataArray = DatabaseMethods.loadSearchResultData(searchText);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        recyclerSearchResultAdapter = new RecyclerViewAdapter_WithoutTalktime(tabDataArray);
        recyclerView.setAdapter(null);
        recyclerView.setAdapter(recyclerSearchResultAdapter);
        return view;
    }

}
