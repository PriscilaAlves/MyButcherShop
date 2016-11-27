package com.example.priscila.mybutchershop.model;

import java.io.Serializable;

/**
 * Created by anapr on 22/11/2016.
 *
 * This class represents a model of product's data.
 */

public class Product implements Serializable {
    private int id;
    private String title;
    private String pictureURL;

    public Product(int id, String title, String pictureURL) {
        this.id = id;
        this.title = title;
        this.pictureURL = pictureURL;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (getTitle() != null ? !getTitle().equals(product.getTitle()) : product.getTitle() != null)
            return false;
        return getPictureURL() != null ? getPictureURL().equals(product.getPictureURL()) : product.getPictureURL() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getPictureURL() != null ? getPictureURL().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }
}
