package org.shop.item.offer;

import org.shop.item.Item;

import java.math.BigDecimal;

public class BuyXGetYDiscount implements Discount{

    private final int buyX;
    private final int getY;

    public BuyXGetYDiscount(int buyX, int getY) {
        this.buyX = buyX;
        this.getY = getY;
    }

    @Override
    public BigDecimal offer(Item item, int quantity) {

        if (quantity < buyX)
            return item.price().multiply(new BigDecimal(quantity));

        if (quantity < (buyX + getY))
           return item.price().multiply(new BigDecimal(buyX));

        int itemBlock = quantity / (buyX + getY);

        int reminder = quantity % (buyX + getY);

        int totalItemsToPay = itemBlock * buyX + Math.min(buyX, reminder);
        return item.price().multiply(new BigDecimal(totalItemsToPay));
    }
}
