package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class coach_sched extends AppCompatActivity {
    ListView listview;
    JSONArray data;
    CustomAdapter3 cust_adapater;
    String ID;
    TextView textView26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_sched);


        listview = findViewById(R.id.listview);
        textView26 = findViewById(R.id.textView26);

        getID();
        getdatafromdb();
        finish();

    }

    @Override
    protected void onResume() {
        getID();
        getdatafromdb();
        super.onResume();
    }

    public void getID(){
        Intent i1 = getIntent();
        String n = i1.getStringExtra("seat2");
        String p = i1.getStringExtra("userpass");
        String url = URL+"/coachdetail/getID.php?c_name="+n+"&c_password="+p;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                Test.setId(value);

                textView26.setText(Test.getId());
                ID=value;

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

    public void getdatafromdb(){

        String url = URL+"/getPrivateSessions.php?c_id="+textView26.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  data = response;
                cust_adapater = new CustomAdapter3(getApplicationContext(),response);
                listview.setAdapter(cust_adapater);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                Toast.makeText(getApplicationContext(),"Error:"+error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
    }
}