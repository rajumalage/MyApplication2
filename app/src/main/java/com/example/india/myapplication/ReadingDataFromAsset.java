package com.example.india.myapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.india.myapplication.Category;
import com.example.india.myapplication.JsonParsingHelper;
import com.example.india.myapplication.Utils;

public class ReadingDataFromAsset extends Activity {

    TextView mCategory, mEmptyTextView;
    ProgressBar mProgressBar;

    ListView list;

    String friendsJSON;

    ArrayList<Category> arraylist;
    JsonParsingHelper parser = new JsonParsingHelper();

    public void onBackPressed() {
        finish();
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar

        setContentView(R.layout.activity_friends_list);

        list = (ListView) findViewById(android.R.id.list);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mEmptyTextView = (TextView) findViewById(R.id.empty);

        mEmptyTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);

        friendsJSON = Utils.jsonToStringFromAssetFolder("Friends.json",
                getApplicationContext());

        new getList().execute();

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(),
                        "selected " + arraylist.get(arg2).getName(), Toast.LENGTH_LONG)
                        .show();
            }

        });

        list.setVerticalScrollBarEnabled(false);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setCacheColorHint(getResources().getColor(
                R.color.Cyan));

        list.setVerticalScrollBarEnabled(false);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setCacheColorHint(getResources().getColor(
                R.color.Orange));
    }

    class getList extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        protected Void doInBackground(Void... unused) {

            try {
                arraylist = parser.getCities(friendsJSON);
            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
        }

        protected void onPostExecute(Void unused) {

            if (arraylist != null && arraylist.size() - 1 != 0) {
                list.setAdapter(new MyAdapter());
            } else {
                mEmptyTextView.setVisibility(View.VISIBLE);
                mEmptyTextView.setText("No data found..!!");
            }
            mProgressBar.setVisibility(View.GONE);
        }
    }

    public class MyAdapter extends BaseAdapter {

        public int getCount() {
            // TODO Auto-generated method stub
            return arraylist.size() - 1;
        }

        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        public View getView(final int position, View v1, ViewGroup arg2) {
            // TODO Auto-generated method stub
            View v = null;

            LayoutInflater l = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = l.inflate(R.layout.adapter_content, null);

            // list-optimisation
            View rowview = v;
            if (rowview == null) {
                LayoutInflater linf = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowview = linf.inflate(R.layout.adapter_content, null);
            }

            mCategory = (TextView) v.findViewById(R.id.category);
           // mCategory = (TextView) v.findViewById(R.id.category1);
            //mCategory = (TextView) v.findViewById(R.id.category2);

            //mCategory.setText(arraylist.get(position).getId());
            mCategory.setText(arraylist.get(position).getName());
            //mCategory.setText(arraylist.get(position).getSalary());

            return v;

        }
    }
}
