package com.example.india.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }
    boolean power=false;
    boolean wifi=false;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(intent.ACTION_POWER_CONNECTED)) {
            power=true;
        } else if(intent.getAction().equals(intent.ACTION_POWER_DISCONNECTED)) {
            power=false;
        }
        ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo != null && activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            wifi=true;

        } else {
            wifi=false;
        }
        if (power && wifi){

            upload(context);
        }
        if (wifi){
            download(context);
        }

    }

    private void download(Context context) {
        Toast.makeText(context, "Downloading..!!", Toast.LENGTH_LONG).show();
    }

    private void upload(Context context) {
        Toast.makeText(context, "Upload..!!", Toast.LENGTH_LONG).show();
    }
}
