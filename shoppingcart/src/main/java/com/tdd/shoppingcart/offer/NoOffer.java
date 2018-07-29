package com.tdd.shoppingcart.offer;

public class NoOffer implements Offer {

    @Override
    public double getPayableQuantity(int totalQuantity) {
        return totalQuantity;
    }
}
