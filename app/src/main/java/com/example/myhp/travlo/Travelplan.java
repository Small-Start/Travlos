package com.example.myhp.travlo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by my hp on 2/20/2016.
 */
public class Travelplan extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
double lat[]={28.524410,28.608547,27.171466,28.650594},lon[]={77.185466,77.239921,78.018553,77.230328};
    int way[];
    ListView lv;
    String att[]={"Qutub Minar","Delhi Zoo","Red Fort","Chandni Chowk"};
    ArrayList<String> list;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travelplan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_travelplan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        lv=(ListView)findViewById(R.id.listView_plan);
        list = new ArrayList<String>();
        list.add(att[0]);
        pd=new ProgressDialog(Travelplan.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading");
        pd.show();
new Callingtheap1().execute("https://maps.googleapis.com/maps/api/directions/json?origin=28.524410,77.185466&destination=28.608547,77.239921&waypoints=optimize:true|27.171466,78.018553|28.650594,77.230328&key=AIzaSyC7ANFi_qI9oG8SyNRHJp0GP_wdTCN3ZVY");
       // lv.setOnItemClickListener(this);
        findViewById(R.id.bhurray).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Class ch=null;
        try {
            ch=Class.forName("com.example.myhp.travlo.Timeplan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Bundle b=new Bundle();
        b.putStringArray("att", att);
        b.putDoubleArray("lat",lat);
        b.putDoubleArray("lon", lon);
        b.putIntArray("way",way);
        Intent in=new Intent(Travelplan.this,ch);
        in.putExtras(b);
        startActivity(in);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    public class Callingtheap1 extends AsyncTask<String, String,String> {




        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection=null;
            BufferedReader reader=null;
            double temp;
            StringBuffer data;
            try {
                URL url=new URL(params[0]);
                connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream in=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(in));
                StringBuffer report=new StringBuffer();
                String line="";
                while((line=reader.readLine())!=null)
                    report.append(line);

                JSONObject ob=new JSONObject(report.toString());

                JSONArray obj=ob.getJSONArray("routes");
                JSONObject fr=obj.getJSONObject(0);
                JSONArray way1=fr.getJSONArray("waypoint_order");
                way=new int[way1.length()];
                for(int i=0;i<way1.length();i++)
                {
                    way[i]=way1.getInt(i);
                }
                return "hi";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally{
                if(connection!=null)
                    connection.disconnect();
                if(reader!=null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
if(way.length!=0) {
    for (int i = 0; i < way.length; i++) {
        list.add(att[way[i]+1]);
    }
    list.add(att[att.length - 1]);
    ArrayAdapter items = new CustomListAdapter(Travelplan.this, R.layout.custom_list, list);
    lv.setAdapter(items);
    pd.hide();
}
        }

    }

}
