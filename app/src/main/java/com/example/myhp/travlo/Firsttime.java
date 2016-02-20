package com.example.myhp.travlo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Firsttime extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttime);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_firsttime);
        setSupportActionBar(toolbar);
        findViewById(R.id.loginfirsttime).setOnClickListener(this);
        findViewById(R.id.signupfirsttime).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.loginfirsttime:
                Class login=null;
                try {
                    login=Class.forName("com.example.myhp.travlo.Login");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent in=new Intent(Firsttime.this,login);
                startActivity(in);
                break;
            case R.id.signupfirsttime:
                Class signup=null;
                try {
                    signup=Class.forName("com.example.myhp.travlo.Signup");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent in1=new Intent(Firsttime.this,signup);
                startActivity(in1);
                break;

        }

    }
}