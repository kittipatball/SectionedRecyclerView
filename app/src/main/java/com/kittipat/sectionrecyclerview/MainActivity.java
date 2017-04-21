package com.kittipat.sectionrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView mRecyclerView;
    private com.kittipat.sectionrecyclerview.SimpleAdapter mFirstHeader;
    private com.kittipat.sectionrecyclerview.SimpleAdapter mSecondHeader;
    private com.kittipat.sectionrecyclerview.SimpleAdapter mThirdHeader;
    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        setAdapter();
    }

    private void setAdapter() {

        sectionAdapter = new SectionedRecyclerViewAdapter();

        ArrayList<String> arrSports = new ArrayList<>();
        arrSports.add("FootBall");
        arrSports.add("Basketball");
        arrSports.add("Tennis");
        arrSports.add("Baseball");
        mFirstHeader = new com.kittipat.sectionrecyclerview.SimpleAdapter
                (arrSports,getResources().getString(R.string.Sports));
        sectionAdapter.addSection(mFirstHeader);

        ArrayList<String> arrCartoons = new ArrayList<>();
        arrCartoons.add("Tower of god");
        arrCartoons.add("Dice");
        arrCartoons.add("Noblesse");
        arrCartoons.add("Minions");
        mSecondHeader = new com.kittipat.sectionrecyclerview.SimpleAdapter
                (arrCartoons,getResources().getString(R.string.Cartoons));
        sectionAdapter.addSection(mSecondHeader);

        ArrayList<String> arrGames = new ArrayList<>();
        arrGames.add("Dota 2");
        arrGames.add("Pokemon GO");
        arrGames.add("Cookie run");
        arrGames.add("Tab on titan");
        mThirdHeader = new com.kittipat.sectionrecyclerview.SimpleAdapter
                (arrGames,getResources().getString(R.string.Games));
        sectionAdapter.addSection(mThirdHeader);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(sectionAdapter);

    }
}
