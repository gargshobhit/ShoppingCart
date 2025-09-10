package org.shop;

import org.shop.item.Item;
import org.shop.item.ShoppingCart;

import java.math.BigDecimal;

public class App
{
    public static void main( String[] args )
    {
        Item apple = new Item("Apple", new BigDecimal("10.00"));
        Item orange = new Item("Orange", new BigDecimal("5.00"));

        ShoppingCart cart = new ShoppingCart();
        cart.addItemToCart(apple, 10);
        cart.addItemToCart(orange, 10);


        System.out.println("Total price for cart :-> " + cart.calculateBasketCost());
    }
}
