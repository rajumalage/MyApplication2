package com.example.india.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import static android.R.id.toggle;

/**
 * Created by india on 3/3/2017.
 */

public class colormain extends FragmentActivity {
    private LinearLayout backgroundEl;
    private Button toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorpop);

    }
    public void setcolor(View view){
        colorchoice my_color=new colorchoice();
        my_color.show(getSupportFragmentManager(),"my_dilog");

    }



}
