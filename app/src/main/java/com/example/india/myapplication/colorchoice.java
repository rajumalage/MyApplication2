package com.example.india.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by india on 3/2/2017.
 */

public class colorchoice extends DialogFragment {

    final CharSequence[] item={"RED","GREEN","YELLOW","ORANGE"};
    String selection;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Chooce Your Color:").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        selection = (String) item[which];

                        break;
                    case 1:
                        selection = (String) item[which];
                        break;
                    case 2:
                        selection = (String) item[which];
                        break;
                    case 3:
                        selection = (String) item[which];
                        break;
                    default:
                        break;
                }

            }
        }).setPositiveButton("OK",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Your Color:"+selection,Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }


    public void show(FragmentManager supportFragmentManager, String my_dilog) {

    }
}
