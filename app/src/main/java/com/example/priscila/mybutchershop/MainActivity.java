package com.example.priscila.mybutchershop;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;


import Model.Product;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

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
    }*/


    ArrayAdapter<String> myAdapter = null;
    ListView myButcherListView = null;
    private static final Type PRODUCT_TYPE = new TypeToken<List<Product>>() {
    }.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> butcherList = new ArrayList<String>();

        Gson gson = new Gson();

        try {
            JsonReader reader = new JsonReader(new InputStreamReader(getAssets().open("data.json")));
            List<Product> productsData = gson.fromJson(reader, PRODUCT_TYPE);
            for (Product p : productsData){
                butcherList.add(p.title);
                Log.i("Contact Details", p.id + "-" + p.title );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, butcherList);
        myButcherListView = (ListView) findViewById(R.id.listView);
        myButcherListView.setAdapter(myAdapter);


    }
}

