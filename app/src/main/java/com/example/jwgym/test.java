package com.example.jwgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class test extends AppCompatActivity {
    static String URL = "http://192.168.0.108/ceng495";

    public static String getURL() {
        return URL;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}