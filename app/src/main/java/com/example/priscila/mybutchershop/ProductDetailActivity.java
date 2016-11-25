package com.example.priscila.mybutchershop;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import com.example.priscila.mybutchershop.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Gson gson = new Gson();
        Product productSelected = gson.fromJson(getIntent().getStringExtra("EXTRA_MESSAGE"), Product.class);

        ImageView picture = (ImageView) findViewById(R.id.imageView3);
        TextView title = (TextView) findViewById(R.id.textView3);
        TextView price = (TextView) findViewById(R.id.textView4);
        TextView country = (TextView) findViewById(R.id.textView6);
        TextView description = (TextView) findViewById(R.id.textView5);

        title.setText(productSelected.title);
        price.setText("Price: "+ productSelected.price.toString() + "€/Kg");
        country.setText("Country of origin: "+ productSelected.country.toString());
        description.setText(productSelected.description.toString());

        // get input stream
        InputStream ims = null;
        try {
            ims = getAssets().open(productSelected.pictureURL.toString());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            picture.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
