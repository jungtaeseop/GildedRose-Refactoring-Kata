package com.gildedrose;

import com.gildedrose.StrategyPattern.strategyInterface.AgedBrieGildedRoseManagement;
import com.gildedrose.StrategyPattern.strategyInterface.BasicGildedRoseManagement;
import com.gildedrose.StrategyPattern.context.GildedRoseStrategy2;
import com.gildedrose.StrategyPattern.otherItem2.AgedBrieItem2;
import com.gildedrose.StrategyPattern.otherItem2.Basic2;
import com.gildedrose.fectory.Management.InventoryManagement;
import com.gildedrose.fectory.Management.SulfurasInventoryManagement;
import com.gildedrose.fectory.otherItem.AgedBrieItem;
import com.gildedrose.fectory.otherItem.Basic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat("foo").isEqualTo(app.items[0].name);
    }


    @DisplayName("하루가 지날때 마다 SellIn, Quality을 1 씩 감소")
    @Test
    void SellIn_Quality을_1씩_감소_배열() {

        Item[] items = new Item[] {
            new Basic("foo", 10, 10,new BasicGildedRoseManagement())
            ,new AgedBrieItem("Aged Brie", 2, 0,new AgedBrieGildedRoseManagement())
        };

        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();

        InventoryManagement inventoryManagement = new SulfurasInventoryManagement();
        /*inventoryManagement.updateQuality();*/

        gildedRoseStrategy2.updateQuality(items);

        assertThat(9).isEqualTo(items[0].quality);
        assertThat(9).isEqualTo(items[0].sellIn);

        assertThat(1).isEqualTo(items[1].quality);
        assertThat(1).isEqualTo(items[1].sellIn);
    }

    @DisplayName("하루가 지날때 마다 SellIn, Quality을 1 씩 감소")
    @Test
    void SellIn_Quality을_1씩_감소_List() {

        Item2 item2_1 = new Basic2("foo", 10, 10,new BasicGildedRoseManagement());
        Item2 item2_2 = new AgedBrieItem2("Aged Brie", 2, 0,new AgedBrieGildedRoseManagement());

        List<Item2> items = Arrays.asList(item2_1,item2_2);

        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();

        gildedRoseStrategy2.updateQuality2(items);

        assertThat(9).isEqualTo(items.get(0).quality);
        assertThat(9).isEqualTo(items.get(0).sellIn);

        assertThat(1).isEqualTo(items.get(1).quality);
        assertThat(1).isEqualTo(items.get(1).sellIn);
    }
}
