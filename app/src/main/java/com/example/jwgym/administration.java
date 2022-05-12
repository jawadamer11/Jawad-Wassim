package com.example.jwgym;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class administration extends AppCompatActivity {
    FloatingActionButton manageplayer, managecoach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);





        manageplayer=findViewById(R.id.manageplayer);
        managecoach=findViewById(R.id.managecoach);

        manageplayer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
                manageplayer.startAnimation(animation);
                Intent i = new Intent(getApplicationContext(), managePlayer.class);
                startActivity(i);

            }
        });

        managecoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
                managecoach.startAnimation(animation);
                Intent i = new Intent(getApplicationContext(), manageCoach.class);
                startActivity(i);

            }
        });
    }
}