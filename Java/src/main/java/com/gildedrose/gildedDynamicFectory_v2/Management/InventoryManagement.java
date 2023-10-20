package com.gildedrose.gildedDynamicFectory_v2.Management;

import com.gildedrose.Item;

public interface InventoryManagement {
    int MAX_QUALITY = 50;

    void updateQuality(Item item);

    default void maxQualityValidation(Item item) {
        if(item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    default void decrementQualityDaily(Item item) {
        item.quality--;
        if(item.sellIn <= 0) {
            item.quality--;
        }
    }

    default void decrementSellInDaily(Item item) {
        item.sellIn--;
    }

    default void increaseQualityDaily(Item item) {
        item.quality++;
    }

}
