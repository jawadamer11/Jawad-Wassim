package com.example.jwgym;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {
    Button logbtn;
    EditText logname, logpass;
    JSONArray data;
    TextView logsignup, admin;
    String etname,etpass, spinner,URL = test.getURL();
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);




        logbtn= findViewById(R.id.logbtn);
        logname= (EditText) findViewById(R.id.etname);
        logpass=(EditText) findViewById(R.id.etpass);
        logsignup= findViewById(R.id.logsignup);
        admin= findViewById(R.id.admin);
        spinner2 = findViewById(R.id.spinner2);




        logsignup.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SignUp.class);
            startActivity(i);
            finish();
        });
        admin.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Adminlogin.class);
            startActivity(i);
            finish();
        });
        logbtn.setOnClickListener(v -> Login());

    }
    public void Login(){
        etname = logname.getText().toString();
        etpass = logpass.getText().toString();
        spinner = spinner2.getSelectedItem().toString();

        if(spinner.equals("Player")){
            String url = URL+"/loginnn.php?p_name="+etname+"&p_password="+etpass;
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {

                if(response.trim().equals("success")){
                    Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(), A2_Player.class);
                    i.putExtra("seat1", etname+"");
                    startActivity(i);



                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed!",Toast.LENGTH_LONG).show();
                }
            }, error -> Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show()){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("UserName",logname.getText().toString().trim());
                    params.put("Password",logpass.getText().toString().trim());
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
        if(spinner.equals("Coach")){
            String url = URL+"/getCoachById.php?c_name="+etname+"&c_password="+etpass;
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {

                if(response.trim().equals("success")){
                    Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LogIn.this,A2_Coach.class);
                    startActivity(i);


                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed!",Toast.LENGTH_LONG).show();
                }
            }, error -> Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show()){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("UserName",logname.getText().toString().trim());
                    params.put("Password",logpass.getText().toString().trim());
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }
}