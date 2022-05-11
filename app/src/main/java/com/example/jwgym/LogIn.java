package com.example.jwgym;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    public static final String PREFS_NAME = "MyPrefsFile";
    Button logbtn,fb, insta, loc, call;
    EditText logname, logpass;
    JSONArray data;
    TextView logsignup, admin;
    String etname,etpass, spinner,URL = Test.getURL();
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        call = findViewById(R.id.call);
        logbtn= findViewById(R.id.logbtn);
        fb= findViewById(R.id.fb);
        insta= findViewById(R.id.insta);
        loc= findViewById(R.id.loc);
        logname= (EditText) findViewById(R.id.etname);
        logpass=(EditText) findViewById(R.id.etpass);
        logsignup= findViewById(R.id.logsignup);
        admin= findViewById(R.id.admin);
        spinner2 = findViewById(R.id.spinner2);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri fbpage = Uri.parse("http://www.facebook.com");
                Intent i = new Intent(Intent.ACTION_VIEW, fbpage);
                startActivity(i);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri instapage = Uri.parse("http://www.instagram.com");
                Intent i = new Intent(Intent.ACTION_VIEW, instapage);
                startActivity(i);
            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=zahle,+Lebanon");
                Intent i = new Intent(Intent.ACTION_VIEW, location);
                startActivity(i);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("tel:03072543");
                Intent i = new Intent(Intent.ACTION_DIAL, location);
                startActivity(i);
            }
        });



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
        Intent j = new Intent(getApplicationContext(),player_prof.class);


        spinner = spinner2.getSelectedItem().toString();

        if(spinner.equals("Player")){

            SharedPreferences sharedPreferences = getSharedPreferences(LogIn.PREFS_NAME,0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putBoolean("hasLoggedIn",true);
            editor.commit();

            String url = URL+"/getPlayerById.php?p_name="+etname+"&p_password="+etpass;
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {

                if(response.trim().equals("success")){
                    Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(), A2_Player.class);
                    SharedPreferences sp = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sp.edit();
                    editor1.putString("username",etname);
                    editor1.putString("password",etpass);
                    editor1.commit();
                    startActivity(i);
                    finish();




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
                    Intent i = new Intent(getApplicationContext(), A2_Coach.class);
                    i.putExtra("seat1", etname+"");
                    i.putExtra("userpass",etpass);
                    startActivity(i);
                    finish();


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