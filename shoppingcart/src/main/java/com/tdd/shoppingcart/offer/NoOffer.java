package com.tdd.shoppingcart.offer;

public class NoOffer implements Offer {

    @Override
    public int getPayableQuantity(int totalQuantity) {
        return totalQuantity;
    }
}
