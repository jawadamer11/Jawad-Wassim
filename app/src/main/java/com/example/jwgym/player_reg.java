package com.example.jwgym;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class player_reg extends AppCompatActivity {
    TextView username,status,payment,privateSession,cooosh,textView2;
    Button btnreg,cancelBtn;
    String n,p, Url = Test.getURL();
    public String currentDate;
    public int g;
    String ID,c_id;
    //public String sal="false";




    int cost=200000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_reg);

        privateSession = findViewById(R.id.PrivateSession);
        username = findViewById(R.id.username);
        status = findViewById(R.id.status);
        payment = findViewById(R.id.payment);
        btnreg = findViewById(R.id.button);
        cooosh = findViewById(R.id.coachhh);
        textView2 = findViewById(R.id.textView2);
        cancelBtn = findViewById(R.id.cancelBtn);

        new Handler().postDelayed(new Runnable() {
            @Override



            public void run(){
                Intent j = getIntent();
                cooosh.setText(j.getStringExtra("cname"));
                // sal = Integer.parseInt((j.getStringExtra("salary")));



                if(Test.getCouchState()=="false") {

                    payment.setText(cost+"");
                }
                else{
                    textView2.setVisibility(View.VISIBLE);
                    c_id = j.getStringExtra("c_id");
                    cost = cost+125000;
                    payment.setText(cost+"");
                }
            }


        },120);


        SharedPreferences sp = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        username.setText(sp.getString("username", ""));

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView date = findViewById(R.id.Textview);
        date.setText(currentDate);




        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        n = sp.getString("username","");
        p = sp.getString("password","");
        blockage();

        btnreg.setOnClickListener(v -> {
            String url = Url+"/playerdetail/getID.php?p_name="+n+"&p_password="+p;
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    String value = response.trim();
                    ID=value;
                    if(g==0){
                        register();
                       // Toast.makeText(getApplicationContext(),"Registration succeeded",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"not allowed to register",Toast.LENGTH_LONG).show();

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
        });


    privateSession.setOnClickListener(v -> {
        Intent i = new Intent(getApplicationContext(),PrivateSession.class);
        startActivity(i);

    });



    cancelBtn.setOnClickListener(v -> {
        CreateAlertDialog();


    });








    }

    private void CreateAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you Sure of canceling Membership?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                cancelRegitration();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //  Toast.makeText(getApplicationContext(),"asdgeas ",Toast.LENGTH_LONG).show();
            }
        });
        builder.create();
        builder.show();
    }

    private void cancelRegitration() {

        String url = Url+"/registration/cancelRegistration.php?p_id="+ID;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, url,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue.add(request);
    }
/*
    @Override
    protected void onResume() {
        Intent j = getIntent();
        cooosh.setText(j.getStringExtra("cname"));
       // sal = Integer.parseInt((j.getStringExtra("salary")));
        while(sal=="false"){
            payment.setText(sal);

            sal = j.getStringExtra("salary");
        }



       // payment.setText(sal);

        super.onResume();
    }*/

    public void blockage(){
        String url = Url+"/registration/blockedID.php?p_name="+n+"&p_password="+p;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {

            if(response.trim().equals("success")){


                status.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                status.setText("Blocked!");
                g = 1;



            }
            else {

                status.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                status.setText("Allowed ");
                g = 0;

            }
        }, error -> Toast.makeText(getApplicationContext(),"error: "+error.toString(),Toast.LENGTH_LONG).show()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
              //  params.put("UserName",logname.getText().toString().trim());
               // params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void register(){
        String url = Url+"/registration/addplayer.php?date=" + currentDate + "&p_id=" + ID +
                "&payment=" + cost+"&c_id="+c_id;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, url,

                response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(),

                error -> { Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
        );
        queue.add(request);
    }
}