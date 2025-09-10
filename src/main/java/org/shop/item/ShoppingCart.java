package org.shop.item;

import org.shop.item.offer.Discount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Item, Integer> basket = new HashMap<>();
    Map<Item, Discount> discounts = new HashMap<>();

    public void addItemToCart(Item item, int quantity){
        basket.put(item, quantity);
    }

    public void addDiscount(Item item, Discount discount){
        discounts.put(item, discount);
    }

    public BigDecimal calculateBasketCost(){

        return basket.entrySet()
                .stream()
                .map(entry ->
                {
                    Item item = entry.getKey();
                    int quantity = entry.getValue();
                    Discount discountOnItem = discounts.get(item);

                    if (discountOnItem != null) {
                        return discountOnItem.offer(item, quantity);
                    } else {
                        return item.price().multiply(BigDecimal.valueOf(quantity));
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
