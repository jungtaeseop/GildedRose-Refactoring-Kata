package com.gildedrose.StrategyPattern.otherItem2;

import com.gildedrose.Item2;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;
import lombok.Getter;

@Getter
public class AgedBrieItem2 extends Item2 {
    private GildedRoseManagement gildedRoseManagement;
    public AgedBrieItem2(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
        super(name,sellIn,quality);
        this.gildedRoseManagement = gildedRoseManagement;
    }

    public GildedRoseManagement getInventoryManagement(){
        return this.gildedRoseManagement;
    }
}
