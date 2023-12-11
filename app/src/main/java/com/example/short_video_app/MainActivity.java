package com.example.short_video_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.short_video_app.Adapter.VideoAdapter;
import com.example.short_video_app.Animation.ClickedItemAnimator;
import com.example.short_video_app.Model.Video_Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Video_Data> dataList;
    private VideoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.videoRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        // Using PagerSnapHelper for one-item-at-a-time scrolling
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        ClickedItemAnimator clickedItemAnimator = new ClickedItemAnimator();
        recyclerView.setItemAnimator(clickedItemAnimator);


        dataList = new ArrayList<>();

        Video_Data data = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1");
        Video_Data data1 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        Video_Data data2 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1");
        Video_Data data3 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1");
        Video_Data data4 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1");

        dataList.add(data);
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);

        adapter = new VideoAdapter(dataList);
        recyclerView.setAdapter(adapter);

    }
}