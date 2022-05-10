package com.example.jwgym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView im2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       im2= findViewById(R.id.imageView2);


                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                im2.startAnimation(animation);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_anim);
                im2.startAnimation(animation1);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                im2.startAnimation(animation2);




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
                    Intent i = new Intent(MainActivity.this,AfterHandler.class);
                    startActivity(i);
                    finish();
                }
            }


        },1200);
    }
}