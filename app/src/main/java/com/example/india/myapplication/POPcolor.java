package com.example.india.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

/**
 * Created by india on 3/3/2017.
 */

public class POPcolor extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorpop);
        /**
         * A Button that acts as the view element for the popup menu.
         */
        final Button btn = (Button) findViewById(R.id.button1);
        final LinearLayout lr = (LinearLayout) findViewById(R.id.l1);
        /**
         * Step 1: Create a new instance of popup menu
         */
        final PopupMenu popupMenu = new PopupMenu(this, btn);
        final PopupMenu popupMenu1 = new PopupMenu(this, lr);
        /**
         * Step 2: Inflate the menu resource. Here the menu resource is
         * defined in the res/menu project folder
         */
        popupMenu.inflate(R.menu.color_menu);
        popupMenu1.inflate(R.menu.color_menu);
        /**
         * Step 3: Call show() method on the popup menu to display the
         * menu when the button is clicked.
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
                popupMenu1.show();
            }
        });
        /**
         *  Handle menu item clicks
         */
        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_red:
                                lr.setBackgroundResource(R.color.LightRed);
                                btn.setBackgroundResource(R.color.DullBlue);
                                break;
                            case R.id.menu_blue:
                                lr.setBackgroundResource(R.color.DullBlue);
                                btn.setBackgroundResource(R.color.LightGreen);
                                break;
                            case R.id.menu_green:
                                lr.setBackgroundResource(R.color.LightGreen);
                                btn.setBackgroundResource(R.color.LightRed);
                                break;
                        }
                        return true;
                    }
                });

    }
}
