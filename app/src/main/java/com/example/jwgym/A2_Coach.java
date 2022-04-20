package com.example.jwgym;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class A2_Coach extends AppCompatActivity {
FloatingActionButton floatingActionButton, floatingActionButton2;
    String n,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_coach);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton2=findViewById(R.id.floatingActionButton2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = getIntent();
                n = j.getStringExtra("seat1");
                p = j.getStringExtra("userpass");

                Intent i1 = new Intent(getApplicationContext(),coach_prof.class);
                i1.putExtra("seat2",n+"");
                i1.putExtra("userpass",p);
                startActivity(i1);
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), coach_sched.class);
                startActivity(i1);
                finish();
            }
        });
    }
}