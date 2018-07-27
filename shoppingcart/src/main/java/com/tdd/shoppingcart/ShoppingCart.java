package com.tdd.shoppingcart;

import com.tdd.shoppingcart.offer.BuyXGetYFree;
import com.tdd.shoppingcart.offer.NoOffer;
import com.tdd.shoppingcart.offer.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();
    private Map<ProductDetail, Offer> offers = new HashMap<>();

    public long getCount() {
        return products.size();
    }

    public void add(Product product) {
        products.add(product);
    }

    public double getTotalValue() {
        return products.stream().mapToDouble(product -> getProductPriceWithOffer(product,offers.getOrDefault(product.productDetail,new NoOffer()))).sum();
    }

    private double getProductPriceWithOffer(Product product, Offer offer) {
       return offer.getPayableQuantity(product.quantity) * product.productDetail.price;
    }

    public void addOffers(Map<ProductDetail, Offer> offers) {
        this.offers = offers;
    }
}
