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

public class CustomAdapter3 extends BaseAdapter {

    Context con;
    JSONArray data;
    LayoutInflater inflater;
    // constructor
    public CustomAdapter3(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public class Holder {
        TextView sessPID,sesstime,sessdate;
        ImageView img, block;
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
        rowView = inflater.inflate(R.layout.row3,null);

        holder.sessPID = rowView.findViewById(R.id.sessPID);
        holder.sessdate = rowView.findViewById(R.id.sessdate);
        holder.sesstime = rowView.findViewById(R.id.sesstime);


        JSONObject obj = data.optJSONObject(i);
        try {
            holder.sessPID.setText(obj.getString("p_id"));
            holder.sesstime.setText(obj.getString("session_time"));
            holder.sessdate.setText(obj.getString("session_date"));


        }
        catch (JSONException e){
        }
        return rowView;
    }
}

