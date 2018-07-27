package com.tdd.shoppingcart;

import com.tdd.shoppingcart.offer.BuyXGetYFree;
import com.tdd.shoppingcart.offer.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartTest {

    @DisplayName("shopping cart is empty THEN product count as 0")
    @Test
    public void cartEmptyThenCountZero(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Assertions.assertEquals(0,shoppingCart.getCount());
    }

    @DisplayName("Add 1 unit of ‘Gatsby hair cream of price Rs. 30’ THEN product count as 1 and total value 30")
    @Test
    public void addOneProductWithPriceThenCountOneAndCorrectPrice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ProductDetail productDetail = new ProductDetail("Gatsby hair cream",30);
        Product product = new Product(1,productDetail);
        shoppingCart.add(product);
        Assertions.assertEquals(1,shoppingCart.getCount());
        Assertions.assertEquals(30,shoppingCart.getTotalValue());
    }

    @DisplayName("Add two products of different price THEN product count as 2 and total value as sum")
    @Test
    public void addTwoProductWithPriceThenCountTwoAndCorrectPrice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ProductDetail hairCream = new ProductDetail("Gatsby hair cream",30);
        ProductDetail soap = new ProductDetail("Bvlgiri Soap",100);
        Product hairCreamProduct = new Product(1,hairCream);
        Product soapProduct = new Product(1,soap);
        shoppingCart.add(hairCreamProduct);
        shoppingCart.add(soapProduct);

        Assertions.assertEquals(2,shoppingCart.getCount());
        Assertions.assertEquals(130,shoppingCart.getTotalValue());
    }

    @DisplayName("Add multiple units of a product THEN product count is 1")
    @Test
    public void addMultipleProductsProductCountAsOne(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ProductDetail productDetail = new ProductDetail("Gatsby hair cream",30);
        Product product = new Product(5,productDetail);
        shoppingCart.add(product);
        Assertions.assertEquals(1,shoppingCart.getCount());
        Assertions.assertEquals(150,shoppingCart.getTotalValue());
    }

    @DisplayName("Add a product of per unit price Rs. 30 with an offer’ THEN product count as 1 and total value 120")
    @Test
    public void addOneProductWithOfferThenCountOneAndCorrectPrice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Offer buyXGetYFree = new BuyXGetYFree(2,1);
        ProductDetail productDetail = new ProductDetail("Gatsby hair cream",30);
        Product product = new Product(5,productDetail);
        shoppingCart.add(product);
        Map<ProductDetail,Offer> offers = new HashMap<>();
        offers.put(productDetail,buyXGetYFree);
        shoppingCart.addOffers(offers);
        Assertions.assertEquals(1,shoppingCart.getCount());
        Assertions.assertEquals(120,shoppingCart.getTotalValue());
    }

}
