package com.example.jwgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class adminAddPlayer extends AppCompatActivity {
    EditText signname, signheight, signweight, signage, signpw;
    TextView signlog;

    Spinner typespinner, genderspinner;
    Button signregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_player);



        signname= findViewById(R.id.signn);
        signheight= findViewById(R.id.signh);
        signweight= findViewById(R.id.signw);
        signage= findViewById(R.id.signa);
        signpw= findViewById(R.id.signp);
        signlog= findViewById(R.id.signlog);
        typespinner= findViewById(R.id.typespinner);
        genderspinner= findViewById(R.id.genderspinner);
        signregister= findViewById(R.id.signad);

        signregister.setOnClickListener(v -> {
            String name = signname.getText().toString();
            String height = signheight.getText().toString();
            String weight = signweight.getText().toString();
            String age = signage.getText().toString();
            String pw = signpw.getText().toString();
            String type = typespinner.getSelectedItem().toString();
            String gender = genderspinner.getSelectedItem().toString();

            if (name.equals("") || pw.equals("") || height.equals("") || weight.equals("") || age.equals("")) {

                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                String url = "http://192.168.0.109/ceng495/addplayer.php?p_name=" + name + "&typeOfWorkout=" + type +
                        "&age=" + age + "&height=" + height + "&weight=" + weight + "&gender=" + gender + "&p_password=" + pw;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest request = new StringRequest(Request.Method.GET, url, response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(), error -> {
                    Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                    //pb.setVisibility(View.INVISIBLE);
                }
                );
                queue.add(request);
            }
        });

    }
}