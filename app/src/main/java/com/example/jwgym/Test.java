package com.example.jwgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Test extends AppCompatActivity {
    static String URL = "http://192.168.0.108/ceng495";
    static String id ;

    public Test() {
    }

    public Test(String id) {
        id = this.id;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Test.id = id;
    }

    public static String getURL() {
        return URL;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}