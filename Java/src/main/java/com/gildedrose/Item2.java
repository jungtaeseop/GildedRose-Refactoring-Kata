package com.gildedrose;


import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.GildedRoseManagement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item2 {

    public String name;

    public int sellIn;

    public int quality;

    protected GildedRoseManagement gildedRoseManagement;

    public Item2(String name, int sellIn, int quality, GildedRoseManagement gildedRoseManagement) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.gildedRoseManagement = gildedRoseManagement;
    }
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract GildedRoseManagement getGildedRoseManagement();
}
