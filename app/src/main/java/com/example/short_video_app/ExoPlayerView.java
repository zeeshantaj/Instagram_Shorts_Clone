package com.example.short_video_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class ExoPlayerView extends FrameLayout {

    private SimpleExoPlayer exoPlayer;
    private PlayerView playerView;

    public ExoPlayerView(Context context) {
        super(context);
        init();
    }

    public ExoPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExoPlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.shorts_layout, this, true);
        playerView = findViewById(R.id.player_view);
        exoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        playerView.setPlayer(exoPlayer);
    }

    public void setVideoUrl(String videoUrl) {
        MediaItem mediaItem = MediaItem.fromUri(videoUrl);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }

    public void releasePlayer() {
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }
}