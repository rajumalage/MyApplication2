package com.example.india.myapplication;

        import android.app.Activity;
        import android.graphics.Matrix;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.ScaleGestureDetector;
        import android.widget.ImageView;
public class Zooming_Image extends Activity {
    private ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zooming__image);
        imageView = (ImageView)findViewById(R.id.imageView);
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            matrix.setScale(scaleFactor, scaleFactor);
            imageView.setImageMatrix(matrix);
            return true;
        }
    }
}
