package com.example.india.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.india.myapplication.utility.ImageFilter;
import com.example.india.myapplication.utility.ZoomImageFilter;





public class InstaCamZoom extends AppCompatActivity {

    ImageView ivResultImage;
    ImageView ivThumbnailOriginal;
    ImageView ivThumbGrayScale;
    ImageView ivThumbSnowEffect;
    ImageView ivThumbBrightness;
    ImageView ivThumbDark;
    ImageView ivThumbReflection;
    ImageView imageTemp;

    private Uri imageUri;
    private Bitmap bitmap;
    private Bitmap bitmapTemp;
    private static final int CAMERA_REQUEST = 1888;
    private Bitmap bitmapOriginal;
    private Bitmap bitmapGrayScale;
    private Bitmap bitmapSnowEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instacam_activity);
        ivResultImage = (ImageView) findViewById(R.id.ivResultImage);
        ivThumbnailOriginal = (ImageView) findViewById(R.id.ivThumbOriginal);
        ivThumbGrayScale = (ImageView) findViewById(R.id.ivThumbGrayScale);
        ivThumbSnowEffect = (ImageView) findViewById(R.id.ivThumbSnowEffect);
        ivThumbBrightness = (ImageView) findViewById(R.id.ivThumbBrightness);
        ivThumbDark = (ImageView) findViewById(R.id.ivThumbDark);
        ivThumbReflection = (ImageView) findViewById(R.id.ivThumbReflection);

        imageTemp = (ImageView) findViewById(R.id.ivResultImage);


        BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
        bitmapTemp = bitmapDrawableTemp.getBitmap();

        BitmapDrawable abmp = (BitmapDrawable) ivResultImage.getDrawable();
        bitmap = abmp.getBitmap();


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        makeThumbnail(bitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.instagram_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();
        switch (selectedItemId) {
            case R.id.miCamera:
                takePhoto();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void takePhoto() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivResultImage.setImageBitmap(photo);
            imageTemp.setImageBitmap(photo);
            BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
            bitmapTemp = bitmapDrawableTemp.getBitmap();
            makeThumbnail(photo);
        }
    }


    public void makeThumbnail(Bitmap bitmapImage) {
        Bitmap resized = Bitmap.createScaledBitmap(bitmapImage, (int) (bitmapImage.getWidth() * 0.1), (int) (bitmapImage.getHeight() * 0.1), true);


        ivThumbnailOriginal.setImageBitmap(resized);

        ivThumbGrayScale.setImageBitmap(ZoomImageFilter.zoomImageFromThumb(resized));
        /*ivThumbGrayScale.setImageBitmap(ImageFilter.doGreyscale(resized));
        ivThumbSnowEffect.setImageBitmap(ImageFilter.applySnowEffect(resized));
        ivThumbBrightness.setImageBitmap(ImageFilter.doBrightness(resized));
        ivThumbDark.setImageBitmap(ImageFilter.doDark(resized));
        ivThumbReflection.setImageBitmap(ImageFilter.applyReflection(resized)); */

    }


    public void applyFilter(View view) {
        switch (view.getId()) {
            case R.id.ivThumbOriginal:
                Log.i("log", "thumbOriginal");
                ivResultImage.setImageBitmap(bitmapTemp);
                break;
            case R.id.ivThumbGrayScale:
                Log.i("log", "thumbGrayScale");
                ivResultImage.setImageBitmap(ImageFilter.doGreyscale(bitmapTemp));
                break;
            case R.id.ivThumbSnowEffect:
                ivResultImage.setImageBitmap(ImageFilter.applySnowEffect(bitmapTemp));
                break;
            case R.id.ivThumbBrightness:
                ivResultImage.setImageBitmap(ImageFilter.doBrightness(bitmapTemp));
                break;
            case R.id.ivThumbDark:
                ivThumbDark.setImageBitmap(ImageFilter.doDark(bitmapTemp));
                break;
            case R.id.ivThumbReflection:
                ivThumbReflection.setImageBitmap(ImageFilter.applyReflection(bitmapTemp));
                break;
            default:
                break;
        }

    }


}
