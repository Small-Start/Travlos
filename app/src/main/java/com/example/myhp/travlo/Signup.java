package com.example.myhp.travlo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by my hp on 2/20/2016.
 */
public class Signup extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_signup);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        findViewById(R.id.bsignup).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bsignup:
                Class ch=null;
                try {
                    ch=Class.forName("com.example.myhp.travlo.Mainpage");
                    Intent in=new Intent(Signup.this,ch);
                    startActivity(in);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
