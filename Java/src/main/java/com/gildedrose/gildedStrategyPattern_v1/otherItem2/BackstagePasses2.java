package com.gildedrose.gildedStrategyPattern_v1.otherItem2;

import com.gildedrose.Item2;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.GildedRoseManagement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BackstagePasses2 extends Item2 {

    public BackstagePasses2(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement){
        super(name, sellIn, quality,gildedRoseManagement);
    }

    @Override
    public GildedRoseManagement getGildedRoseManagement(){
        return super.gildedRoseManagement;
    }
}
