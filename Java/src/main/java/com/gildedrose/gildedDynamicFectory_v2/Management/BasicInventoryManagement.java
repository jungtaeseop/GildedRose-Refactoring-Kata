package com.gildedrose.gildedDynamicFectory_v2.Management;

import com.gildedrose.Item;

public class BasicInventoryManagement implements InventoryManagement {

    @Override
    public void updateQuality(Item item){
        if(item.quality > 0){
            decrementQualityDaily(item);
        }
        decrementSellInDaily(item);
    }

}
