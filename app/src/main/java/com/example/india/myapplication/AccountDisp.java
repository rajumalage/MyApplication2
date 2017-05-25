package com.example.india.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AccountDisp extends AppCompatActivity implements View.OnClickListener
{
    EditText editNumber;
    Button bkdis;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountdisp);
        editNumber = (EditText) findViewById(R.id.editNumber);
        bkdis = (Button) findViewById(R.id.bkdis);
        bkdis.setOnClickListener(this);
        db = openOrCreateDatabase("BankAccountDB", Context.MODE_PRIVATE, null);
    }

    public void onClick(View view) {
        if (view == bkdis) {
            Cursor c = db.rawQuery("SELECT * FROM student WHERE number='" + editNumber.getText() + "'", null);

            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Account Number: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Amount: " + c.getString(2) + "\n\n");
            }
            showMessage("Student Details", buffer.toString());
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
        editNumber.requestFocus();
    }

}




