package com.tdd.shoppingcart.offer;

public class BuyXGetYFree implements Offer {

    public final int purchasedQuantity;
    public final double freeQuantity;

    public BuyXGetYFree(int purchasedQuantity, double freeQuantity) {
        this.purchasedQuantity = purchasedQuantity;
        this.freeQuantity = freeQuantity;
    }

    public double getPayableQuantity(int totalQuantity) {
        if(totalQuantity == 1)
            return totalQuantity;
        int noOfElements = (int) (purchasedQuantity + freeQuantity);
        int noOfGroups =  totalQuantity / noOfElements;
        int freePerGroup = (noOfElements % purchasedQuantity );
        int totalFreeQuantity = (noOfGroups * freePerGroup) + ((totalQuantity % noOfElements) % purchasedQuantity);
        return totalQuantity - totalFreeQuantity;
    }
}
