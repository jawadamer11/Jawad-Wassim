package com.example.jwgym;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter4 extends BaseAdapter {

    Context con;
    JSONArray data;
    LayoutInflater inflater;
    String salary="true";

    // constructor
    public CustomAdapter4(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public static class Holder {
        TextView coachn,coachsa;
        ImageView img;

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
        final CustomAdapter4.Holder holder = new CustomAdapter4.Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.rowww,null);
        holder.coachn = rowView.findViewById(R.id.coachname);
       // holder.coachi = rowView.findViewById(R.id.coachi);
        //holder.coachsp = rowView.findViewById(R.id.cspecial3);
        holder.coachsa = rowView.findViewById(R.id.coachsalary);
        holder.img = rowView.findViewById(R.id.btnchoose);



        JSONObject obj = data.optJSONObject(i);
        try {
            holder.coachn.setText(obj.getString("c_name"));
            String name = obj.getString("c_name");
           // holder.coachi.setText(obj.getString("c_id"));
            holder.coachsa.setText(obj.getString("salary"));
            //holder.coachsp.setText(obj.getString("specilization"));

            holder.img.setTag(obj.getInt("c_id"));
            String c_id = obj.getString("c_id");
/////////////////////////////
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(con.getApplicationContext(),player_reg.class);
                    i.putExtra("cname",name);
                    i.putExtra("salary",salary);
                    i.putExtra("c_id", c_id);
                    Test.setCouchState(salary);


                    con.startActivity(i);


                }
            });}
        catch (JSONException e){
        }
        return rowView;
    }
}
