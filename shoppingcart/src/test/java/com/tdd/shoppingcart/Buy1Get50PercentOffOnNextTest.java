package com.tdd.shoppingcart;

import com.tdd.shoppingcart.offer.Buy1Get50PercentOffOnNext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Buy1Get50PercentOffOnNextTest {

    @DisplayName("Buy 1 THEN Get 50% on next")
    @Test
    public void buy1Get50PercOffOnNext(){
        Buy1Get50PercentOffOnNext buy1Get50PercentOffOnNext = new  Buy1Get50PercentOffOnNext();
        Assertions.assertEquals(1,buy1Get50PercentOffOnNext.getPayableQuantity(1));
    }

    @DisplayName("Buy 2 THEN PayableQuantity as 1.5")
    @Test
    public void buy2ThenPayWithOffer(){
        Buy1Get50PercentOffOnNext buy1Get50PercentOffOnNext = new  Buy1Get50PercentOffOnNext();
        Assertions.assertEquals(2.5,buy1Get50PercentOffOnNext.getPayableQuantity(3));
    }

    @DisplayName("Buy 3 THEN PayableQuantity as 2.5")
    @Test
    public void buy3ThenPayWithOffer(){
        Buy1Get50PercentOffOnNext buy1Get50PercentOffOnNext = new  Buy1Get50PercentOffOnNext();
        Assertions.assertEquals(1.5,buy1Get50PercentOffOnNext.getPayableQuantity(2));
    }

    @DisplayName("Buy 4 THEN PayableQuantity as 3")
    @Test
    public void buy4ThenPayWithOffer(){
        Buy1Get50PercentOffOnNext buy1Get50PercentOffOnNext = new  Buy1Get50PercentOffOnNext();
        Assertions.assertEquals(3,buy1Get50PercentOffOnNext.getPayableQuantity(4));
    }

}
