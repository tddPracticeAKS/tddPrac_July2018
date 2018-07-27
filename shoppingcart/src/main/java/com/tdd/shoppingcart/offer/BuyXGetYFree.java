package com.tdd.shoppingcart.offer;

public class BuyXGetYFree implements Offer {

    public final int purchasedQuantity;
    public final int freeQuantity;

    public BuyXGetYFree(int purchasedQuantity, int freeQuantity) {
        this.purchasedQuantity = purchasedQuantity;
        this.freeQuantity = freeQuantity;
    }

    public int getPayableQuantity(int totalQuantity) {
        int discountQuantity = (totalQuantity / (purchasedQuantity+ freeQuantity));
        return totalQuantity - discountQuantity;
    }
}
