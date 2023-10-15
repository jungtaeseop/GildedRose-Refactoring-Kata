package com.gildedrose.StrategyPattern.strategyInterface;

import com.gildedrose.Item;
import com.gildedrose.Item2;
import com.gildedrose.StrategyPattern.strategyInterface.GildedRoseManagement;

public class SulfurasGildedRoseManagement implements GildedRoseManagement {

    @Override
    public void updateSellInAndQualityDaily(Item item) {
        item.quality = 80;
    }

    @Override
    public void updateSellInAndQualityDaily2(Item2 item) {
        item.quality = 80;
    }
}
