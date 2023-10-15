package com.gildedrose.fectory.otherItem;

import com.gildedrose.Item;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;
import lombok.Getter;

@Getter
public class AgedBrieItem extends Item {
    private GildedRoseManagement gildedRoseManagement;
    public AgedBrieItem(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
        super(name,sellIn,quality);
        this.gildedRoseManagement = gildedRoseManagement;
    }

    public GildedRoseManagement getInventoryManagement(){
        return this.gildedRoseManagement;
    }
}
