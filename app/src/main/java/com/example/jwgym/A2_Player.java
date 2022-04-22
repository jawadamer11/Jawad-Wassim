package com.example.jwgym;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class A2_Player extends AppCompatActivity {
    FloatingActionButton profile, reg, sched;
    String n,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_player);



        profile = findViewById(R.id.profile);
        reg = findViewById(R.id.reg);
        sched = findViewById(R.id.sched);





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