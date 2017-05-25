package com.example.india.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseJsonAndroidExample extends Activity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonlistview);
        ArrayList<HashMap<String, String>>contactList;

        lv=(ListView) findViewById(R.id.listv);
        contactList = new ArrayList<>();
        loadJSONFromAsset();




/*   String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"SonooJaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"VimalJaiswal\",\"salary\":\"60000\"}] }";

        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
JSONObjectjsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
JSONArrayjsonArray = jsonRootObject.optJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for(inti=0; i<jsonArray.length(); i++){
JSONObjectjsonObject = jsonArray.getJSONObject(i);

int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
output.setText(data);
        } catch (JSONException e) {e.printStackTrace();} */
    }
    public ArrayList<MyLocations>loadJSONFromAsset() {
        ArrayList<MyLocations>locList = new ArrayList<>();
        String json = null;
        try {
            InputStream is = getAssets().open("locations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("locations");

            for (int i = 0; i<m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                MyLocations location = new MyLocations();
                location.setLat((float) jo_inside.getDouble("lat"));
                location.setLng((float) jo_inside.getDouble("lng"));
                location.setKey(jo_inside.getString("key"));
                location.setRadius(jo_inside.getInt("radius"));
                location.setName(jo_inside.getString("name"));
                location.setAudio_file(jo_inside.getString("audio_file"));


//Add your values in your `ArrayList` as below:
                locList.add(location);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return locList;
    }
}
