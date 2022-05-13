package com.example.jwgym;

import static com.example.jwgym.Test.URL;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class adminAddCoach extends AppCompatActivity {
    EditText chname, chsalary, chpass;
    Spinner spinner;
    Button addch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_coach);





        chname = findViewById(R.id.chname);
        chsalary = findViewById(R.id.chsalary);
        chpass = findViewById(R.id.chpass);
        spinner = findViewById(R.id.spinner);
        addch = findViewById(R.id.addch);

        addch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
                addch.startAnimation(animation);
                String name = chname.getText().toString();
                String salary = chsalary.getText().toString();;
                String pw = chpass.getText().toString();
                String specialization = spinner.getSelectedItem().toString();
//s

                if (name.equals("") || pw.equals("") || salary.equals("")) {

                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    String url = URL+"/addCoach.php?c_name=" + name + "&specilization=" + specialization +
                            "&salary=" + salary + "&c_password=" + pw;

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest request = new StringRequest(Request.Method.GET, url, response -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show(), error -> {
                        Toast.makeText(getApplicationContext(), "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
                        //pb.setVisibility(View.INVISIBLE);
                    }
                    );
                    queue.add(request);
                }
            }
        });
    }
}