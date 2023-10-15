package com.gildedrose.fectory.otherItem;

import com.gildedrose.Item;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;

public class Basic extends Item {
    private GildedRoseManagement gildedRoseManagement;

    public Basic(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
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
