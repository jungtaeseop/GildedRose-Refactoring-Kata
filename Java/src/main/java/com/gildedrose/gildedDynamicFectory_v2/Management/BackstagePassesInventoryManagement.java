package com.gildedrose.gildedDynamicFectory_v2.Management;

import com.gildedrose.Item;

public class BackstagePassesInventoryManagement implements InventoryManagement{

    @Override
    public void updateQuality(Item item) {
        increaseQualityDaily(item);
        if(item.sellIn <= 10 && item.sellIn > 5) {
            item.quality += 1;
        }
        if(item.sellIn <= 5 && item.quality > 0) {
            item.quality += 2;
        }
        if(item.sellIn == 0) {
            item.quality = 0;
        }
        maxQualityValidation(item);
        decrementSellInDaily(item);
    }
}
