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

public class CustomAdapter5 extends BaseAdapter {

    Context con;
    JSONArray data;
    LayoutInflater inflater;
    public CustomAdapter5(Context c, JSONArray data){
        this.con = c;
        this.data = data;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class Holder {
        TextView pname,age;
        ImageView img;

    }

    @Override
    public int getCount() {
        return data.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final CustomAdapter5.Holder holder = new CustomAdapter5.Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.row5,null);
        holder.pname = rowView.findViewById(R.id.pname);
        // holder.coachi = rowView.findViewById(R.id.coachi);
        //holder.coachsp = rowView.findViewById(R.id.cspecial3);
        holder.age = rowView.findViewById(R.id.age);
        holder.img = rowView.findViewById(R.id.btnchoose1);

        JSONObject obj = data.optJSONObject(i);
        try {
            holder.pname.setText(obj.getString("p_name"));
            String pname = obj.getString("p_name");
            // holder.coachi.setText(obj.getString("c_id"));
            holder.age.setText(obj.getString("age"));
            //holder.coachsp.setText(obj.getString("specilization"));

          //  holder.img.setTag(obj.getInt("c_id"));
          //  String c_id = obj.getString("c_id");
/////////////////////////////
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(con.getApplicationContext(),player_reg.class);
                 //   i.putExtra("cname",name);
                 //   i.putExtra("salary",salary);
                 //   i.putExtra("c_id", c_id);
                  //  Test.setCouchState(salary);


                  //  con.startActivity(i);


                }
            });}
        catch (JSONException e){
        }
        return rowView;
    }
}
