package com.example.jwgym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override



            public void run(){
                SharedPreferences sharedPreferences = getSharedPreferences(LogIn.PREFS_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);

                if(hasLoggedIn){
                    Intent i = new Intent(MainActivity.this,A2_Player.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Intent i = new Intent(MainActivity.this,LogIn.class);
                    startActivity(i);
                    finish();
                }
            }


        },1200);
    }
}