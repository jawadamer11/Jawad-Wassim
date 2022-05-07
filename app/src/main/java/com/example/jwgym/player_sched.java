package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Locale;

public class player_sched extends AppCompatActivity {
    CheckBox mon, tue, wed, thur, fri, sat, sun;
    TextView t1, t2, t3, t4, t5, t6, t7;
    Button button5, button4;
    int hour, min;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sched);

        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        mon = findViewById(R.id.mon);
        tue = findViewById(R.id.tue);
        wed = findViewById(R.id.wed);
        thur = findViewById(R.id.thur);
        fri = findViewById(R.id.fri);
        sat = findViewById(R.id.sat);
        sun = findViewById(R.id.sun);
        t1 = findViewById(R.id.cname3);
        t2 = findViewById(R.id.csalaryc);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);


        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mon.isChecked()){
                    tue.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t1.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    mon.setChecked(false);
                }}});

        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tue.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t2.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    tue.setChecked(false);
                }}});



        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wed.isChecked()){
                    mon.setChecked(false); tue.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t3.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    wed.setChecked(false);
                    //p = hour+":"+min;
                }}});

        thur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thur.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);tue.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t4.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    thur.setChecked(false);
                }}});

        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fri.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    tue.setChecked(false); sat.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t5.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    fri.setChecked(false);
                }}});

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sun.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); sat.setChecked(false); tue.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t7.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    sun.setChecked(false);
                }}});
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sat.isChecked()){
                    mon.setChecked(false); wed.setChecked(false);thur.setChecked(false);
                    fri.setChecked(false); tue.setChecked(false); sun.setChecked(false);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(player_sched.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hour= hourOfDay;
                                    min= minute;
                                    t6.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min));
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    sat.setChecked(false);
                }}});

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=t1.getText().toString();
                String b=t2.getText().toString();
                String c=t3.getText().toString();//+" PM";
                String d=t4.getText().toString();//+" PM";
                String e=t5.getText().toString();//+" PM";
                String f=t6.getText().toString();//+" PM";
                String g=t7.getText().toString();//+" PM";

              /*  String a=t1.getText().toString()+" PM";
                String b=t2.getText().toString()+" PM";
                String c=t3.getText().toString()+" PM";
                String d=t4.getText().toString()+" PM";
                String e=t5.getText().toString()+" PM";
                String f=t6.getText().toString()+" PM";
                String g=t7.getText().toString()+" PM";*/

                SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
                String x = sp.getString("username","");

                String url = URL+"/addtosched.php?pname=" + x + "&Monday=" + a + "&Tuesday=" + b +
                        "&Wednesday=" + c + "&Thursday=" + d + "&Friday=" + e + "&Saturday=" + f + "&Sunday=" + g;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest(Request.Method.GET, url,

                        response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                        error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                            //pb.setVisibility(View.INVISIBLE);
                        }
                );
                queue.add(request);
                // Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),playerViewSched.class);
                startActivity(intent);
                finish();

            }});
    }
}