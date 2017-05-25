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

public class AccountWithdraw extends AppCompatActivity implements View.OnClickListener{
    EditText editNumber,editAmt;
    Button bknew;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountwithdraw);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editAmt = (EditText) findViewById(R.id.editAmt);
        bknew = (Button) findViewById(R.id.bknew);
        bknew.setOnClickListener(this);
        db = openOrCreateDatabase("BankAccountDB", Context.MODE_PRIVATE, null);
    }

    public void onClick(View view) {
        if (view == bknew) {
            if (editNumber.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Account Number");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE number='" + editNumber.getText() + "'", null);

           /* if(c.getString(2).equals(0))
            {
                showMessage("Error","insufficient Balance");

            } */
            if (c.moveToFirst()) {
                db.execSQL("UPDATE student SET amount = amount - '" + editAmt.getText() +
                        "' WHERE number='" + editNumber.getText() + "'");
                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", " Invalid Account Number");
            }
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
        editAmt.setText("");
        editNumber.requestFocus();
    }


}


