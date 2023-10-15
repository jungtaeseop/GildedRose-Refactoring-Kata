package com.gildedrose.StrategyPattern.otherItem2;

import com.gildedrose.Item2;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;

public class Basic2 extends Item2 {
    private GildedRoseManagement gildedRoseManagement;

    public Basic2(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
        super(name, sellIn, quality);
        this.gildedRoseManagement = gildedRoseManagement;
    }

    public void setGildedRoseManagement(GildedRoseManagement gildedRoseManagement) {
        this.gildedRoseManagement = gildedRoseManagement;
    }

    public GildedRoseManagement getGildedRoseManagement(){
        return this.gildedRoseManagement;
    }
}
