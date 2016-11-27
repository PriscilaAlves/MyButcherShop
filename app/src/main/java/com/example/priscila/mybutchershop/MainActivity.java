package com.example.priscila.mybutchershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.priscila.mybutchershop.model.ProductDetail;
import com.example.priscila.mybutchershop.services.ProductService;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    ListView myButcherListView = null;
    ProductService ps = new ProductService();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter to convert data in a list
        CustomListAdapter myAdapter = new CustomListAdapter(this, ps.getProductsList());
        //get ListView to display data
        myButcherListView = (ListView) findViewById(R.id.listView);
        // set data to listview
        myButcherListView.setAdapter(myAdapter);
        //handle click event on list items
        myButcherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // send product detail data of selected item to ProductDetailActivity
                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                ProductDetail productSelected = ps.getProductById(view.getId());
                intent.putExtra("PRODUCT_DETAIL", productSelected);
                startActivity(intent);
            }
        });
    }
}

