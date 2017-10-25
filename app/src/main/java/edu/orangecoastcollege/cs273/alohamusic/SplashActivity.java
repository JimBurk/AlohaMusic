package edu.orangecoastcollege.cs273.alohamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create a TimerTask to defer loading of MusicActivity by 3 seconds
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Finish the current Splash activity, then launch the MusicActivity
                finish();
                Intent musicIntent = new Intent(SplashActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        };

        // Run the timer task after 3 sec

        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
