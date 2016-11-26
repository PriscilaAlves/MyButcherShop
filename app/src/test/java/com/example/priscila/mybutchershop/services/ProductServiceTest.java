package com.example.priscila.mybutchershop.services;

import com.example.priscila.mybutchershop.model.Product;
import com.example.priscila.mybutchershop.model.ProductDetail;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anapr on 26/11/2016.
 */
public class ProductServiceTest {
    ProductService ps = new ProductService();

    @Test
    public void getProductsList() throws Exception {
        List<Product> testList = Arrays.asList(new Product(4, "Apple", "apple.jpg"), new Product(7, "Orange", "orange.png"), new Product(10, "Banana", "banana.jpg"));
        final List<Product> productsList = ps.getProductsList();
        // test size
        assertThat(productsList.size(), is(3));
        // test if objects content are equal
        assertThat(productsList, is(testList));
    }

    @Test
    public void getProductById() throws Exception {
        ProductDetail productById = ps.getProductById(4);
        assertEquals("Apple",productById.getTitle());
        assertEquals("apple.jpg",productById.getPictureURL());
        assertEquals("Portugal",productById.getCountry());
        assertEquals(new Float(1.5),productById.getPrice());
        assertEquals("I am a very good apple.",productById.getDescription());
    }

}