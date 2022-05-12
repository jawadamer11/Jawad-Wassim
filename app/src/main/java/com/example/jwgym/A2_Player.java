package com.example.jwgym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class A2_Player extends AppCompatActivity {
    FloatingActionButton profile, reg, sched;
    String n,p;
    ImageView logoutIMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_player);



        profile = findViewById(R.id.profile);
        reg = findViewById(R.id.reg);
        sched = findViewById(R.id.sched);
        logoutIMG = findViewById(R.id.logoutIMG);

        logoutIMG.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
            logoutIMG.startAnimation(animation);
            SharedPreferences sharedPreferences = getSharedPreferences(LogIn.PREFS_NAME,0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putBoolean("hasLoggedIn",false);
            editor.clear();
            editor.commit();
            Intent i = new Intent(getApplicationContext(),LogIn.class);
            startActivity(i);
            finish();
        });





        profile.setOnClickListener(v -> {
            Intent j = getIntent();
            n = j.getStringExtra("seat1");
            p = j.getStringExtra("userpass");

            Intent i1 = new Intent(getApplicationContext(),player_prof.class);
            i1.putExtra("seat2",n+"");
            i1.putExtra("userpass",p);
            startActivity(i1);
        });
        reg.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), player_reg.class);
            startActivity(i);

        });
        sched.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), player_sched.class);
            startActivity(i);
            finish();
        });

    }
}