package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        //given
        Item[] items = new Item[] {
            new Item("foo", 10, 10)
            ,new Item("Aged Brie",2, 0)
        };

        //when
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        //then
        assertThat(9).isEqualTo(items[0].quality);
        assertThat(9).isEqualTo(items[0].sellIn);
    }

}
