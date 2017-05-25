package com.example.india.myapplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class CatList extends Activity {


    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("formules.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonmain_activity);
        ListView categoriesL = (ListView) findViewById(R.id.listFormulas);



    try

    {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray m_jArry = obj.getJSONArray("formules");
        ArrayList<HashMap<String, String>> formList = new ArrayList <HashMap<String, String>>();
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = m_jArry.getJSONObject(i);
           // Log.d("Details-->", jo_inside.getString("formule"));
            String formula_value = jo_inside.getString("formule");
            String url_value = jo_inside.getString("url");

            //Add your values in your `ArrayList` as below:
            m_li = new HashMap <String, String>();
            m_li.put("formule", formula_value);
            m_li.put("url", url_value);

            formList.add(m_li);
            System.out.println(m_li);

        }

    } catch(
    JSONException e)


    {
        e.printStackTrace();
    }

}

}


