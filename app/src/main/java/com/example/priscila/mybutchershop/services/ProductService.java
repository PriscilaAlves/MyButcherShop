package com.example.priscila.mybutchershop.services;

import com.example.priscila.mybutchershop.model.Product;
import com.example.priscila.mybutchershop.model.ProductDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anapr on 25/11/2016.
 */

public class ProductService {

    private static final Type PRODUCT_TYPE = new TypeToken<List<ProductDetail>>() {}.getType();
    Map<Integer,ProductDetail> productsData = null;
    Gson gson = new Gson();

    public ProductService() {
        productsData = getData();
    }

    private Map<Integer,ProductDetail> getData() {
        //variable with products data that could be a response from a http request
        String data = "[{\"id\":0,\"title\":\"Chicken\",\"pictureURL\":\"chicken.png\",\"description\":\"This is the best quality chicken. Coming directly from the fields of Leiria, you can expect a very tender meat.\",\"price\":8.48,\"country\":\"Portugal\"},{\"id\":1,\"title\":\"Duck\",\"pictureURL\":\"duck.png\",\"description\":\"We guarantee this is not Donald Duck.\",\"price\":10.54,\"country\":\"Espanha\"},{\"id\":2,\"title\":\"Pork Ribs\",\"pictureURL\":\"porkRibs.png\",\"description\":\"You just need to prepare your barbecue sauce. This will be the best ribs you will eat in your life.\",\"price\":3.57,\"country\":\"United States\"},{\"id\":3,\"title\":\"Piglet\",\"pictureURL\":\"piglet.png\",\"description\":\"Christmas is coming and this little pig will be the best one to share with your family.\",\"price\":20.23,\"country\":\"France\"},{\"id\":4,\"title\":\"Rabbit\",\"pictureURL\":\"rabbit.png\",\"description\":\"Our rabbit comes from the best farms in the country. It has a fabulous taste and will be the best option for your dinner.\",\"price\":17.1,\"country\":\"Germany\"},{\"id\":5,\"title\":\"Steak\",\"pictureURL\":\"steak.png\",\"description\":\"The most delicious steak you will ever eat comes from the fields of Sao Miguel island, in Azores.\",\"price\":28.35,\"country\":\"Portugal\"},{\"id\":6,\"title\":\"Sausage\",\"pictureURL\":\"sausage.png\",\"description\":\"The most delicious sausage for your barbecue with friends. The quality of the meat is guaranteed.\",\"price\":2.47,\"country\":\"Holland\"}]";
        // parse data to Product class
        List<ProductDetail> products = gson.fromJson(data, PRODUCT_TYPE);
        Map<Integer, ProductDetail> productMap = new HashMap<>();
        for (ProductDetail p : products) {
            productMap.put(p.getId(), p);
        }
        return productMap;
    }

    public List<Product> getProductsList() {
        List<Product> butcherList = new ArrayList<Product>();
        for (ProductDetail p : productsData.values()){
            butcherList.add(new Product(p.getId(), p.getTitle(), p.getPictureURL()));
        }
        return butcherList;
    }

    public ProductDetail getProductById(int id) {
        ProductDetail productDetail = productsData.get(id);
        return productDetail;
    }
}


