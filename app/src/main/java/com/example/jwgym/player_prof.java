package com.example.jwgym;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/*import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class player_prof extends AppCompatActivity {
    TextView pname,id,height,weight,age,gender,typeofworkout,password;
    String pnameT,idT,heightT,weightT,ageT,genderT,typeOfT,passswordT;


    JSONArray data;

    int i;
    Button btnshow;
    private String strJson, Url="http://192.168.0.107/ceng495/playerInfo.php";
    private RequestQueue rq;
    /*private OkHttpClient client;
    private Response response;
    private RequestBody requestBody;
    private Request request;*/
    //private ProgressDialog progressDialog;
    // private static final String Base_URL = "http://192.168.0.7/ceng495/playerInfo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_prof);
        // progressDialog = new ProgressDialog(this);
        // progressDialog.setTitle("Pleasee wait");
        // progressDialog.setCanceledOnTouchOutside(false);

        pname = (TextView) findViewById(R.id.username);
        height = (TextView) findViewById(R.id.height);
        weight =(TextView) findViewById(R.id.weight);
        age = (TextView)findViewById(R.id.age);
        typeofworkout = (TextView)findViewById(R.id.workout);
        password =(TextView) findViewById(R.id.password);
        btnshow =(Button) findViewById(R.id.button);



        rq = Volley.newRequestQueue(this);




        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPname();
                getppassword();
                getheight();
                getwight();
                getage();
                gettypeof();



            }
        });



        /*progressDialog.show();
        client = new OkHttpClient();*/
        //new GetUserDataRequest().execute();

        //Intent j1 = getIntent();
        //p_name = j1.getStringExtra("seat2");
        //pname.setText("p_name");







       /* buttonfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();

            }
        });*/









    }
    public void getPname(){




        String url = "http://192.168.0.107/ceng495/playerdetail/p_name.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                pname.setText(value);




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
    public void getppassword(){




        String url = "http://192.168.0.107/ceng495/playerdetail/p_password.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
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
                //params.put("UserName",logname.getText().toString().trim());
                //params.put("Password",logpass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }
    public void getheight(){




        String url = "http://192.168.0.107/ceng495/playerdetail/height.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                height.setText(value);




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
    public void getwight(){




        String url = "http://192.168.0.107/ceng495/playerdetail/weight.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                weight.setText(value);




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
    public void getage(){




        String url = "http://192.168.0.107/ceng495/playerdetail/age.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                age.setText(value);




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
    public void gettypeof(){




        String url = "http://192.168.0.107/ceng495/playerdetail/typeOfWorkout.php?id=2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                String value = response.trim();
                //Toast.makeText(getApplicationContext(),"Login Successfully!",Toast.LENGTH_LONG).show();
                typeofworkout.setText(value);




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


    /*public void getdatafromdb(){
        String url = "http://192.168.0.109/ceng495/getPlayerInfo.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new
                        Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                data = response;

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
// TODO: Handle error
                        Toast.makeText(getApplicationContext(),"Error:"+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonArrayRequest);
    }*/
    /*private void playerInfo(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Base_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            JSONObject object = array.getJSONObject(0);

                            String p_name = object.getString("p_name");
                            int age = object.getInt("age");

                            Player player = new Player(p_name,age);

                        }catch (Exception e){

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(player_prof.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }*/
    /*private void getData() {


        String id;




        String url = Player.DATA_URL ;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSONS(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(player_prof.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }*/

    /*private void showJSONS(String response) {
        String name = "";


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Player.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Player.KEY_NAME);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        pname.setText("" + name);
    }*/
    /*public class GetUserDataRequest extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            request = new Request.Builder().url(apiUrl).build();
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {
                strJson = response.body().string();
                updateUserData(strJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*private void updateUserData(String strJson) {
        try {
            JSONArray parent = new JSONArray(strJson);
            JSONObject child = parent.getJSONObject(0);
            String pnameT = child.getString("p_name");
            String ageT = child.getString("age");
            String heightT = child.getString("height");
            String weightT = child.getString("weight");
            String typeofworkoutT = child.getString("typeOfWorkout");
            String passwordT = child.getString("p_password");

            pname.setText(pnameT);
            age.setText(ageT);
            height.setText(heightT);
            weight.setText(weightT);
            typeofworkout.setText(typeofworkoutT);
            password.setText(passwordT);
            progressDialog.hide();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
   /* public void test(){
        JSONObject obj = data.optJSONObject(0);
        try {

            String url = "http://192.168.0.107/ceng495/playerInfo.php";
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            StringRequest request = new StringRequest(Request.Method.GET, url, response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(), error -> {
                Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                //pb.setVisibility(View.INVISIBLE);
            });

            id.setText(obj.getString("p_id"));
            height.setText(obj.getString("height"));
            weight.setText(obj.getString("weight"));
            age.setText(obj.getString("age"));
            gender.setText(obj.getString("gender"));
            password.setText(obj.getString("password"));
            typeofworkout.setText(obj.getString("typeOfWorkout"));



            queue.add(request);
        } catch (JSONException e) {
        }
    }*/
    /*public void sendjson(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            pnameT = response.getString("p_name");
                            ageT = response.getString("age");
                            weightT = response.getString("weight");
                            heightT = response.getString("height");
                            passswordT = response.getString("p_password");
                            typeOfT = response.getString("typeOfWorkout");

                            pname.setText(pnameT);
                            age.setText(ageT);
                            weight.setText(weightT);
                            height.setText(heightT);
                            password.setText(passswordT);
                            typeofworkout.setText(typeOfT);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }*/

}