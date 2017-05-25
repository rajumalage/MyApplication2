package com.example.india.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class QuizActivityAdjectives extends Activity {

    TextView txt_questionAdjective;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_content);
        // Hangi xml dosyasının dikkate alınacağı belirlendi.

        List<String> questions = new ArrayList();
        // Reading json file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open(
                    "Questions.json")));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        // Try to parse JSON
        try {
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(myjsonstring);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("questions");

            // JSONArray has x JSONObject
            for (int i = 0; i < jsonArray.length(); i++) {

                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                int id = jsonObj.getInt("id");
                String question = jsonObj.getString("question");
                String optionA = jsonObj.getString("optionA");
                String optionB = jsonObj.getString("optionB");
                String optionC = jsonObj.getString("optionC");
                String optionD = jsonObj.getString("optionD");
                String rightAnswer = jsonObj.getString("rightAnswer");

                questions.add(jsonObj.getString("question"));


            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (questions.size() > 0) {
            txt_questionAdjective = (TextView) findViewById(R.id.category);
            // Use the first question
            txt_questionAdjective.setText(questions.get(0));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
