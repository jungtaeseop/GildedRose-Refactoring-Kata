package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    public void SellIn_Quality을_1씩_감소(){
        Item item = Item.itemCreate()
            .name("name")
            .sellIn(10)
            .quality(10)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        GildedRose2 app = new GildedRose2(items);
        app.updateQuality();

        assertThat(9).isEqualTo(app.items.get(0).sellIn);
        assertThat(9).isEqualTo(app.items.get(0).quality);

    }


}
