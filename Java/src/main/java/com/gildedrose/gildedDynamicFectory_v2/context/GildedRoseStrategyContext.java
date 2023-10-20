package com.gildedrose.gildedDynamicFectory_v2.context;

import com.gildedrose.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GildedRoseStrategyContext {

    /* 생략 가능
    public void updateItemQuality(Item item){
        DynamicSupplierFactory.getInventoryManagement(item.name).updateQuality(item);
    }*/

}
