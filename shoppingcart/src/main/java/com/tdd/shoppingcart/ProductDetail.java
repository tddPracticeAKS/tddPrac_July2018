package com.tdd.shoppingcart;

public class ProductDetail {
    public final String name;
    public final double price;


    public ProductDetail(String name, double price) {
        this.name =  name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDetail product = (ProductDetail) o;

        if (Double.compare(product.price, price) != 0) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
