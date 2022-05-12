package com.example.jwgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
    Button adcontinue;
    EditText adpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);



        adcontinue=findViewById(R.id.adcontinue);
        adpw=findViewById(R.id.adpw);
        adcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample_anim);
                adcontinue.startAnimation(animation);
                String p = adpw.getText().toString();
                if(p.equals("123admin")){
                    Intent i =new Intent(getApplicationContext(), administration.class);
                    startActivity(i);
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), "INCORRECT PASSWORD!", Toast.LENGTH_LONG).show();
                    adpw.setText("");
                }
            }
        });
    }
}