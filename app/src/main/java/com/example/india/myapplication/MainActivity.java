package com.example.india.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button submit;
    EditText edtUser, edtPass, edtConfPass, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization of all editText

        edtUser=(EditText)findViewById(R.id.userName);
        edtPass=(EditText)findViewById(R.id.pwd);
        edtConfPass=(EditText)findViewById(R.id.repwd);
        edtEmail=(EditText)findViewById(R.id.emailID);
        //Initialization of Register Button
        submit=(Button)findViewById(R.id.sub);

        //Registration button functionality
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                if(edtUser.getText().toString().length()>6)
                {
                    edtUser.setError("Username Should Be Greater Then 6 Charecter");
                    edtUser.requestFocus();
                }
                else
                {
                    if(edtUser.getText().toString().length()==0)
                    {
                        edtUser.setError("Username is Required");
                        edtUser.requestFocus();
                    }
                }
                if(edtEmail.getText().toString().length()==0){
                    edtEmail.setError("Email-ID is Required");
                    edtEmail.requestFocus();
                }
                if(edtPass.getText().toString().length()==0){
                    edtPass.setError("Password not entered");
                    edtPass.requestFocus();
                }
                if(edtConfPass.getText().toString().length()==0){
                    edtConfPass.setError("Please confirm password");
                    edtPass.requestFocus();
                }
                if(!edtPass.getText().toString().equals(edtConfPass.getText().toString())){
                    edtConfPass.setError("Password Not matched");
                    edtConfPass.requestFocus();
                }
                if(edtPass.getText().toString().length()>6){
                    edtPass.setError("Password should be atleast of 6 charactors");
                    edtPass.requestFocus();


                }

                else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }

            }
        });
    }



}