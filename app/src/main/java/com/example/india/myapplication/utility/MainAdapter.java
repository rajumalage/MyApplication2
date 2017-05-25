package com.example.india.myapplication.utility;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.ListView;

import com.example.india.myapplication.ListAdapter;
import com.example.india.myapplication.R;

import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;

import java.io.IOException;

import java.io.InputStream;

import java.util.ArrayList;



public class MainAdapter extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.json_activity);

        JSONArray jsonArray=getJSonData("jsondata.json");

        ArrayList<JSONObject> listItems=getArrayListFromJSONArray(jsonArray);

        ListView listV=(ListView)findViewById(R.id.listv);

        ListAdapter adapter=new ListAdapter(this,R.layout.jsonlistview,R.id.txtid,listItems);

        listV.setAdapter(adapter);

    }

    private JSONArray getJSonData(String fileName){

        JSONArray jsonArray=null;

        try {

            InputStream is = getResources().getAssets().open(fileName);

            int size = is.available();

            byte[] data = new byte[size];

            is.read(data);

            is.close();

            String json = new String(data, "UTF-8");

            jsonArray=new JSONArray(json);

        }catch (IOException e){

            e.printStackTrace();

        }catch (JSONException je){

            je.printStackTrace();

        }

        return jsonArray;

    }

    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){

        ArrayList<JSONObject> aList=new ArrayList<JSONObject>();

        try {

            if (jsonArray != null) {

                for (int i = 0; i < jsonArray.length(); i++) {

                    aList.add(jsonArray.getJSONObject(i));

                }

            }

        }catch (JSONException je){je.printStackTrace();}

        return  aList;

    }

}