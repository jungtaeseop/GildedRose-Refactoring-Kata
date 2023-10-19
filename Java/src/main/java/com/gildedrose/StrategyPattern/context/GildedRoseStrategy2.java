package com.gildedrose.StrategyPattern.context;

import com.gildedrose.Item;
import com.gildedrose.Item2;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;
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
