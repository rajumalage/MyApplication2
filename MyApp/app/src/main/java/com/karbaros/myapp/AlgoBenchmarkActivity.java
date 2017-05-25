package com.karbaros.myapp;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.karbaros.myapp.utility.ArrayOperation;
import com.karbaros.myapp.utility.SortingAlgoritham;

public class AlgoBenchmarkActivity extends AppCompatActivity {
    private static final String TAG = AlgoBenchmarkActivity.class.getSimpleName();
    private int[] array;
    double startTime = 0;
    double endTime = 0;
    double toalTime = 0;
    private EditText arrayLength;
    private RadioGroup rdgComplexity;
    TextView tvBubbleSortTime;
    TextView tvSelectionSortTime;
    TextView tvQuickSortTime;
    TextView tvInsertionSortTime;
    SortingAlgoritham sortingAlgoritham = new SortingAlgoritham();

    public void resetAll(View view) {
        arrayLength.setText("");
        tvInsertionSortTime.setText(null);
        tvSelectionSortTime.setText(null);
        tvBubbleSortTime.setText(null);
        tvQuickSortTime.setText(null);
    }


    public void doBenchMark(View view) {
        switch (view.getId()) {

            case R.id.btnBubbleSort :
                int[] arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.bubbleSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvBubbleSortTime.setText("" + toalTime);
                break;
            case R.id.btnSelectionSort :
                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.selectionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvSelectionSortTime.setText("" + toalTime);
                break;
            case R.id.btnQuickSort :
                 arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                sortingAlgoritham.quickSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvQuickSortTime.setText("" + toalTime);
                break;
            case R.id.btnInsertionSort :
                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.insertionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvInsertionSortTime.setText("" + toalTime);
                break;
            case R.id.btnBenchmarkAll :
                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.bubbleSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvBubbleSortTime.setText("" + toalTime);

                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.selectionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvSelectionSortTime.setText("" + toalTime);

                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                sortingAlgoritham.quickSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvQuickSortTime.setText("" + toalTime);

                arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.insertionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvInsertionSortTime.setText("" + toalTime);
                break;

        }
    }

    public void generatArray(View view) {
    // code for disable key board
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    // end....
        int arraySize = 0;
        try {
            arraySize = Integer.parseInt(arrayLength.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(), "!oops  Fill array length", Toast.LENGTH_LONG).show();
            return;
        }

        switch (rdgComplexity.getCheckedRadioButtonId()) {
            case R.id.rbBestCase:
                array = ArrayOperation.generateSortedArray(arraySize);
                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Best case", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbAvarageCase:
                array = ArrayOperation.generateRandomArray(arraySize);
                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Avarage case", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbWorstCase:
                array = ArrayOperation.generateSortedArrayDesc(arraySize);

                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Worst case", Toast.LENGTH_SHORT).show();

                break;
        }
        arrayLength.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_benchmark);
        arrayLength = (EditText) findViewById(R.id.etArrayLength);
        rdgComplexity = (RadioGroup) findViewById(R.id.rdgComplexity);
        tvBubbleSortTime = (TextView) findViewById(R.id.tvBubbleSortTime);
        tvSelectionSortTime = (TextView) findViewById(R.id.tvSelectionSortTime);
        tvQuickSortTime = (TextView) findViewById(R.id.tvQuickSortTime);
        tvInsertionSortTime = (TextView) findViewById(R.id.tvInsertionSortTime);

    }
}
