package com.example.india.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

   // int id;
    String name;
  //  int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    } */

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub

    }

}
