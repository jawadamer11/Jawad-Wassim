package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class managePlayer extends AppCompatActivity {
    ListView list;
    JSONArray data;
    CustomAdapter1 cust_adapater;
    FloatingActionButton addpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_player);



        list = findViewById(R.id.list);
        addpl = findViewById(R.id.addpl);

        addpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),adminAddPlayer.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        getdatafromdb();
        super.onResume();
    }


    public void getdatafromdb(){
        String url = URL+"/getallplayers.php";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
            public void onResponse(JSONArray response) {
              //  data = response;
                cust_adapater = new CustomAdapter1(getApplicationContext(),response);
                list.setAdapter(cust_adapater);

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