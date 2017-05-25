package com.example.india.myapplication;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class OnlineAudioPlayActivity extends Activity {

    Button buttonStop,buttonStart ;



    String AudioURL ="http://soundxx.mp3slash.net/indian/aashiqui/6(mp3pk.com).mp3";

    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_audio_play);

        buttonStart = (Button)findViewById(R.id.button1);
        buttonStop = (Button)findViewById(R.id.button2);

        mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                try {

                    mediaplayer.setDataSource(AudioURL);
                    mediaplayer.prepare();


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                mediaplayer.start();
                Toast.makeText(getBaseContext(),"Music Playing",Toast.LENGTH_LONG).show();;

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                mediaplayer.stop();
                Toast.makeText(getBaseContext(),"Stop Playing",Toast.LENGTH_LONG).show();;


            }
        });
    }

}
