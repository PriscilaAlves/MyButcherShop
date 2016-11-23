package com.example.priscila.mybutchershop;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends Activity {

    /*public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    ArrayAdapter<String> myAdapter = null;
    ListView myButcherListView = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list;
        /*String json_return = loadJSONFromAsset();

        try {
            JSONObject productsObj = new JSONObject(json_return);
            JSONArray productsArray = productsObj.getJSONArray("Products");
            JSONObject productsObj0 = (JSONObject)productsArray.get(0);
            System.out.println(productsObj0);

        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        String[] butcherList = {"Apple", "Banana", "Orange"};
        Integer[] imgid={
                R.drawable.apple,
                R.drawable.banana,
                R.drawable.orange

        };

        /*myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, butcherList);
        myButcherListView = (ListView) findViewById(R.id.listView);
        myButcherListView.setAdapter(myAdapter);*/
        CustomListAdapter adapter=new CustomListAdapter(this, butcherList, imgid);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });*/

    }
}
