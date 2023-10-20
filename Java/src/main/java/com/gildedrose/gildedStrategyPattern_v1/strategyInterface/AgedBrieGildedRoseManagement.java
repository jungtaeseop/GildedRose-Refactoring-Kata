package com.gildedrose.gildedStrategyPattern_v1.strategyInterface;

import com.gildedrose.Item;
import com.gildedrose.Item2;

public class AgedBrieGildedRoseManagement implements GildedRoseManagement {

    @Override
    public void updateSellInAndQualityDaily(Item item) {
        if(item.quality < 50){
            item.quality++;
        }
        item.sellIn--;
    }

    @Override
    public void updateSellInAndQualityDaily2(Item2 item) {
        if(item.quality < 50){
            improvementQuality(item);
        }
        decreaseSellIn(item);
    }
}
