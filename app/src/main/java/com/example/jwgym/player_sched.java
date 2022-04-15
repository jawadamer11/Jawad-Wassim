package com.example.jwgym;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class player_sched extends AppCompatActivity {
    CheckBox mon, tue, wed, thur, fri, sat, sun;
    TextView t1, t2, t3, t4, t5, t6, t7;
    Button button2;
    int hour, min;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_sched);






        button2=findViewById(R.id.button2);
        mon = findViewById(R.id.mon);
        tue = findViewById(R.id.tue);
        wed = findViewById(R.id.wed);
        thur = findViewById(R.id.thur);
        fri = findViewById(R.id.fri);
        sat = findViewById(R.id.sat);
        sun = findViewById(R.id.sun);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);


        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mon.isChecked()){
                    tue.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t1.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    mon.setChecked(false);
                }
            }
        });

        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tue.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t2.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    tue.setChecked(false);
                }
            }
        });



        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wed.isChecked()){
                    mon.setChecked(false); tue.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t3.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    wed.setChecked(false);
                }
            }
        });

        thur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thur.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);tue.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t4.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    thur.setChecked(false);
                }
            }
        });

        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fri.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    tue.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t5.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    fri.setChecked(false);
                }
            }
        });

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sun.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); tue.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t7.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    sun.setChecked(false);
                }
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sat.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); tue.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t6.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    sat.setChecked(false);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=t1.getText().toString();
                String b=t2.getText().toString();
                String c=t3.getText().toString();
                String d=t4.getText().toString();
                String e=t5.getText().toString();
                String f=t6.getText().toString();
                String g=t7.getText().toString();

                Intent intent = new Intent(getApplicationContext(),playerViewSched.class);
                intent.putExtra("s1", a);
                intent.putExtra("s2", b);
                intent.putExtra("s3", c);
                intent.putExtra("s4", d);
                intent.putExtra("s5", e);
                intent.putExtra("s6", f);
                intent.putExtra("s7", g);
                startActivity(intent);

            }
        });
    }
}