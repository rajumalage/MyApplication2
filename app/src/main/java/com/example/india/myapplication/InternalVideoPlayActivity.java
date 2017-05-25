package com.example.india.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class InternalVideoPlayActivity extends Activity {
    private MediaController mc;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_video_play);
        VideoView vd = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://"+getPackageName() + "/"+R.raw.video);

        mc = new MediaController(this);
        vd.setMediaController(mc);

        vd.setVideoURI(uri);
        vd.start();
    }

}