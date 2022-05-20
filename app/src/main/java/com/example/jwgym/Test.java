package com.example.jwgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Test extends AppCompatActivity {
    static String URL = "http://192.168.0.107/ceng495";
    static String couchState ="false" ;


    public Test() {
    }

    public Test(String id) {
        id = this.couchState;
    }

    public static String getCouchState() {
        return couchState;
    }

    public static void setCouchState(String couchState) {
        Test.couchState = couchState;
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