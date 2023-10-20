package com.gildedrose.gildedStrategyPattern_v1.context;

import com.gildedrose.Item2;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.GildedRoseManagement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GildedRoseStrategy2 {

    private GildedRoseManagement gildedRoseManagement;

    public void updateQuality2(List<Item2> items){
        for(Item2 item : items){
            item.getGildedRoseManagement().updateSellInAndQualityDaily2(item);
        }
    }
}
