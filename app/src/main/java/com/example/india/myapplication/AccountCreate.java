package com.example.india.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

public class AccountCreate extends AppCompatActivity implements View.OnClickListener
{

    EditText editNumber,editName,editAmt;
    Button bknew;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountcreate);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editName = (EditText) findViewById(R.id.editName);
        editAmt = (EditText) findViewById(R.id.editAmt);
        bknew = (Button) findViewById(R.id.bknew);
        bknew.setOnClickListener(this);

        db = openOrCreateDatabase("BankAccountDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(number VARCHAR,name VARCHAR,amount VARCHAR);");
    }
    public void onClick(View view) {
        if (view == bknew) {
            if (editNumber.getText().toString().trim().length() == 0 ||
                    editName.getText().toString().trim().length() == 0 ||
                    editAmt.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('" + editNumber.getText() + "','" + editName.getText() +
                    "','" + editAmt.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
    }
        public void showMessage(String title,String message)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();
        }
        public void clearText()
        {
            editNumber.setText("");
            editName.setText("");
            editAmt.setText("");
            editNumber.requestFocus();
        }

    }

