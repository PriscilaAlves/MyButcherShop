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
        List<Product> testList = Arrays.asList(new Product(0, "Chicken", "chicken.png"),
                                               new Product(1, "Duck", "duck.png"),
                                               new Product(2, "Pork Ribs", "porkRibs.png"),
                                               new Product(3, "Piglet", "piglet.png"),
                                               new Product(4, "Rabbit", "rabbit.png"),
                                               new Product(5, "Steak", "steak.png"),
                                               new Product(6, "Sausage", "sausage.png"));
        final List<Product> productsList = ps.getProductsList();
        // test size
        assertThat(productsList.size(), is(7));
        // test if objects content are equal
        assertThat(productsList, is(testList));
    }

    @Test
    public void getProductById() throws Exception {
        ProductDetail productById = ps.getProductById(1);
        assertEquals("Duck",productById.getTitle());
        assertEquals("duck.png",productById.getPictureURL());
        assertEquals("Espanha",productById.getCountry());
        assertEquals(new Float(10.54),productById.getPrice());
        assertEquals("We guarantee this is not Donald Duck.",productById.getDescription());
    }

}