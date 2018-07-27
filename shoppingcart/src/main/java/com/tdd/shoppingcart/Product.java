package com.tdd.shoppingcart;

public class Product {

    public final int quantity;
    public final ProductDetail productDetail;

    public Product(int quantity, ProductDetail productDetail) {
        this.quantity = quantity;
        this.productDetail = productDetail;
    }

    public double getPrice(){
        return productDetail.price * quantity;
    }
}
