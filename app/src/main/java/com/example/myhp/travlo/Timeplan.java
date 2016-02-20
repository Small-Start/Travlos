package com.example.myhp.travlo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.sql.Time;
import java.util.ArrayList;


/**
 * Created by my hp on 2/20/2016.
 */
public class Timeplan extends AppCompatActivity {
    double lat[]={28.524410,28.608547,27.171466,28.650594},lon[]={77.185466,77.239921,78.018553,77.230328};
    int way[];
    ListView lv;

    String att[]={"Qutub Minar","Delhi Zoo","Red Fort","Chandni Chowk"};
    ArrayList<String> list;
    String durat[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeplan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_timeplan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        lv=(ListView)findViewById(R.id.listView_timeplan);
        list=new ArrayList<>();
way=getIntent().getExtras().getIntArray("way");
        new Callingtheap2().execute("https://maps.googleapis.com/maps/api/directions/json?origin=28.524410,77.185466&destination=28.608547,77.239921&waypoints=optimize:true|27.171466,78.018553|28.650594,77.230328&key=AIzaSyC7ANFi_qI9oG8SyNRHJp0GP_wdTCN3ZVY");

    }



    public class Callingtheap2 extends AsyncTask<String, String,String> {




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
                JSONArray legs=fr.getJSONArray("legs");
                durat=new String[legs.length()];
                for(int i=0;i<legs.length();i++)
                {
                    JSONObject legsob=legs.getJSONObject(i);
                    JSONObject dura=legsob.getJSONObject("duration");
durat[i]=dura.getString("text");
                }
               /* JSONArray way1=fr.getJSONArray("waypoint_order");
                way=new int[way1.length()];
                for(int i=0;i<way1.length();i++)
                {
                    way[i]=way1.getInt(i);
                }*/
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
            list.add(att[0] + "\n" + "Start");
            int i=0;
            for(i=0;i<way.length;i++)
            {

                list.add(att[way[i]+1]+"\n"+"Travel time:"+durat[i]);
            }
            list.add(att[i+1]+"\n"+"Travel time:"+durat[i]);

            ArrayAdapter items=new CustomListAdapter(Timeplan.this , R.layout.custom_list ,list);
            lv.setAdapter(items);

        }

    }
}
