package com.example.india.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class ConvertMoney extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_money);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert_money, menu);
        return true;
    }
    public void clickPound(View view)
    {

            TextView scr = (TextView) findViewById(R.id.display);
            scr.setText("");
            EditText txt = (EditText) findViewById(R.id.editText);
            float ans = Float.parseFloat(txt.getText().toString());
            double convert = ans * 0.012;

            scr.setText(String.valueOf(convert));


        }
    public void ToEuro(View view)
    {


            TextView scr = (TextView) findViewById(R.id.display);
            scr.setText("");
            EditText txt = (EditText) findViewById(R.id.editText);
            float ans = Float.parseFloat(txt.getText().toString());
            double convert = ans * 0.014;
            scr.setText(String.valueOf(convert));

    }

    public void ToDinar(View view)
    {

            TextView scr = (TextView) findViewById(R.id.display);
            scr.setText("");
            EditText txt = (EditText) findViewById(R.id.editText);
            float ans = Float.parseFloat(txt.getText().toString());
            double convert = ans * 17.62;

            scr.setText(String.valueOf(convert));

    }

    public void clickDollar(View view)
    {

            TextView scr = (TextView) findViewById(R.id.display);
            // scr.setText("");
            EditText txt = (EditText) findViewById(R.id.editText);
            float ans = Float.parseFloat(txt.getText().toString());
            double convert = ans * 0.015;
            scr.setText(String.valueOf(convert));



        //  Toast.makeText(getApplicationContext(),  "checked", Toast.LENGTH_LONG).show(); //genymotin wala emulator on kryn
        //if(check.isChecked())
        //{

        //TextView uni = (TextView) findViewById(R.id.unitss);
        //uni.setText("$");
        //}
        //else
        //{

        //}


    }

    /*@Override
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
    }*/
}
