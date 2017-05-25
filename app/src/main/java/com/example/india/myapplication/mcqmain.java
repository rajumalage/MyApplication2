package com.example.india.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class mcqmain extends Activity {

    private ListView listView1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcqlist2_activity);

        mcqoption weather_data[] = new mcqoption[]
                {

                        new mcqoption(""),
                        new mcqoption(""),
                        new mcqoption(""),
                        new mcqoption(""),

	                   /* new MatrixOption("Heading1"),
	                    new MatrixOption("Heading2"),
	                    new MatrixOption("Heading3"),
	                    new MatrixOption("Heading4"),
	                    new MatrixOption("Heading5")*/
                };
        mcqRadioGroupAdapter adapter = new mcqRadioGroupAdapter(this,R.layout.mcqlist_activity, weather_data);
        listView1 = (ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
