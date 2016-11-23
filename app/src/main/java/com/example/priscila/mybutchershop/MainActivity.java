package com.example.priscila.mybutchershop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String loadJSONFromAsset() {
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

    ArrayList<String> butcherList = null;
    ArrayAdapter<String> myAdapter = null;
    ListView myButcherListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json_return = loadJSONFromAsset();

        try {
            JSONObject productsObj = new JSONObject(json_return);
            JSONArray productsArray = productsObj.getJSONArray("Products");
            JSONObject productsObj0 = (JSONObject)productsArray.get(0);
            System.out.println(productsObj0);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        butcherList = new ArrayList<>();
        butcherList.addAll(Arrays.asList("Apple", "Banana", "Orange", "Lemon", "Strawberry"));

        myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, butcherList);
        myButcherListView = (ListView) findViewById(R.id.listView);
        myButcherListView.setAdapter(myAdapter);

    }
}
