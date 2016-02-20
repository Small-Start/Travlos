package com.example.myhp.travlo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by my hp on 2/20/2016.
 */
public class Showroute extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{
ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showroute);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_showroute);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ListView lv=(ListView)findViewById(R.id.listView_showroute);
        list = new ArrayList<String>();
        list.add("By Car");
        list.add("By Public Transport");
        ArrayAdapter items=new CustomListAdapter(Showroute.this , R.layout.custom_list ,list);
        lv.setAdapter(items);
        lv.setOnItemClickListener(this);
        findViewById(R.id.breached).setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class ch=null;
        try {
            ch=Class.forName("com.example.myhp.travlo.Routemap1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent in=new Intent(Showroute.this,ch);
        startActivity(in);

    }

    @Override
    public void onClick(View v) {
Class ch=null;
        try {
            ch=Class.forName("com.example.myhp.travlo.Travelcity");
            Intent in=new Intent(Showroute.this,ch);
            startActivity(in);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
