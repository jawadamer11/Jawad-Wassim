package com.example.jwgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

public class PrivateSession extends AppCompatActivity  {
    ListView list;
    Spinner spinnerSpec,spinnercoach;
    ArrayList<String> specList = new ArrayList<>();
    ArrayList<String> coachList = new ArrayList<>();
    ArrayAdapter<String> specAdapter,coachAdapter;
    RequestQueue requestQueue;

    ListView list1;
    JSONArray data;
    CustomAdapter4 cust_adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_session);
        list = findViewById(R.id.playerListd);
        spinnerSpec = findViewById(R.id.spinnerSpec);
        getdatafromdb();

       spinnerSpec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               getdatafromdb();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }

    @Override
    protected void onResume() {
        getdatafromdb();
        super.onResume();
    }

    public void getdatafromdb(){
        String url =Test.getURL()+ "/privateSession/spinnerCoach.php?specilization="+spinnerSpec.getSelectedItem().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new
                        Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                data = response;
                                cust_adapater = new
                                        CustomAdapter4(PrivateSession.this,data);
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
