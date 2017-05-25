package com.example.india.myapplication;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
public class ListViewAndroidExample extends Activity {
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list_item_1);
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW",
                "MAGENTA",
                "CYAN"
        };


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        // Assign adapter to ListView
        listView.setAdapter(adapter);
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {


                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
                LinearLayout rl = (LinearLayout) findViewById(R.id.clist);
                if (position == 1)
                    rl.setBackgroundColor(Color.RED);
                if (position == 2)
                    rl.setBackgroundColor(Color.BLUE);
                if (position == 3)
                    rl.setBackgroundColor(Color.GREEN);
                if (position == 4)
                    rl.setBackgroundColor(Color.YELLOW);
                if (position == 5)
                    rl.setBackgroundColor(Color.MAGENTA);
                if (position == 6)
                    rl.setBackgroundColor(Color.CYAN);
            }
        });
    }
}
