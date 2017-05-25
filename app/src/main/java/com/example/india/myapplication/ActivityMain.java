package com.example.india.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by india on 2/23/2017.
 */

public class ActivityMain extends AppCompatActivity {
 //   private static Button button_sbm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
 //       onClickButtonListener();
        Button b1=(Button)findViewById(R.id.button8);
        Button b2=(Button)findViewById(R.id.button7);
        Button b3=(Button)findViewById(R.id.button6);
        Button b4=(Button)findViewById(R.id.button9);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
          Intent intent1=new Intent(ActivityMain.this,Calc.class);
          startActivity(intent1);
                                  }
                              }
        );

        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent2=new Intent(ActivityMain.this,ConvertMoney.class);
                                      startActivity(intent2);
                                  }
                              }
        );

        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent3=new Intent(ActivityMain.this,AlgoBenchmarkActivity.class);
                                      startActivity(intent3);
                                  }
                              }
        );

        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent4=new Intent(ActivityMain.this,NewActivity.class);
                                      startActivity(intent4);
                                  }
                              }
        );
    }
  /*  public void onClickButtonListener(){
        button_sbm = (Button)findViewById(R.id.button8);
        button_sbm = (Button)findViewById(R.id.button7);
        button_sbm = (Button)findViewById(R.id.button6);
        button_sbm = (Button)findViewById(R.id.button9);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.india.myapplication.Calc");
                        startActivity(intent);
                        Intent intent1=new Intent("com.example.india.myapplication.ConvertMoney");
                        startActivity(intent1);
                        Intent intent2=new Intent("com.example.india.myapplication.AlgoBenchmarkActivity");
                        startActivity(intent2);
                        Intent intent3=new Intent("com.example.india.myapplication.NewActivity");
                        startActivity(intent3);

                    }
                }
        );
    }   */
}
