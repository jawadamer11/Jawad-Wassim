package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter1 extends BaseAdapter {
    TextView playern,playert,playeri,playera, playerw, playerh, playerg;
    ImageButton ImageButton;
    Context con;
    JSONArray data;
    LayoutInflater inflater;
    // constructor
    public CustomAdapter1(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public class Holder {

    }
    @Override
    public int getCount() {
        return data.length();
    }
    @Override
    public Object getItem(int i) {
        // i is the clicked position and is filled by Android
        return null;

    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder = new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.row1,null);

        playeri = rowView.findViewById(R.id.playeri);
        playern = rowView.findViewById(R.id.playern);
        playert = rowView.findViewById(R.id.playert);
        playera = rowView.findViewById(R.id.playera);
        playerh = rowView.findViewById(R.id.playerh);
        playerw = rowView.findViewById(R.id.playerw);
        playerg = rowView.findViewById(R.id.playerg);

        ImageButton = rowView.findViewById(R.id.imageButton);

        JSONObject obj = data.optJSONObject(i);
        try {
            playeri.setText(obj.getString("p_id"));
            playern.setText(obj.getString("p_name"));
            playert.setText(obj.getString("typeOfWorkout"));
            playera.setText(obj.getString("age"));
            playerh.setText(obj.getString("height"));
            playerw.setText(obj.getString("weight"));
            playerg.setText(obj.getString("gender"));
            ImageButton.setTag(obj.getString("p_id"));

            ImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = URL+"/deletePlayer.php?p_id="+ImageButton.getTag();
                    RequestQueue queue = Volley.newRequestQueue(con);
                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equals("success")){

                                ((managePlayer)con).onResume();
                            }
                            else {
                                Toast.makeText(con, "Delete failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void
                        onErrorResponse(VolleyError error) {
                            Toast.makeText(con,"Error:"+error.toString(), Toast.LENGTH_SHORT).show(); }
                    });queue.add(request);
                }
            });}
        catch (JSONException e){
        }
        return rowView;
    }
}

