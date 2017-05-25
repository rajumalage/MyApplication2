package com.example.india.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by india on 3/14/2017.
 */

public class pdfReader extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfreader_activity);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button button = (Button) findViewById( R.id.mybutt );

        String pdf = "http://www.pc-hardware.hu/PDF/konfig.pdf";
        String doc="<iframe src='http://docs.google.com/gview?embedded=true&url=http://www.pc-hardware.hu/PDF/konfig.pdf' width='100%' height='100%' style='border: none;'></iframe>";
        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
       // webView.getSettings().setPluginsEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.loadData( doc , "text/html", "UTF-8");
        webView.loadUrl(doc);
        webView.loadUrl(pdf);
    }
    }

