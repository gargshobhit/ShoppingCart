package org.shop;

import org.shop.item.Item;
import org.shop.item.ShoppingCart;
import org.shop.item.offer.BuyXGetYDiscount;

import java.math.BigDecimal;

public class App
{
    public static void main( String[] args )
    {
        Item apple = new Item("Apple", new BigDecimal("10.00"));
        Item orange = new Item("Orange", new BigDecimal("5.00"));

        BuyXGetYDiscount buyOneGetOneFree = new BuyXGetYDiscount(1, 1); //buy 1, get 1
        BuyXGetYDiscount buyTwoGetOneFree = new BuyXGetYDiscount(2, 1); //buy 2, get 1

        ShoppingCart cart = new ShoppingCart();
        cart.addItemToCart(apple, 10);
        cart.addItemToCart(orange, 10);

        cart.addDiscount(apple,buyOneGetOneFree);
        cart.addDiscount(orange, buyTwoGetOneFree);


        System.out.println("Total price for cart :-> " + cart.calculateBasketCost());
    }
}
