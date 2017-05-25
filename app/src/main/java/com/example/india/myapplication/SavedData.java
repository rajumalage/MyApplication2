package com.example.india.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SavedData extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_data);

        Intent intent=getIntent();
        String val = intent.getStringExtra("val1");
        String val1 = intent.getStringExtra("val2");
        String val2 = intent.getStringExtra("val3");


        TextView t1 = (TextView) findViewById(R.id.textView11);
        TextView t2 = (TextView) findViewById(R.id.textView12);
        TextView t3 = (TextView) findViewById(R.id.textView13);

        t1.setText(val2);
        t2.setText(val);
        t3.setText(val1);
        // String arr[] = {"dfsd","dsfsdf","dfsdf"};
        // ArrayAdapter adapter = new ArrayAdapter<String>(this,
        //       R.layout.activity_saved_data, arr);
        //ListView l = (ListView) findViewById(R.id.listView01);
        //l.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

