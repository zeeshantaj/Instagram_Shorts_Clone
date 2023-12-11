package com.example.short_video_app.Model;

public class Video_Data {
    private String profileName,profileImageUrl,comment,caption,videoUrl;

    public Video_Data(String profileName, String profileImageUrl, String comment, String caption, String videoUrl) {
        this.profileName = profileName;
        this.profileImageUrl = profileImageUrl;
        this.comment = comment;
        this.caption = caption;
        this.videoUrl = videoUrl;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
