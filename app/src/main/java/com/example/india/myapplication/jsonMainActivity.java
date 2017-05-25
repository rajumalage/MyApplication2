package com.example.india.myapplication;




import android.app.Activity;
import android.os.Parcelable;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;


public class jsonMainActivity extends Activity {
    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity_main);
        listView = (ListView) findViewById(R.id.listView);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.stats);
        jsonfile csvFile = new jsonfile(inputStream);
        List<String[]> scoreList = csvFile.read();

        for(String[] scoreData:scoreList ) {
            itemArrayAdapter.add(scoreData);
        }
    }
}