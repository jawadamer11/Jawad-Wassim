package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class manageCoach extends AppCompatActivity {
    ListView list1;
    JSONArray data;
    CustomAdapter2 cust_adapater1;


    FloatingActionButton addco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_coach);


        list1 = findViewById(R.id.list1);
        addco=findViewById(R.id.addco);

        addco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
                addco.startAnimation(animation);
                Intent i = new Intent(getApplicationContext(),adminAddCoach.class);
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
        String url = URL+"/getallcoaches.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, response -> {
                    data = response;
                    cust_adapater1 = new CustomAdapter2(getApplicationContext(),data);
                    list1.setAdapter(cust_adapater1);
                }, error -> {
                    // TODO: Handle error
                    Toast.makeText(getApplicationContext(),"Error:"+error.toString(),Toast.LENGTH_SHORT).show();
                });
        queue.add(jsonArrayRequest);
    }
}