package com.example.priscila.mybutchershop;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.priscila.mybutchershop.model.ProductDetail;

import java.io.IOException;
import java.io.InputStream;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ProductDetail productSelected = (ProductDetail) getIntent().getSerializableExtra("PRODUCT_DETAIL");

        ImageView picture = (ImageView) findViewById(R.id.imageView3);
        TextView title = (TextView) findViewById(R.id.textView3);
        TextView price = (TextView) findViewById(R.id.textView4);
        TextView country = (TextView) findViewById(R.id.textView6);
        TextView description = (TextView) findViewById(R.id.textView5);

        title.setText(productSelected.getTitle());
        price.setText("Price: "+ productSelected.getPrice().toString() + "€/Kg");
        country.setText("Country of origin: "+ productSelected.getCountry().toString());
        description.setText(productSelected.getDescription().toString());

        // get input stream
        InputStream ims = null;
        try {
            ims = getAssets().open(productSelected.getPictureURL().toString());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            picture.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
