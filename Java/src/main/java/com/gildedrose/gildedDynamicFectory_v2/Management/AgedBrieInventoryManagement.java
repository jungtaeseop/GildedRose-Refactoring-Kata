package com.gildedrose.gildedDynamicFectory_v2.Management;

import com.gildedrose.Item;

public class AgedBrieInventoryManagement implements InventoryManagement{
    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50) {
            increaseQualityDaily(item);
        }
        decrementSellInDaily(item);
    }

}
