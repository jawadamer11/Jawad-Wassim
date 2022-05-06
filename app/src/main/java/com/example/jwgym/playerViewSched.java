package com.example.jwgym;

import android.content.Context;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.jwgym.Test.URL;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class playerViewSched extends AppCompatActivity {
    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7;
    String n;
    String ID;
    public String currentDate;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_view_sched);


        tx1 = findViewById(R.id.q1);
        tx2 = findViewById(R.id.q2);
        tx3 = findViewById(R.id.q3);
        tx4 = findViewById(R.id.q4);
        tx5 = findViewById(R.id.q5);
        tx6 = findViewById(R.id.q6);
        tx7 = findViewById(R.id.q7);


        Calendar calendar = Calendar.getInstance();
        currentDate = java.text.DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
       // String Day = currentDate.substring(3);

            if(currentDate.startsWith("Mon") && tx1.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Monday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Tue") && tx2.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Tuesday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Wed") && tx3.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Wednesday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Thur") && tx4.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Thursday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Fri") && tx5.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Friday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Sat") && tx6.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Saturday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }
            else
            if(currentDate.startsWith("Sun") && tx7.getText().toString() != "No Session"){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "notif");
                builder.setContentTitle("Sunday Workout!!!");
                builder.setContentText("Are you ready for today's workout?");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(1, builder.build());
            }




        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        n = sp.getString("username", "");

        String url = URL + "/plscheddetail/getID.php?pname=" +n;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                Test.setId(value);
                ID = value;


                getpname();
                getMon();
                getThursday();
                getWed();
                getFri();
                getSat();
                getSun();
                getTues();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getID() {

        String url = URL + "/plscheddetail/getID.php?pname=" + n;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                Test.setId(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


        //  return ID;
    }


    public void getpname() {


        String url = URL + "/plscheddetail/p_name.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                //  pname.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getMon() {


        String url = URL+"/plscheddetail/Monday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx1.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getTues() {


        String url = URL+"/plscheddetail/Tuesday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx2.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getWed() {


        String url = URL+"/plscheddetail/Wednesday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx3.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getThursday() {


        String url = URL + "/plscheddetail/Thursday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx4.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getSat() {


        String url = URL + "/plscheddetail/Saturday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx6.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getSun() {


        String url = URL + "/plscheddetail/Sunday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx7.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    public void getFri() {


        String url = URL + "/plscheddetail/Friday.php?ID=" + ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                tx5.setText(value);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }
}