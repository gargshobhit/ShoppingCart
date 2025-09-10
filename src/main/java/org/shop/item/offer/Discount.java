package org.shop.item.offer;

import org.shop.item.Item;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal offer(Item item, int quantity);
}
