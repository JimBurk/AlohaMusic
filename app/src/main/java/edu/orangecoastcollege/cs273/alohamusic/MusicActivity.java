package edu.orangecoastcollege.cs273.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {
    // References to UI components
    Button ukuleleButton;
    Button ipuButton;
    Button hulaButton;

    VideoView hulaVideoView;

    MediaPlayer ukuleleMediaPlayer;
    MediaPlayer ipuMediaPlayer;

    /***
     * This is the enry point for the Aloha Music application. There are three choices, play a ukulele
     * song, play an ipu song and show a hula video.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // Associate the components
        ukuleleButton = (Button) findViewById(R.id.ukeleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaView);

        // Associate the Media players
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        // Associate the Video View
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.hula;
        hulaVideoView.setVideoURI(Uri.parse((uri)));

        // Create a Media Controller for the video view
        hulaVideoView.setMediaController(new MediaController(this));
    }

    // method will handle all three button clicks
    // use the button id to see which was clicked
    public void playMedia(View v) {
        // Make a decision based on the id of the view
        switch (v.getId()) {
            case R.id.ukeleleButton:
                // if playing pause, else play
                if (ukuleleMediaPlayer.isPlaying()) {
                    ukuleleMediaPlayer.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                } else {
                    ukuleleMediaPlayer.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.ipuButton:
                // if playing pause, else play
                if (ipuMediaPlayer.isPlaying()) {
                    ipuMediaPlayer.pause();
                    ipuButton.setText(R.string.ukulele_button_play_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                } else {
                    ipuMediaPlayer.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                // if playing pause, else play
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                } else {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    protected void onStop () {
        super.onStop();
        ukuleleMediaPlayer.release();
        ipuMediaPlayer.release();
    }
}
