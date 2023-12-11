package com.example.short_video_app.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.short_video_app.Model.Video_Data;
import com.example.short_video_app.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<Video_Data> videoDataList;

    public VideoAdapter(List<Video_Data> videoDataList) {
        this.videoDataList = videoDataList;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shorts_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        Video_Data data = videoDataList.get(position);
        holder.profileName.setText(data.getProfileName());
        holder.caption.setText(data.getCaption());

        Uri uri = Uri.parse(data.getVideoUrl());
        holder.videoView.setVideoURI(uri);
       // holder.mediaController.setAnchorView(holder.videoView);
       // holder.mediaController.setMediaPlayer(holder.videoView);
        //holder.videoView.setMediaController(holder.mediaController);
        holder.videoView.start();



        holder.likeBtn.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // Scale down the clicked item
                    view.setScaleX(0.9f);
                    view.setScaleY(0.9f);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    // Restore the original size when touch is released or canceled
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    break;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return videoDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView profileName,caption,followBtn;
        private Button comment,likeBtn;
        private CircleImageView profileImage1;
        private ImageView profileImage2;
        private boolean isLiked = false;
        private boolean isFollow = false;

        private VideoView videoView;
        private MediaController mediaController;

        //private String videoUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1";
        //private String videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4";
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileName = itemView.findViewById(R.id.profileName);
            caption = itemView.findViewById(R.id.caption);
            profileImage1 = itemView.findViewById(R.id.imageView);
            profileImage2 = itemView.findViewById(R.id.profileImg);
            comment = itemView.findViewById(R.id.comment);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            videoView = itemView.findViewById(R.id.videoView);
            followBtn = itemView.findViewById(R.id.followBtn);
            mediaController = new MediaController(itemView.getContext());


            followBtn.setOnClickListener(v -> {
                isFollow = !isFollow;

                // Change the drawableTop icon based on the like status
                if (isFollow) {
                    // If liked, set red_heart as drawableTop
                    followBtn.setText("Following");

                } else {
                    // If not liked, set heart_thin_icon as drawableTop
                    followBtn.setText("Follow");
                }
            });
            likeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle the like status
                    isLiked = !isLiked;

                    // Change the drawableTop icon based on the like status
                    if (isLiked) {
                        // If liked, set red_heart as drawableTop
                        likeBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.red_heart_icon, 0, 0);
                    } else {
                        // If not liked, set heart_thin_icon as drawableTop
                        likeBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.heart_thin_icon, 0, 0);
                    }
                }
            });

        }
    }
}
