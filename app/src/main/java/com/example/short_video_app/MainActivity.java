package com.example.short_video_app;

import androidx.annotation.NonNull;
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
        Video_Data data1 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://video.blender.org/download/videos/ac71efff-5e26-440b-8c38-dd1f5b598e02-720.mp4");

        Video_Data data = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://video.blender.org/download/videos/3d95fb3d-c866-42c8-9db1-fe82f48ccb95-720.mp4");
       Video_Data data2 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://video.blender.org/download/videos/43c66e88-d05b-4aa7-af52-5818bf1198de-720.mp4");
        Video_Data data3 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://video.blender.org/download/videos/5fd10ab3-284c-45c7-891d-6058e436840d-720.mp4");
        Video_Data data4 = new Video_Data("zeeshan taj",
                "fuadhfiuahdifuahdiuf","adfadfuafduishafusd","the quick brown fox jumps over the lazy dog","https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1");

        dataList.add(data);
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);

        adapter = new VideoAdapter(dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                    for (int i = 0; i < adapter.getItemCount(); i++) {
                        if (i < firstVisibleItem || i > lastVisibleItem) {
                            // Pause video playback for items that are not in the visible range
                            VideoAdapter.ViewHolder viewHolder = (VideoAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
                            if (viewHolder != null) {
                                viewHolder.pause();
                            }
                        } else {
                            // Resume video playback for items in the visible range
                            VideoAdapter.ViewHolder viewHolder = (VideoAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
                            if (viewHolder != null) {
                                viewHolder.play();
                            }
                        }
                    }
                }
            }
        });
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    // Get the first and last visible item positions
//                    int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
//                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//
//                    // Pause the players for items that are not in the visible range
//                    for (int i = 0; i < adapter.getItemCount(); i++) {
//                        if (i < firstVisibleItem || i > lastVisibleItem) {
//                            VideoAdapter.ViewHolder viewHolder = (VideoAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//                            if (viewHolder != null) {
//                                viewHolder.pauseVideo();
//                            }
//                        }
//                    }
//                }
//            }
//        });

    }
}