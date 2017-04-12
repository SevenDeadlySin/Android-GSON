package com.raksa.gsonapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView) findViewById(R.id.textViewResult);



    }

    public void onSaveCustomDataButton(View view) {

        //create employee object
        Employee employee = new Employee();
        employee.setName("Raksa Meth");
        employee.setProfession("Software Engineer");
        employee.setPro_id(213);
        employee.setRoles(Arrays.asList("Admin","Moderator"));

        //get the SharedPreference reference..
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //using GSON to serialise the data to JSON
        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(employee,Employee.class);

        editor.putString("Employee",jsonEmployee);
        editor.apply();
    }

    public void onLoadCustomDataButton(View view) {

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String jsonEmployee = sharedPreferences.getString("Employee","N/A");

        //Deserialization
        Gson gson = new Gson();
        Employee employee = gson.fromJson(jsonEmployee,Employee.class);

        String result = "Name : "+employee.getName()+"\nProfession : "+employee.getProfession()+"\nProfile ID: "
                +employee.getPro_id()+"\nRole : "+employee.getRoles().get(0)+","+employee.getRoles().get(1);

        textViewResult.setText(result);
    }

    public void onSaveGenericDataButton(View view) {
    }

    public void onLoadGenericDataButton(View view) {
    }
}
