package com.example.myapplicationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YouTubeActivity  extends YouTubeBaseActivity   {
    private static final String TAG = "TAG";
    private ThumbnailVideoAdapter thumbnailVideoAdapter;
    private List<JsonVideo> videos;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.you_tube);
      //  youTubePlayerView=findViewById(R.id.youTubePlayer);
      //  button=findViewById(R.id.playYouTube);
       // onInitializedListener=new YouTubePlayer.OnInitializedListener() {
        recyclerView = findViewById(R.id.recycler);
        videos = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        thumbnailVideoAdapter = new ThumbnailVideoAdapter(YouTubeActivity.this);
        recyclerView.setAdapter(thumbnailVideoAdapter);
        loadVideo();


    }

    private void loadVideo() {
        App.getVideoSearchApi().callback(SulationSinger.artists.get(1)).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d(TAG, "onResponse: ");
                videos = response.body().getVideos();
                thumbnailVideoAdapter.setVideos(videos);

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d(TAG, "onFailure:");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


}