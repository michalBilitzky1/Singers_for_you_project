package com.example.myapplicationtest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    @SerializedName("items")
    private List<JsonVideo> videos;

    public List<JsonVideo> getVideos() {
        return videos;
    }
}