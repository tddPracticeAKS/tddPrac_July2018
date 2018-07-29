package com.tdd.shoppingcart;

import com.tdd.shoppingcart.offer.Buy1Get50PercentOffOnNext;
import com.tdd.shoppingcart.offer.BuyXGetYFree;
import com.tdd.shoppingcart.offer.NoOffer;
import com.tdd.shoppingcart.offer.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private final NoOffer noOffer = new NoOffer();
    private final Offer buy2Get1Free = new BuyXGetYFree(2, 1);
    private final ProductDetail hairCream = new ProductDetail("Gatsby hair cream", 30);
    private final ProductDetail bvlgiriSoap = new ProductDetail("Bvlgiri Soap", 100);

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @DisplayName("shopping cart is empty THEN product count as 0")
    @Test
    public void cartEmptyThenCountZero() {
        assertEquals(0, shoppingCart.getCount());
    }

    @DisplayName("Add 1 unit of ‘Gatsby hair cream of price Rs. 30’ THEN product count as 1 and total value 30")
    @Test
    public void addOneProductWithPriceThenCountOneAndCorrectPrice() {
        Product product = new Product(1, hairCream);
        shoppingCart.add(product);
        assertCountAndPrice(1, 30);
    }

    @DisplayName("Add two products of different price THEN product count as 2 and total value as sum")
    @Test
    public void addTwoProductWithPriceThenCountTwoAndCorrectPrice() {

        Product hairCreamProduct = new Product(1, hairCream);
        Product soapProduct = new Product(1, bvlgiriSoap);
        shoppingCart.add(hairCreamProduct);
        shoppingCart.add(soapProduct);

        assertCountAndPrice(2, 130);
    }

    @DisplayName("Add multiple units of a product THEN product count is 1")
    @Test
    public void addMultipleProductsProductCountAsOne() {
        Product product = new Product(5, hairCream);
        shoppingCart.add(product);
        assertCountAndPrice(1, 150);
    }

    @DisplayName("Add a product of per unit price Rs. 30 with an offer’ THEN product count as 1 and total value 120")
    @Test
    public void addOneProductWithOfferThenCountOneAndCorrectPrice() {
        Product product = new Product(5, hairCream);
        shoppingCart.add(product);
        Map<ProductDetail, Offer> offers = new HashMap<>();
        offers.put(hairCream, buy2Get1Free);
        shoppingCart.addOffers(offers);
        assertCountAndPrice(1, 120);
    }

    @DisplayName(" - Add 3 unit of ‘Gatsby hair cream’, unit price 30 Rupees.\n" +
            " – Add 2 unit of ‘Bvlgiri Soap’, unit price 100 Rupees. " +
            " THEN product count as 2 and total value as 260")
    @Test
    public void addTwoProductThenProductCountAsTwoAndVerifyTotalPrice() {
        Product hairCreamProduct = new Product(3, hairCream);
        shoppingCart.add(hairCreamProduct);

        Product bvlgiriSoapProduct = new Product(2, bvlgiriSoap);
        shoppingCart.add(bvlgiriSoapProduct);

        Map<ProductDetail, Offer> offers = new HashMap() {{
            put(hairCream, buy2Get1Free);
            put(bvlgiriSoap, noOffer);
        }};
        shoppingCart.addOffers(offers);

        assertCountAndPrice(2, 260);
    }

    @DisplayName(" - Add 2 unit of ‘Gatsby hair cream’, unit price 30 Rupees. \n" +
            " – The product count of cart should be 1.\n" +
            "– The total price of product should be 45.\n" +
            "– The total value of cart should be 45.0 rupees")
    @Test
    public void addTwoHairCreamThenVerifyTotalPrice() {
        Product hairCreamProduct = new Product(2, hairCream);
        shoppingCart.add(hairCreamProduct);

        Buy1Get50PercentOffOnNext buy1Get50PercentOffOnNextTest = new Buy1Get50PercentOffOnNext();
        Map<ProductDetail, Offer> offers = new HashMap() {{
            put(hairCream, buy1Get50PercentOffOnNextTest);
        }};
        shoppingCart.addOffers(offers);

        assertCountAndPrice(1, 45);
    }

    private void assertCountAndPrice(int count, int totalPrice) {
        assertEquals(count, shoppingCart.getCount());
        assertEquals(totalPrice, shoppingCart.getTotalValue());
    }

}
