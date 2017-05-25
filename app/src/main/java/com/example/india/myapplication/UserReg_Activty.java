package com.example.india.myapplication;

import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserReg_Activty extends AppCompatActivity {
    private EditText userName;
    private EditText email;
    private EditText mobile;
    private EditText password;
    private EditText rePassword;
    DatePicker pickerDate;
    TextView info;
    private static TextView dob;

    public void doRegister(View view) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String regeu = "^[a-zA-Z]{6,18}$";
        String regen = "^[0-0]{10}$";
        String pswd = password.getText().toString();
        String repwds = rePassword.getText().toString();

        String dateOfBirth = dob.getText().toString();
        int year = 0;
        int presentYear = 0;
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yourDate = parser.parse(dateOfBirth);
            year = yourDate.getYear();
            Calendar calendar = Calendar.getInstance();
            presentYear = calendar.get(Calendar.YEAR);
        } catch (ParseException e) {
            //e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        if (userName.getText().toString().equals("")){
            userName.setError("Please Enter Name");}
        else {
            if (email.getText().toString().equals(regeu) != true)
                email.setError("Please enter valid user name");
        }
        if (email.getText().toString().equals("")) {
            email.setError("Please enter Email");
        } else {
            if (email.getText().toString().equals(regex) != true)
                email.setError("Please enter valid Email");
        }
        if (mobile.getText().toString().equals("")){
            mobile.setError("Please Enter Number");}
           else {
            if (email.getText().toString().equals(regen) != true)
                email.setError("Please enter valid user name");
        }
        if (pswd.equals(""))
            password.setError("Please enter password");
        else {

            if (pswd.equals(repwds)) {

            } else
                rePassword.setError("Please re-enter password");
        }
        if (presentYear - year > 60)
            dob.setError("Age must be less than 60");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg__activty);
        dob = (TextView) findViewById(R.id.info);
        userName = (EditText) findViewById(R.id.uname);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.mbnum);
        password = (EditText) findViewById(R.id.ped);
        rePassword = (EditText) findViewById(R.id.rped);

        info = (TextView)findViewById(R.id.info);
        pickerDate = (DatePicker)findViewById(R.id.pickerdate);

        Calendar today = Calendar.getInstance();

        pickerDate.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener(){

                    @Override
                    public void onDateChanged(DatePicker view,
                                              int year, int monthOfYear,int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "onDateChanged", Toast.LENGTH_SHORT).show();

                        info.setText(
                                "Year: " + year + "\n" +
                                        "Month of Year: " + monthOfYear + "\n" +
                                        "Day of Month: " + dayOfMonth);

                    }});

    }



}

