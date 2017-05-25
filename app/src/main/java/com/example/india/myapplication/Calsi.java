package com.example.india.myapplication;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by india on 2/24/2017.
 */

public class Calsi extends AppCompatActivity {
    EditText n1,n2;
    TextView tvResult;
    Spinner spin;
    String[] ops={"Choose operation","ADD","SUB","MUL","DIV"};
    String opselected;
    double a,b,c;
    public void onCaculation(View view){
        a=Double.parseDouble(n1.getText().toString());
        b=Double.parseDouble(n2.getText().toString());
        if (opselected=="ADD"){c=a+b; tvResult.setText(Double.toString(c));}
        else if (opselected=="SUB"){c=a-b; tvResult.setText(Double.toString(c));}
        else if (opselected=="MUL"){c=a*b; tvResult.setText(Double.toString(c));}
        else if (opselected=="DIV"){c=a/b; tvResult.setText(Double.toString(c));}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calsi_activity);

        tvResult= (TextView)findViewById(R.id.tvResult);

        n1= (EditText)findViewById(R.id.num1);
        n1.setText("");
        n2 = (EditText)findViewById(R.id.num2);
        n2.setText("");

        //list of operations
        spin = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, ops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
    public void onItemSelected (AdapterView<?> p,View view,int position,long id) {
        opselected=ops[position];
        tvResult.setText("You have selected " + opselected);
    }
    public void onNothingSelected(AdapterView<?> p) {
        tvResult.setText("Please select ops");
    }
}
