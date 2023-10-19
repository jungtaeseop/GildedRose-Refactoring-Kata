package com.gildedrose.fectory.Management;

import com.gildedrose.Item;

public interface InventoryManagement {

    public void updateQuality(Item item);
    default void decrementSellInAndQualityDaily(Item item) {
        if(item.quality > 0){
            item.quality--;
        }
        item.sellIn--;
    }

    default void IncreaseQualityDaily(Item item) {
        if(item.quality < 50){
            item.quality++;
        }
        item.sellIn--;
    }

    default void SulfurasQualityDaily(Item item) {
        item.quality = 80;
    }
}
