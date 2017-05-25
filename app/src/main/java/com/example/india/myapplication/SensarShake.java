package com.example.india.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.india.myapplication.R;
import com.example.india.myapplication.utility.MyService;

public class SensarShake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyService.class);
        //Start Service
        startService(intent);
    }

}
