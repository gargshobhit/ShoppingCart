package org.shop.item;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Item, Integer> basket = new HashMap<>();
    public void addItemToCart(Item item, int quantity){
        basket.put(item, quantity);
    }

    public BigDecimal calculateBasketCost(){

        return basket.entrySet()
                .stream()
                .map(entry ->
                {
                    Item item = entry.getKey();
                    int quantity = entry.getValue();

                    return item.price().multiply(BigDecimal.valueOf(quantity));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
