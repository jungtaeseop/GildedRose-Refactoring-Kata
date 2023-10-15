package com.gildedrose;


import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item2 {

    public String name;

    public int sellIn;

    public int quality;

    public Item2(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract GildedRoseManagement getGildedRoseManagement();
}
