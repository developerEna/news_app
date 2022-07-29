package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem homeItem,sportsItem,scienceItem,techItem,entertainmentItem,healthItem;
    ViewPager viewPager;

    String apiKey = "abb2572bf1364ed6a66dc4adb83a55c1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeItem = findViewById(R.id.home);
        sportsItem = findViewById(R.id.sports);
        scienceItem = findViewById(R.id.science);
        techItem = findViewById(R.id.technology);
        entertainmentItem = findViewById(R.id.entertainment);
        healthItem = findViewById(R.id.health);

        viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.tab);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}