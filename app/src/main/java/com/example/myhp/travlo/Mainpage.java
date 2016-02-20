package com.example.myhp.travlo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by my hp on 2/20/2016.
 */
public class Mainpage extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_mainpage);
        setSupportActionBar(toolbar);
        findViewById(R.id.bsearch).setOnClickListener(this);
        findViewById(R.id.b_alreadythere).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bsearch:
                Class ch=null;
                try {
                    ch=Class.forName("com.example.myhp.travlo.Showroute");
                    Intent in=new Intent(Mainpage.this,ch);
                    startActivity(in);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.b_alreadythere:

                Class ch1=null;
                try {
                    ch1=Class.forName("com.example.myhp.travlo.Travelcity");
                    Intent in1=new Intent(Mainpage.this,ch1);
                    startActivity(in1);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}
