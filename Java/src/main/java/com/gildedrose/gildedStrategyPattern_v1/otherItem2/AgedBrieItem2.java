package com.gildedrose.gildedStrategyPattern_v1.otherItem2;

import com.gildedrose.Item2;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.GildedRoseManagement;
import lombok.Getter;

@Getter
public class AgedBrieItem2 extends Item2 {
    public AgedBrieItem2(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
        super(name,sellIn,quality,gildedRoseManagement);
    }

    @Override
    public GildedRoseManagement getGildedRoseManagement() {
        return super.gildedRoseManagement;
    }

}
