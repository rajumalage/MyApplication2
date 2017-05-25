package com.example.india.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Reg_Form extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg__form);


        final EditText emai = (EditText) findViewById(R.id.emil);
        final EditText pwd = (EditText) findViewById(R.id.pwd);
        final EditText uname=(EditText) findViewById(R.id.unme);
        final EditText rpwd=(EditText) findViewById(R.id.rpd);
        final EditText mob=(EditText) findViewById(R.id.mbnm);
        final EditText db=(EditText) findViewById(R.id.dob1);
        final Button validate = (Button) findViewById(R.id.validate);
       final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        //Intent intent = new Intent(getApplicationContext(), splash_screen.class);
        //startActivity(intent);

        //Intent intent=new Intent(Reg_Form.this,NewActivity.class);
        //startActivityForResult(intent, 2);

        //Intent intent3=new Intent("com.example.india.myapplication.splash_screen");
        //startActivity(intent3);



        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (!validateUname(uname.getText().toString())) {
                    uname.setError("Invalid Name");
                    uname.requestFocus();
                     uname.startAnimation(shake);
                }
                  else if (!validateMob(mob.getText().toString())) {
                    mob.setError("Invalid Mobile Number");
                    mob.requestFocus();
                     mob.startAnimation(shake);
                }
                  else if (!validateEmail(emai.getText().toString())) {
                    emai.setError("Invalid Email");
                    emai.requestFocus();
                     emai.startAnimation(shake);
                } else if (!validatePass(pwd.getText().toString())) {
                    pwd.setError("Password should be greater 6 charecter");
                    pwd.requestFocus();
                     pwd.startAnimation(shake);
                }
             /*    else if (!validateRePass(rpwd.getText().toString())) {
                    rpwd.setError("Re-Enter Password");
                    rpwd.requestFocus();
                } */

                 else if(!pwd.getText().toString().equals(rpwd.getText().toString())) {
                    rpwd.setError("Password Not matched");
                    rpwd.requestFocus();
                     rpwd.startAnimation(shake);
                }
                 else if(!validateDOB(db.getText().toString())) {
                     db.setError("Enter Valid D.O.B");
                     db.requestFocus();
                     db.startAnimation(shake);
                 }

                  else {
                    Toast.makeText(Reg_Form.this, "Registration Sucess!!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private boolean validateDOB(String dob) {
        String regex = "^\\d{2}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dob);
        return matcher.matches();

    }

    private boolean validateMob(String mob) {
        String regex = "^[789]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mob);
        return matcher.matches();

    }

    /* private boolean validateRePass(String rpwd) {
        if(rpwd!=null && rpwd.equals(pwd))
            return true;
        else {
            return false;
        }

    } */

    private boolean validateUname(String uname) {
        String regex = "^[a-zA-Z\\\\s]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uname);

        return matcher.matches();

    }

    private boolean validatePass(String pwd1) {
        if (pwd1 != null && pwd1.length() > 6) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validateEmail(String emai) {
        String regex = "^[A-Za-z0-9+_.-]+@[a-zA-Z].+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emai);

        return matcher.matches();

    }



}
