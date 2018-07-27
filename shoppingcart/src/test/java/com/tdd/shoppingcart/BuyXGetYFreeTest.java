package com.tdd.shoppingcart;

import com.tdd.shoppingcart.offer.BuyXGetYFree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyXGetYFreeTest {

    @DisplayName(" Buy 2 then 1 free")
    @Test
    public void buy2Then1Free(){
        BuyXGetYFree buyXGetYFree = new BuyXGetYFree(2,1);
        Assertions.assertEquals(0, buyXGetYFree.getPayableQuantity(0));
        Assertions.assertEquals(1, buyXGetYFree.getPayableQuantity(1));
        Assertions.assertEquals(2, buyXGetYFree.getPayableQuantity(2));
        Assertions.assertEquals(2, buyXGetYFree.getPayableQuantity(3));
        Assertions.assertEquals(3, buyXGetYFree.getPayableQuantity(4));
        Assertions.assertEquals(4, buyXGetYFree.getPayableQuantity(5));
    }

    @DisplayName(" Buy 1 then 1 free")
    @Test
    public void buy1Then1Free(){
        BuyXGetYFree buyXGetYFree = new BuyXGetYFree(1,1);
        Assertions.assertEquals(0, buyXGetYFree.getPayableQuantity(0));
        Assertions.assertEquals(1, buyXGetYFree.getPayableQuantity(1));
        Assertions.assertEquals(1, buyXGetYFree.getPayableQuantity(2));
        Assertions.assertEquals(2, buyXGetYFree.getPayableQuantity(3));
        Assertions.assertEquals(2, buyXGetYFree.getPayableQuantity(4));
    }

}
