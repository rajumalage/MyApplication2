package com.example.india.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Context_Menu extends AppCompatActivity {
    int position;
    private static int ACTION_SENDTO = 1;
    ListView listView;
    String[] list = new String[]{"Ankit",
            "Suman",
            "Akash",
            "Saurabh",
            "Mohan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_activity);
        listView = (ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Option");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Message");
        menu.add(0, v.getId(), 0, "Mail");
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {


        int itemPosition = position;
        // ListView Clicked item value
        String itemValue = (String) listView.getItemAtPosition(position);

        Toast.makeText(getApplicationContext(),
                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                .show();


        if (item.getTitle() == "Call" && position==0) {
            Intent emerintent = new Intent(Intent.ACTION_DIAL);
            emerintent.setData(Uri.parse("tel:123"));
            startActivity(emerintent);
            Toast.makeText(getApplicationContext(), "Call:Selected", Toast.LENGTH_LONG).show();
        }
        if (item.getTitle() == "Call" && position==1) {

            Intent emerintent = new Intent(Intent.ACTION_DIAL);
            emerintent.setData(Uri.parse("tel:124"));
            startActivity(emerintent);
            Toast.makeText(getApplicationContext(), "Call:Selected", Toast.LENGTH_LONG).show();
        }

        if (position == 2 && item.getTitle() == "Call") {

            Intent emerintent = new Intent(Intent.ACTION_DIAL);
            emerintent.setData(Uri.parse("tel:125"));
            startActivity(emerintent);
            Toast.makeText(getApplicationContext(), "Call:Selected", Toast.LENGTH_LONG).show();
        }

        if (position == 3 && item.getTitle() == "Call") {

            Intent emerintent = new Intent(Intent.ACTION_DIAL);
            emerintent.setData(Uri.parse("tel:126"));
            startActivity(emerintent);
            Toast.makeText(getApplicationContext(), "Call:Selected", Toast.LENGTH_LONG).show();
        }

        if (position == 4 && item.getTitle() == "Call") {

            Intent emerintent = new Intent(Intent.ACTION_DIAL);
            emerintent.setData(Uri.parse("tel:127"));
            startActivity(emerintent);
            Toast.makeText(getApplicationContext(), "Call:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Message" && position == 0) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setData(Uri.parse("tel:123"));
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivityForResult(sendIntent, ACTION_SENDTO);

            Toast.makeText(getApplicationContext(), "Message:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Message" && position == 1) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setData(Uri.parse("tel:124"));
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivityForResult(sendIntent, ACTION_SENDTO);

            Toast.makeText(getApplicationContext(), "Message:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Message" && position == 2) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setData(Uri.parse("tel:125"));
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivityForResult(sendIntent, ACTION_SENDTO);

            Toast.makeText(getApplicationContext(), "Message:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Message" && position == 3) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setData(Uri.parse("tel:126"));
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivityForResult(sendIntent, ACTION_SENDTO);

            Toast.makeText(getApplicationContext(), "Message:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Message" && position == 4) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setData(Uri.parse("tel:127"));
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivityForResult(sendIntent, ACTION_SENDTO);

            Toast.makeText(getApplicationContext(), "Message:Selected", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Mail") {
            Toast.makeText(getApplicationContext(), "Mail:Selected", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}
