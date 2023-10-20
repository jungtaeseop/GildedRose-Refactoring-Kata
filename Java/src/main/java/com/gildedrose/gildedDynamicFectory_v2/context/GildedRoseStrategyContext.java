package com.gildedrose.gildedDynamicFectory_v2.context;

import com.gildedrose.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GildedRoseStrategyContext {

    DynamicSupplierFactory dynamicSupplierFactory = new DynamicSupplierFactory();

    public void updateItemQuality(Item item){
        dynamicSupplierFactory.getInventoryManagement(item.name).updateQuality(item);
    }

}
