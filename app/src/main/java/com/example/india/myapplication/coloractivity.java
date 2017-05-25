package com.example.india.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class coloractivity extends Activity {

    private LinearLayout backgroundEl;
    private Button toggle;

    protected void onCreate(LinearLayout linearLayout) {
        // TODO Auto-generated method stub
        setContentView(R.layout.colorpop);
        this.onCreate(backgroundEl = (LinearLayout) findViewById(R.id.l1));
    }

    protected void onCreate(Button button) {
        // TODO Auto-generated method stub
        setContentView(R.layout.colorpop);
        this.onCreate(toggle = (Button) findViewById(R.id.button1));
        toggle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (toggle.isSelected())
                    backgroundEl.setBackgroundColor(Color.MAGENTA);
                else
                    backgroundEl.setBackgroundColor(Color.WHITE);
            }
        });
    }
}

