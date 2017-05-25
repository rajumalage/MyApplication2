package com.example.india.myapplication;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.File;

import static android.R.attr.data;
import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;

public class Menu_Activity extends AppCompatActivity {
    String img_Decodable_Str;
    private static final int CAMERA_REQUEST = 1888;
    private static int RESULT_LOAD_IMG = 1;
    private static int ACTION_SENDTO = 2;
    private ImageView clr=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final Menu mt=(Menu) findViewById(R.id.menu);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulist);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuactivity, menu);
        setContentView(R.layout.menulist);
    /*    final LinearLayout lr = (LinearLayout) findViewById(R.id.menuactivity);
        final PopupMenu popupMenu1 = new PopupMenu(this, lr);
        popupMenu1.inflate(R.menu.menuactivity);
        lr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu1.show();
            }
        }); */

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miCamera:
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

                break;
            case R.id.miGalary:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
                break;
            case R.id.misms:
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
                startActivityForResult(sendIntent, ACTION_SENDTO);
                break;
            case R.id.miDilar:
                Intent intent = new Intent("android.intent.action.DIAL");
                /** Starting the Dialer activity */
                startActivity(intent);

                break;
            case R.id.miEmergency:
                Intent emerintent = new Intent(Intent.ACTION_DIAL);
                emerintent.setData(Uri.parse("tel:108"));
                startActivity(emerintent);

                break;
            case R.id.miWhats:
                Intent whatIntent = new Intent();
                whatIntent.setPackage("com.whatsapp");
                startActivity(whatIntent);
                break;
            case R.id.miclear:
                clr=(ImageView)findViewById(R.id.image);
                clr.setImageDrawable(null);
                break;
            case R.id.mipdfreader:
                String dir="/Attendancesystem";
                File file = null;
                file = new File(Environment.getExternalStorageDirectory()+dir+ "/somu");
               // File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/");
               // file = new File(Environment.getExternalStorageDirectory()+dir);
                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(file),"application/pdf");
                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                Intent pdfintent = Intent.createChooser(target, "Open File");
                try {
                    startActivity(pdfintent);
                } catch (ActivityNotFoundException e) {
                    // Instruct the user to install a PDF reader here, or something
                }

        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
           if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data)


            {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                img_Decodable_Str = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.image);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(img_Decodable_Str));

            } else {
                Toast.makeText(this, "Hey pick your image first",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went embrassing", Toast.LENGTH_LONG)
                    .show();
        }

    }


}
