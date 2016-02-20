package com.example.myhp.travlo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        findViewById(R.id.b_login).setOnClickListener(this);
        findViewById(R.id.bforgotpassword).setOnClickListener(this);
        findViewById(R.id.bregisterednot).setOnClickListener(this);



}

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.b_login:
                String email=((EditText)findViewById(R.id.edit_login_email)).getText().toString();
                String pass=((EditText)findViewById(R.id.edit_login_password)).getText().toString();
Class ch=null;
                try {
                    ch=Class.forName("com.example.myhp.travlo.Mainpage");
                    Intent in=new Intent(Login.this,ch);
                    startActivity(in);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.bforgotpassword:

                break;
            case R.id.bregisterednot:

                break;
        }

    }
}
