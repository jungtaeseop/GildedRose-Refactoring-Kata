package com.gildedrose.fectory.Management;

import com.gildedrose.Item;

public class SulfurasInventoryManagement implements InventoryManagement{
    @Override
    public void updateQuality(Item[] items) {
        for(int i=0; i<items.length; i++){
            SulfurasQualityDaily(items[i]);
        }
    }


}
