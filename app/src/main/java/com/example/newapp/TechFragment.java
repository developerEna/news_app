package com.example.newapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechFragment extends Fragment {
    String apiKey = "abb2572bf1364ed6a66dc4adb83a55c1";
    ArrayList<NewsModel> newsModels;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerView;
    private String category="technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.technologyfragment,null);

        recyclerView=view.findViewById(R.id.recyclerview_technology);
        newsModels = new ArrayList<>();
        adapter = new Adapter(newsModels,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        displayNews();
       return view;
    }
    private void displayNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,apiKey).enqueue(new Callback<MainNewsModel>() {
            @Override
            public void onResponse(Call<MainNewsModel> call, Response<MainNewsModel> response) {
                if(response.isSuccessful()){
                    newsModels.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNewsModel> call, Throwable t) {

            }
        });
    }
}
