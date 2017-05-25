package com.example.india.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

public class RandPass extends Activity implements OnClickListener{
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText etEmail, etFullName, etPhoneNumber;
    String rec,FullName,PhoneNumber;
    //Generating Password fileds
    int noOfCAPSAlpha = 1;
    int noOfDigits = 1;
    int noOfSplChars = 1;
    int minLen = 8;
    int maxLen = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randumpass_activity);

        context = this;
        Button login = (Button) findViewById(R.id.regi);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFullName = (EditText) findViewById(R.id.etFullName);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rec = etEmail.getText().toString();
        FullName = etFullName.getText().toString();
        PhoneNumber = etPhoneNumber.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("madhan7792@gmail.com", "alexandermadhan@7");
            }
        });
        pdialog = ProgressDialog.show(context, "", "Sending Mail...", true);
        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }
    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("madhan7792@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));

                char[] pswd = RandomPasswordGenerator.generatePswd(minLen, maxLen,
                        noOfCAPSAlpha, noOfDigits, noOfSplChars);
                message.setSubject("Your Random Generate Password");
                message.setContent(new String(pswd), "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            etEmail.setText("");
            etFullName.setText("");
            etPhoneNumber.setText("");
            Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
        }
    }

}

