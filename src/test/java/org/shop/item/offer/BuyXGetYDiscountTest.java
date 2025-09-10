package org.shop.item.offer;

import org.junit.jupiter.api.Test;
import org.shop.item.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyXGetYDiscountTest {

    private final Item apple = new Item("Apple", new BigDecimal("5.00"));
    private final BuyXGetYDiscount buyTwoGetOne = new BuyXGetYDiscount(2, 1); // Buy 2, Get 3 Free

    @Test
    void testExactBlockQuantity(){

        // exact quantity as per offer
        assertEquals( new BigDecimal("30").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 9) );

        assertEquals( new BigDecimal("40").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 12) );

        assertEquals( new BigDecimal("20").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 6) );
    }

    @Test
    void testExactOneBlock(){

        assertEquals( new BigDecimal("10").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 3) );

    }

    @Test
    void testWhenQuantityIsLessThanOffer(){

        assertEquals( new BigDecimal("5").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 1) );

    }

    @Test
    void testWhenQuantityIsOverThanOffer(){

        assertEquals( new BigDecimal("45").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 13) );

    }

    @Test
    void testWhenQuantityIsLarge(){

        assertEquals( new BigDecimal("335").setScale(2, RoundingMode.HALF_UP), buyTwoGetOne.offer(apple, 100) );

    }
}
