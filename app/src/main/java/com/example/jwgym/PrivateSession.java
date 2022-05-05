package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PrivateSession extends AppCompatActivity {
    ListView list;
    Spinner spinnerSpec,spinnercoach;
    ArrayList<String> specList = new ArrayList<>();
    ArrayList<String> coachList = new ArrayList<>();
    ArrayAdapter<String> specAdapter,coachAdapter;
    RequestQueue requestQueue;

    ListView list1;
    JSONArray data;
    CustomAdapter3 cust_adapater3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_session);
        list = findViewById(R.id.listview);
        spinnerSpec = findViewById(R.id.spinnerSpec);
        getdatafromdb();



    }
    protected void onResume() {
        getdatafromdb();
        super.onResume();
    }

    public void getdatafromdb(){
        String url = Test.getURL()+"/privateSession/spinnerCoach.php?specilization="+spinnerSpec.getSelectedItem().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, response -> {
                    data = response;
                    cust_adapater3 = new CustomAdapter3(getApplicationContext(),data);
                    list.setAdapter(cust_adapater3);
                }, error -> {
                    // TODO: Handle error
                    Toast.makeText(getApplicationContext(),"Error:"+error.toString(),Toast.LENGTH_SHORT).show();
                });
        queue.add(jsonArrayRequest);
    }

}
