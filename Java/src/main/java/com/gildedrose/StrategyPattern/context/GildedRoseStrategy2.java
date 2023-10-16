package com.gildedrose.StrategyPattern.context;

import com.gildedrose.Item;
import com.gildedrose.Item2;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;
import com.gildedrose.fectory.otherItem.AgedBrieItem;
import com.gildedrose.fectory.otherItem.BackstagePasses;
import com.gildedrose.fectory.otherItem.Basic;
import com.gildedrose.fectory.otherItem.Sulfuras;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GildedRoseStrategy2 {

    private GildedRoseManagement gildedRoseManagement;
    public void updateQuality(Item[] items){
        for(int i=0; i<items.length; i++){

            if (items[i] instanceof AgedBrieItem) {
                gildedRoseManagement = ((AgedBrieItem) items[i]).getInventoryManagement();
            }else if(items[i] instanceof BackstagePasses) {
                gildedRoseManagement = ((BackstagePasses) items[i]).getGildedRoseManagement();
            }else if(items[i] instanceof Sulfuras) {
                gildedRoseManagement = ((Sulfuras) items[i]).getGildedRoseManagement();
            }else {
                gildedRoseManagement = ((Basic) items[i]).getGildedRoseManagement();
            }

            gildedRoseManagement.updateSellInAndQualityDaily(items[i]);
        }

    }

    public void updateQuality2(List<Item2> items){
        for(Item2 item : items){
            gildedRoseManagement = item.getGildedRoseManagement();
            gildedRoseManagement.updateSellInAndQualityDaily2(item);
        }

    }
}
