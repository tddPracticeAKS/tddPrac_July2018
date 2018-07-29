package com.tdd.shoppingcart.offer;

public class Buy1Get50PercentOffOnNext implements Offer {

    @Override
    public double getPayableQuantity(int totalQuantity) {
        return totalQuantity % 2 * 1 + totalQuantity / 2 * 1.5;
    }

}
