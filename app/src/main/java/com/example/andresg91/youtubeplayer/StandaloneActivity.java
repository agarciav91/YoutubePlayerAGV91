package com.example.andresg91.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by Andres on 3/15/2018.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        final Button mBtnPlayVideo = (Button) findViewById(R.id.btn_playVideo);
        Button mBtnPlaylist = (Button) findViewById(R.id.btn_playlist);


        // Using the Implements in the java class (for multiple buttons)
        mBtnPlayVideo.setOnClickListener(this);
        mBtnPlaylist.setOnClickListener(this);

        /*
        -----------------------------------------------------------------
         Making a general listener without using the implements from the class (for multiple buttons)
        final View.OnClickListener ourListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        };

        mBtnPlayVideo.setOnClickListener(ourListener);
        mBtnPlaylist.setOnClickListener(ourListener);

         ----------------------------------------------------------------
         Creating a single listener for a button (used for single buttons)
        mBtnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_playVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;

            case R.id.btn_playlist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, false);
                break;

            default:
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
