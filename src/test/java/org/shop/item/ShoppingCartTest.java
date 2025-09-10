package org.shop.item;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    void whenBasketIsEmpty(){

        ShoppingCart cart = new ShoppingCart();

        assertEquals(BigDecimal.ZERO, cart.calculateBasketCost());
    }

    @Test
    void whenBasketHasOnlyOneItem(){

        ShoppingCart cart = new ShoppingCart();

        Item apple = new Item("Apple", BigDecimal.valueOf(5));

        cart.addItemToCart(apple, 10);
        assertEquals(BigDecimal.valueOf(50), cart.calculateBasketCost());
    }

    @Test
    void whenBasketHasMultipleItems(){

        ShoppingCart cart = new ShoppingCart();

        Item apples = new Item("Apple", BigDecimal.valueOf(5));
        Item oranges = new Item("Orange", BigDecimal.valueOf(10));

        cart.addItemToCart(apples, 20);
        cart.addItemToCart(oranges, 10);

        assertEquals(BigDecimal.valueOf(200), cart.calculateBasketCost());
    }

}
