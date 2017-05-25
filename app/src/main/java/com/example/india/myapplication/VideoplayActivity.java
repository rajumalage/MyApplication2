package com.example.india.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class VideoplayActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.activity_videoplay);

        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.MyButton);

        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(VideoplayActivity.this,
                        VideoViewActivity.class);
                startActivity(myIntent);
            }
        });
    }

}