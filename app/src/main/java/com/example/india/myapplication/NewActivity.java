package com.example.india.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by india on 2/18/2017.
 */

public class NewActivity extends AppCompatActivity {
    public void doSomething(View view){
        TextView textView = (TextView) findViewById(R.id.tvResult);
        textView.setText("This is Android Program");
        textView.setTextColor(Color.MAGENTA);
        textView.setTextSize(50.5F);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivty_layout);

    }
}
