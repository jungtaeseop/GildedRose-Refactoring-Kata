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
        //given
        Item item = Item.itemCreate()
            .name("name")
            .sellIn(10)
            .quality(10)
            .build();

        //when
        List<Item> items = new ArrayList<>();
        items.add(item);

        GildedRose2 app = new GildedRose2(items);
        app.updateQuality();

        //then
        assertThat(9).isEqualTo(app.items.get(0).sellIn);
        assertThat(9).isEqualTo(app.items.get(0).quality);

    }

    @DisplayName("판매하는 나머지 일수가 없어지면, Quality 값은 2배로 떨어집니다.")
    @Test
    public void sellIn_0일때_quality_down_2(){
        //given
        Item item = Item.itemCreate()
            .name("test Name")
            .sellIn(0)
            .quality(50)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(48).isEqualTo(items.get(0).getQuality());
        assertThat(-1).isEqualTo(items.get(0).getSellIn());
    }

    @DisplayName("Quality 값은 결코 음수가 되지는 않습니다.")
    @Test
    public void Quality_값은_결코_음수가_되지는_않습니다(){
        //given
        Item item = Item.itemCreate()
            .name("test")
            .sellIn(1)
            .quality(0)
            .build();
        Item item2 = Item.itemCreate()
            .name("test2")
            .sellIn(0)
            .quality(-1)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(0).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);

        assertThat(-1).isEqualTo(items.get(1).quality);
        assertThat(-1).isEqualTo(items.get(1).sellIn);
    }

    @DisplayName("\"Aged Brie\"(오래된 브리치즈)은(는) 시간이 지날수록 Quality 값이 올라갑니다.")
    @Test
    public void Aged_Brie는_시간이_지날수록_Quality_값이_올라갑니다(){
        //given
        Item item = Item.itemCreate()
            .name("Aged Brie")
            .quality(49)
            .sellIn(1)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("\"Aged Brie\"(오래된 브리치즈)은(는) 시간이 지날수록 Quality 값 max 일때")
    @Test
    public void Aged_Brie는_시간이_지날수록_Quality_값이_max(){
        //given
        Item item = Item.itemCreate()
            .name("Aged Brie")
            .quality(50)
            .sellIn(0)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(-1).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("Quality 값은 50를 초과 할 수 없습니다.")
    @Test
    public void Quality_값은_50를_초과_할수_없음(){
        //given
        Item item = Item.itemCreate()
            .name("Aged Brie")
            .quality(50)
            .sellIn(1)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("Sulfuras는 전설의 아이템이므로, 반드시 판매될 필요도 없고 Quality 값도 떨어지지 않습니다.")
    @Test
    public void Sulfuras는_전설의_아이템이므로_반드시_판매될_필요도_없고_Quality_값도_떨어지지_않음(){
        //given
        Item item = Item.itemCreate()
            .name("Sulfuras, Hand of Ragnaros")
            .quality(10)
            .sellIn(0)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(10).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("\"Backstage passes(백스테이지 입장권)\"는 \"Aged Brie\"와 유사하게 " +
        "SellIn 값에 가까워 질수록 Quality 값이 상승하고, 10일 부터는 매일 2 씩 증가하다, " +
        "5일 부터는이 되면 매일 3 씩 증가하지만, 콘서트 종료 후에는 0으로 떨어집니다.")
    @Test
    public void Backstage_passes는_SellIn_값에_가까워_질수록_Quality_값이_상승하고_10일_부터는_매일_2_씩_증가하다(){
        //given
        Item item = Item.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(10)
            .build();
        Item item1 = Item.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(5)
            .build();
        Item item2 = Item.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(0)
            .build();

        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item1);
        items.add(item2);

        //when
        GildedRose2 gildedRose2 = new GildedRose2(items);
        gildedRose2.updateQuality();

        //then
        assertThat(12).isEqualTo(items.get(0).quality);
        assertThat(9).isEqualTo(items.get(0).sellIn);

        assertThat(13).isEqualTo(items.get(1).quality);
        assertThat(4).isEqualTo(items.get(1).sellIn);

        assertThat(0).isEqualTo(items.get(2).quality);
        assertThat(-1).isEqualTo(items.get(2).sellIn);
    }

}
