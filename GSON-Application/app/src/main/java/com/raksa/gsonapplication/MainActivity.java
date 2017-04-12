package com.raksa.gsonapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

    }

    public void onSaveCustomDataButton(View view) {
    }

    public void onLoadCustomDataButton(View view) {
    }

    public void onSaveGenericDataButton(View view) {
    }

    public void onLoadGenericDataButton(View view) {
    }
}
