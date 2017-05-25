package com.example.india.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class BankAccount extends AppCompatActivity {
    //   private static Button button_sbm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bankaccount);
        //       onClickButtonListener();
        Button b1 = (Button) findViewById(R.id.bknew);
        Button b2 = (Button) findViewById(R.id.bkdis);
        Button b3 = (Button) findViewById(R.id.bkdpt);
        Button b4 = (Button) findViewById(R.id.bkwdr);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent1 = new Intent(BankAccount .this, AccountCreate.class);
                                      startActivity(intent1);
                                  }
                              }
        );

        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent2 = new Intent(BankAccount .this, AccountDisp.class);
                                      startActivity(intent2);
                                  }
                              }
        );

        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent3 = new Intent(BankAccount .this, AccountDeposit.class);
                                      startActivity(intent3);
                                  }
                              }
        );

        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent4 = new Intent(BankAccount .this, AccountWithdraw.class);
                                      startActivity(intent4);
                                  }
                              }
        );
    }
}