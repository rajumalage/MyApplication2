package com.example.india.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.example.india.myapplication.R.id.email;

public class email_pass extends AppCompatActivity {

    private EditText toEmail = null;
    private EditText emailSubject = null;
    private EditText emailBody = null;
    private TextView pwd=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_pass);

        toEmail = (EditText) findViewById(R.id.toEmail);
        emailSubject = (EditText) findViewById(R.id.subject);
        emailBody = (EditText) findViewById(R.id.emailBody);
        pwd=(TextView) findViewById(R.id.pwd);

    }
    public void randumpwd() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (new Random().nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                toEmail.setText("");
                emailBody.setText("");
                emailSubject.setText("");
                pwd.setText("");
                break;
            case R.id.menu_send:
                String to = toEmail.getText().toString();
                String subject = emailSubject.getText().toString();
                String message = emailBody.getText().toString();
                String pass=pwd.getText().toString();
                randumpwd();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.putExtra(Intent.EXTRA_TEXT,pass);


                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client"));

                break;
        }
        return true;
    }


}

