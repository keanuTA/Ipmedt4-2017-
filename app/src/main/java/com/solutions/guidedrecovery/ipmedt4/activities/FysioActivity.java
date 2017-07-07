package com.solutions.guidedrecovery.ipmedt4.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.solutions.guidedrecovery.ipmedt4.PlayerConfig;
import com.solutions.guidedrecovery.ipmedt4.R;

public class FysioActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubePlayerView;
    Button button;
    Button back;
    Context context;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    public FysioActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fysio);

        button = (Button) findViewById(R.id.btnYouTube);
        back = (Button) findViewById(R.id.btnBack);
        youtubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlayerView);
        context = this.getBaseContext();
        onInitializedListener = new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("5CLyljiHdD4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                youtubePlayerView.initialize(PlayerConfig.API_KEY, onInitializedListener);
            }
        });


        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TrajectKeuzeActivity.class);
                startActivity(intent);
            }
        });




    }
}
