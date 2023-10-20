package com.gildedrose.gildedStrategyPattern_v1.strategyInterface;

import com.gildedrose.Item;
import com.gildedrose.Item2;

public interface GildedRoseManagement {

    public void updateSellInAndQualityDaily(Item item);

    public void updateSellInAndQualityDaily2(Item2 item);

    default void decreaseQuality(Item2 item2) {
        item2.quality--;
    }

    default void decreaseSellIn(Item2 item2) {
        item2.sellIn--;
    }

    default void improvementQuality(Item2 item2) {
        item2.quality++;
    }

}
