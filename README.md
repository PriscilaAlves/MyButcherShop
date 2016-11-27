# MyButcherShop

## Install
Copy myButcherShop.apk to your android smartphone, open it and click on install.
> Note: In order to install app from apk files, you should go to Settings -> Security -> Device Administration and enable Unknow Sources option.

## Description

This android app will display a list of products. When the user select a product from the list, it will open a new view with detail information of the product, which includes:

* Title
* Price
* Country of origin
* Picture
* Description

This project was developed using Android Studio 2.2.2 for Android 6.0 (Marshmallow).

Dependencies:
* Gson (https://github.com/google/gson) - used to convert JSON data in a Java Object.
* Espresso - used to write Android UI tests.

The project is composed of 6 classes:
* Activities
  1. MainActivity - Get's data of products and display them as a list on the screen. When the user clicks on a product, it will open ProductDetailActivity.
  2. ProductDetailActivity - Receives product detail data from MainActivity and shows on the screen.
  3. CustomListAdapter - Builds the list of product with an image and title in each row.
* Model
  1. Product - this class represents the model of each product.
  2. ProductDetail - extends Product class including more fields to describe a product.
* Services
  1. ProductService - mock service that gets data and implements methods that returns products list and product detail by ID.
  
## Tests 

#### Unit tests

Unit test was performed on ProductService class and can be find on app/src/test

#### UI tests

The UI test was performed using Espresso, as recomended by Android developer page.
The test can be find in app/src/androidTest



