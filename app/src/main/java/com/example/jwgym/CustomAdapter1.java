package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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

    Context con;
    JSONArray data;
    LayoutInflater inflater;
    // constructor
    public CustomAdapter1(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public class Holder {
        TextView playern,playert,playeri,playera, playerw, playerh, playerg, playerp;
        ImageView img, block, imageView3;
    }
    @Override
    public int getCount() {

        return data.length();
    }
    @Override
    public Object getItem(int i) {
        // i is the clicked position and is filled by Android
        return null;
    //ss
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder = new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.row1,null);

        holder.playeri = rowView.findViewById(R.id.playeri);
        holder.playerp = rowView.findViewById(R.id.playerp);
        holder.playern = rowView.findViewById(R.id.playern);
       // holder.playert = rowView.findViewById(R.id.playert);
        holder.playera = rowView.findViewById(R.id.playera);
       // holder.playerh = rowView.findViewById(R.id.playerh);
       // holder.playerw = rowView.findViewById(R.id.playerw);
       // holder.playerg = rowView.findViewById(R.id.playerg);
        holder.imageView3=rowView.findViewById(R.id.imageView3);

        holder.img = rowView.findViewById(R.id.imgt);
        holder.block= rowView.findViewById(R.id.block);

        JSONObject obj = data.optJSONObject(i);
        try {
            holder.playeri.setText(obj.getString("p_id"));
            holder.playerp.setText(obj.getString("p_password"));
            holder.playern.setText(obj.getString("p_name"));
            //holder.playert.setText(obj.getString("typeOfWorkout"));
            holder.playera.setText(obj.getString("age"));
           // holder.playerh.setText(obj.getString("height"));
           // holder.playerw.setText(obj.getString("weight"));
            //holder.playerg.setText(obj.getString("gender"));

            holder.img.setTag(obj.getInt("p_id"));
            holder.block.setTag(obj.getInt("p_id"));
            int pid = (int) holder.img.getTag();
            String ID1 = pid+"";
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String url = URL+"/deletePlayer.php?p_id="+ID1;
                    RequestQueue queue = Volley.newRequestQueue(con);
                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response=="success"){
                                Toast.makeText(con.getApplicationContext(),
                                        "player with ID:"+pid+" is deleted from the list",Toast.LENGTH_LONG).show();

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
            });

            holder.block.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String url = URL+"/addToBlocked.php?p_id="+ID1+"&p_name="+holder.playern.getText()+
                            "&p_password="+holder.playerp.getText()+"&reason= Payment Issues";
                    RequestQueue queue = Volley.newRequestQueue(con);
                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response=="success"){
                                Toast.makeText(con.getApplicationContext(),
                                        "player with ID:"+pid+" is deleted from the list",Toast.LENGTH_LONG).show();

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
            });
        }
        catch (JSONException e){
        }
        return rowView;
    }
}

