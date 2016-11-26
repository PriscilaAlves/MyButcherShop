package com.example.priscila.mybutchershop;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.priscila.mybutchershop.model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by anapr on 23/11/2016.
 */

public class CustomListAdapter extends ArrayAdapter<Product>{
    private final Activity context;
    private final List<Product> products;


    public CustomListAdapter(Activity context, List<Product> products) {
        super(context, R.layout.my_list, products);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.products = products;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.productTitle);
        ImageView pic = (ImageView) rowView.findViewById(R.id.productImageView);

        // get input stream
        InputStream ims = null;
        try {
            ims = this.context.getAssets().open(products.get(position).getPictureURL().toString());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            pic.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        txtTitle.setText(products.get(position).getTitle());
        rowView.setId(products.get(position).getId());
        return rowView;

    };
}
