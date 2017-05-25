package com.example.india.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
public class EmployeesListActivity extends AppCompatActivity {
    private ListView lvEmployees;
    private List empList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list_item_1);
        lvEmployees = (ListView) findViewById(R.id.list);
        initialize();
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        EmployeeListAdapter adapter = new EmployeeListAdapter(this, empList);
        lvEmployees.setAdapter(adapter);
    } private void initialize() {
        empList = new ArrayList();
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(2,"jack",606060));
        empList.add(new Employee(3,"jack",606060));
        empList.add(new Employee(4,"jack",606060));
        empList.add(new Employee(5,"jack",606060));
        empList.add(new Employee(6,"jack",606060));
        empList.add(new Employee(7,"jack",606060));
        empList.add(new Employee(88,"jack",606060));
        empList.add(new Employee(100,"jack",606060));
        empList.add(new Employee(1000,"jack",606060));
        empList.add(new Employee(2341,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(2,"jack",606060));
        empList.add(new Employee(3,"jack",606060));
        empList.add(new Employee(4,"jack",606060));
        empList.add(new Employee(5,"jack",606060));
        empList.add(new Employee(6,"jack",606060));
        empList.add(new Employee(7,"jack",606060));
        empList.add(new Employee(88,"jack",606060));
        empList.add(new Employee(100,"jack",606060));
        empList.add(new Employee(1000,"jack",606060));
        empList.add(new Employee(2341,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(2,"jack",606060));
        empList.add(new Employee(3,"jack",606060));
        empList.add(new Employee(4,"jack",606060));
        empList.add(new Employee(5,"jack",606060));
        empList.add(new Employee(6,"jack",606060));
        empList.add(new Employee(7,"jack",606060));
        empList.add(new Employee(88,"jack",606060));
        empList.add(new Employee(100,"jack",606060));
        empList.add(new Employee(1000,"jack",606060));
        empList.add(new Employee(2341,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
        empList.add(new Employee(1,"jack",606060));
    } }