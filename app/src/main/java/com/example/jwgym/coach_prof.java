package com.example.jwgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class coach_prof extends AppCompatActivity {
TextView username, password, id_c, salary, spec;
    String p,n;
    JSONArray data;
    String ID;
    private String strJson, Url=Test.getURL();
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_prof);
        username= findViewById(R.id.username_c);
        password= findViewById(R.id.password_c);
        id_c= findViewById(R.id.id_c);
        salary= findViewById(R.id.salary);
        spec= findViewById(R.id.spec);

        rq = Volley.newRequestQueue(this);
        Test test = new Test();

        Intent i1 = getIntent();
        n = i1.getStringExtra("seat2");
        p = i1.getStringExtra("userpass");



        String url = Url+"/coachdetail/getID.php?c_name="+n+"&c_password="+p;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                Test.setId(value);
                id_c.setText(Test.getId());
                ID=value;

                getCname();
                getcpassword();
                getSalary();
                getSpec();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }

    public void getID(){

        String url = Url+"/coachdetail/getID.php?c_name="+n+"&c_password="+p;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                Test.setId(value);
                id_c.setText(Test.getId());



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void getCname(){

        String url = Url+"/coachdetail/c_name.php?id="+ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                username.setText(value);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }
    public void getcpassword(){

        String url = Url+"/coachdetail/c_password.php?id="+ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                password.setText(value);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);


    }
    public void getSalary(){

        String url = Url+"/coachdetail/salary.php?id="+ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                salary.setText(value);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }
    public void getSpec(){

        String url = Url+"/coachdetail/specilization.php?id="+ID;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                spec.setText(value);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }


    }
