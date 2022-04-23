package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class playerViewSched extends AppCompatActivity {
    String a1,b1,c1,d1,e1,f1,g1;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    String x, a,b,c,d,e,f,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_view_sched);




        tx1=findViewById(R.id.q1); tx2=findViewById(R.id.q2); tx3=findViewById(R.id.q3);
        tx4=findViewById(R.id.q4); tx5=findViewById(R.id.q5); tx6=findViewById(R.id.q6);
        tx7=findViewById(R.id.q7);

        Intent intent1 = getIntent();
        a1= intent1.getStringExtra("s1");
        b1= intent1.getStringExtra("s2");
        c1= intent1.getStringExtra("s3");
        d1= intent1.getStringExtra("s4");
        e1= intent1.getStringExtra("s5");
        f1= intent1.getStringExtra("s6");
        g1= intent1.getStringExtra("s7");

        tx1.setText(a1); tx2.setText(b1);
        tx3.setText(c1); tx4.setText(d1);
        tx5.setText(e1); tx6.setText(f1);
        tx7.setText(g1);


        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("playerSchedule", Context.MODE_PRIVATE);
        a = sp1.getString("monday_session","");
        b = sp1.getString("tuesday_session","");
        c = sp1.getString("wednesday_session","");
        d = sp1.getString("thursday_session","");
        e = sp1.getString("friday_session","");
        f = sp1.getString("saturday_session","");
        g = sp1.getString("sunday_session","");



    }

}