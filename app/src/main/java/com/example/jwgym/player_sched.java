package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.annotation.SuppressLint;
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
    Button button2;
    int hour, min;
    String x;
    String p, f, Day, a, b, c, d, e, g, q;
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
                                    p = hour+":"+min;
                                    t1.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");

                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    mon.setChecked(false);
                }
                Day="Monday";
                q= p;



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
                                    p = hour+":"+min;
                                    Day="Tuesday";
                                    t2.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    tue.setChecked(false);
                    q=p;
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
                                    p = hour+":"+min;
                                    Day="Wednesday";
                                    t3.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, min)+" PM");
                                }
                            }, hour, min, false);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                    wed.setChecked(false);
                    p = hour+":"+min;
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
                                    p = hour+":"+min;
                                    q=p;
                                    Day="Thursday";
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
                                    p = hour+":"+min;
                                    Day="Friday";
                                    q=p;

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
                                    p = hour+":"+min;
                                    q=p;
                                    Day="Sunday";
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
                                    p = hour+":"+min;
                                    q=p;
                                    Day="Saturday";
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

                 a=t1.getText().toString();
                 b=t2.getText().toString();
                c=t3.getText().toString();
                d=t4.getText().toString();
                 e=t5.getText().toString();
                f=t6.getText().toString();
                g=t7.getText().toString();

                Intent intent = new Intent(getApplicationContext(),playerViewSched.class);
                intent.putExtra("s1", a);
                intent.putExtra("s2", b);
                intent.putExtra("s3", c);
                intent.putExtra("s4", d);
                intent.putExtra("s5", e);
                intent.putExtra("s6", f);
                intent.putExtra("s7", g);
                startActivity(intent);

                /*getMON();
                getTUES();
                getWED();
                getTHURS();
                getFRI();
                getSAT();
                getSUN();*/
            }
        });
    }
   /* public void getMON(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + a + "&Day=" + "Monday" ;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, url,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue.add(request);
    }
    public void getTUES(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + b + "&Day=" + "Tuesday" ;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, url,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue.add(request);
    }
    public void getWED(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url3 = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + c + "&Day=" + "Wednesday" ;

        RequestQueue queue3 = Volley.newRequestQueue(getApplicationContext());
        StringRequest request3 = new StringRequest(Request.Method.GET, url3,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue3.add(request3);
    }
    public void  getTHURS(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url4 = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + d + "&Day=" + "Thursday" ;

        RequestQueue queue4 = Volley.newRequestQueue(getApplicationContext());
        StringRequest request4 = new StringRequest(Request.Method.GET, url4,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue4.add(request4);
    }
    public void getFRI(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url5 = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + e + "&Day=" + "Friday" ;

        RequestQueue queue5 = Volley.newRequestQueue(getApplicationContext());
        StringRequest request5 = new StringRequest(Request.Method.GET, url5,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue5.add(request5);
    }
    public void getSAT(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url6= URL+"/addtosched.php?pname=" + x + "&SessionHour=" + f + "&Day=" + "Saturday" ;

        RequestQueue queue6 = Volley.newRequestQueue(getApplicationContext());
        StringRequest request6 = new StringRequest(Request.Method.GET, url6,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue6.add(request6);

    }
    public  void getSUN(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        x = sp.getString("username","");
        String url7 = URL+"/addtosched.php?pname=" + x + "&SessionHour=" + g + "&Day=" + "Sunday" ;

        RequestQueue queue7 = Volley.newRequestQueue(getApplicationContext());
        StringRequest request7 = new StringRequest(Request.Method.GET, url7,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue7.add(request7);
    }*/
}