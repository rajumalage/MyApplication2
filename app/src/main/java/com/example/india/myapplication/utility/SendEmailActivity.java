package com.example.india.myapplication.utility;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;

        import com.example.india.myapplication.R;

public class SendEmailActivity extends Activity {

    Button buttonSend;
    EditText textTo;
    EditText textSubject;
 //   EditText textMessage;
    EditText pwdedit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sending_email);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textTo = (EditText) findViewById(R.id.editTextTo);
        textSubject = (EditText) findViewById(R.id.editTextSubject);
     //   textMessage = (EditText) findViewById(R.id.editTextMessage);
        pwdedit=(EditText) findViewById(R.id.pwdedt);

        buttonSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = textTo.getText().toString();
                String subject = textSubject.getText().toString();
           //     String message = textMessage.getText().toString();
                String pass=pwdedit.getText().toString();
                double pasd=(double)Math.random()*pass.length()+32;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
            //    email.putExtra(Intent.EXTRA_TEXT, message);
                email.putExtra(Intent.EXTRA_TEXT,pasd);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}