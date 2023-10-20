package com.gildedrose.gildedStrategyPattern_v1.strategyInterface;

import com.gildedrose.Item;
import com.gildedrose.Item2;

public class BasicGildedRoseManagement implements GildedRoseManagement {
    public void updateSellInAndQualityDaily(Item item) {
        if(item.quality > 0){
            item.quality--;
            if(item.sellIn == 0) {
                item.quality--;
            }
        }
        item.sellIn--;
    }

    @Override
    public void updateSellInAndQualityDaily2(Item2 item) {
        if(item.quality > 0){
            decreaseQuality(item);
            if(item.sellIn == 0) {
                decreaseQuality(item);
            }
        }
        decreaseSellIn(item);
    }
}
