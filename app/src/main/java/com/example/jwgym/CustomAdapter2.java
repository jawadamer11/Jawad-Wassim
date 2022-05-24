package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.annotation.SuppressLint;
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

public class CustomAdapter2 extends BaseAdapter {

    Context con;
    JSONArray data;
    LayoutInflater inflater;
    // constructor
    public CustomAdapter2(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public static class Holder {
        TextView coachn,coachsp,coachi,coachsa;
        ImageView img, imageview4;
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
        rowView = inflater.inflate(R.layout.row2,null);
        holder.coachn = rowView.findViewById(R.id.tn);
        holder.coachi = rowView.findViewById(R.id.coachi);
        holder.coachsp = rowView.findViewById(R.id.cspecial3);
        holder.coachsa = rowView.findViewById(R.id.ts);
        holder.img = rowView.findViewById(R.id.imgt);
        holder.imageview4=rowView.findViewById(R.id.imageView4);

        JSONObject obj = data.optJSONObject(i);
        try {
            holder.coachn.setText(obj.getString("c_name"));
            holder.coachi.setText(obj.getString("c_id"));
            holder.coachsa.setText(obj.getString("salary"));
            holder.coachsp.setText(obj.getString("specilization"));

            holder.img.setTag(obj.getInt("c_id"));

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = URL+"/deleteCoach.php?c_id="+holder.img.getTag();
                    RequestQueue queue = Volley.newRequestQueue(con);
                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equals("success")){


                                ((manageCoach)con).onResume();
                            }
                            else {
                                Toast.makeText(con, "Coach Deleted", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void
                        onErrorResponse(VolleyError error) {
                            Toast.makeText(con,"Error:"+error.toString(), Toast.LENGTH_SHORT).show(); }
                    }
                    );queue.add(request);
                }
            });}
        catch (JSONException e){
        }
        return rowView;
    }
}
