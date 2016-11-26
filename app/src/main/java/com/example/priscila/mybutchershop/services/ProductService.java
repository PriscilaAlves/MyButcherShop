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
        String data = "[{\"id\": 4,\"title\": \"Apple\",\"pictureURL\": \"apple.jpg\",\"description\": \"I am a very good apple.\",\"price\": 1.5,\"country\": \"Portugal\"},{\"id\": 7,\"title\": \"Orange\",\"pictureURL\": \"orange.png\",\"description\": \"I am a very good orange.\",\"price\": 4,\"country\": \"Espanha\"},{\"id\": 10,\"title\": \"Banana\",\"pictureURL\": \"banana.jpg\",\"description\": \"I am a very good banana.\",\"price\": 2,\"country\": \"Espanha\"}]";
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


