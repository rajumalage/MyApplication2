package com.example.india.myapplication;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonParsingHelper {

    private static final String TAG = JsonParsingHelper.class.getSimpleName();

    public static ArrayList<Category> getCities(String countryJson) throws JSONException {
        ArrayList<Category> cities = new ArrayList<Category>();

        JSONArray names = null;

        // getting JSON string from asset
        JSONObject json = new JSONObject(countryJson);

        try {
            // Getting Array of Contacts
            names = json.getJSONArray("list");

            // looping through All Contacts
            for(int i = 0; i < names.length(); i++){
                JSONObject c = names.getJSONObject(i);

                // Storing each json item in variable
                Category cat = new Category();
              //  int id=c.getInt("id");
                String name = c.getString("name");
           //     int salary=c.getInt("salary");

             //   cat.setId(id);
                cat.setName(name);
            //    cat.setSalary(salary);

                cities.add(cat);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
