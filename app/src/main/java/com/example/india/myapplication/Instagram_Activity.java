package com.example.india.myapplication;

import java.io.File;
import java.util.Random;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


        public class Instagram_Activity extends Activity {
            ImageView imageView;

            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.instagram_activity);
                imageView= (ImageView)findViewById(R.id.imageView1);

            }


            public void onClick() {



                int[] picture=

                        {
                                R.drawable.details};
                Random r = new Random();
                int n=r.nextInt(7);
                imageView.setImageResource(picture[n]);
            }
        }
