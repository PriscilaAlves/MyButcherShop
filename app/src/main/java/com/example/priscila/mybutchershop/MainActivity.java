package com.example.priscila.mybutchershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;


import com.example.priscila.mybutchershop.model.Product;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> myAdapter = null;
    ListView myButcherListView = null;
    private static final Type PRODUCT_TYPE = new TypeToken<List<Product>>() {
    }.getType();
    List<Product> productsData = null;
    ArrayList<String> butcherList = new ArrayList<String>();
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {
            JsonReader reader = new JsonReader(new InputStreamReader(getAssets().open("data.json")));
            productsData = gson.fromJson(reader, PRODUCT_TYPE);
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
        myButcherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                String productSelected = gson.toJson(productsData.get(position));
                intent.putExtra("EXTRA_MESSAGE", productSelected);
                startActivity(intent);
                //System.out.println(productsData.get(position).title.toString());
            }
        });



    }
}

