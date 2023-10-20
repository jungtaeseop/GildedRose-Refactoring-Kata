package com.gildedrose;

import com.gildedrose.gildedStrategyPattern_v1.otherItem2.AgedBrieItem2;
import com.gildedrose.gildedStrategyPattern_v1.otherItem2.Sulfuras2;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.AgedBrieGildedRoseManagement;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.BasicGildedRoseManagement;
import com.gildedrose.gildedStrategyPattern_v1.context.GildedRoseStrategy2;
import com.gildedrose.gildedStrategyPattern_v1.otherItem2.Basic2;
import com.gildedrose.gildedStrategyPattern_v1.strategyInterface.SulfurasGildedRoseManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest2 {

    @DisplayName("하루가 지날때 마다 SellIn, Quality을 1 씩 감소")
    @Test
    public void SellIn_Quality을_1씩_감소(){
        //given
        Item2 item = new Basic2("foo",10,10, new BasicGildedRoseManagement());

        //when
        List<Item2> items = Arrays.asList(item);

        GildedRoseStrategy2 app = new GildedRoseStrategy2();
        app.updateQuality2(items);

        //then
        assertThat(9).isEqualTo(items.get(0).sellIn);
        assertThat(9).isEqualTo(items.get(0).quality);

    }

    @DisplayName("판매하는 나머지 일수가 없어지면, Quality 값은 2배로 떨어집니다.")
    @Test
    public void sellIn_0일때_quality_down_2(){
        //given
        Item2 item = new Basic2("test Name",0,50,new BasicGildedRoseManagement());

        List<Item2> items = Arrays.asList(item);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(48).isEqualTo(items.get(0).getQuality());
        assertThat(-1).isEqualTo(items.get(0).getSellIn());
    }

    @DisplayName("Quality 값은 결코 음수가 되지는 않습니다.")
    @Test
    public void Quality_값은_결코_음수가_되지는_않습니다(){
        //given
        Item2 item = new Basic2("testBasic",1,0,new BasicGildedRoseManagement());
        Item2 item2 = new Basic2("test2Basic",0,-1,new BasicGildedRoseManagement());

        List<Item2> items = Arrays.asList(item,item2);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(0).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);

        assertThat(-1).isEqualTo(items.get(1).quality);
        assertThat(-1).isEqualTo(items.get(1).sellIn);
    }

    @Nested

    @DisplayName("\"Aged Brie\"(오래된 브리치즈)은(는) 시간이 지날수록 Quality 값이 올라갑니다.")
    @Test
    public void Aged_Brie는_시간이_지날수록_Quality_값이_올라갑니다(){
        //given
        Item2 item = new AgedBrieItem2("Aged Brie",1,49,new AgedBrieGildedRoseManagement());

        List<Item2> items = Arrays.asList(item);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("\"Aged Brie\"(오래된 브리치즈)은(는) 시간이 지날수록 Quality 값 max 일때")
    @Test
    public void Aged_Brie는_시간이_지날수록_Quality_값이_max(){
        //given
        Item2 item = new AgedBrieItem2("Aged Brie", 0,50,new AgedBrieGildedRoseManagement());

        List<Item2> items = Arrays.asList(item);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(-1).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("Quality 값은 50를 초과 할 수 없습니다.")
    @Test
    public void Quality_값은_50를_초과_할수_없음(){
        //given
        Item2 item = new AgedBrieItem2("Aged Brie",1,50,new AgedBrieGildedRoseManagement());

        List<Item2> items = Arrays.asList(item);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(50).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }

    @DisplayName("Sulfuras는 전설의 아이템이므로, 반드시 판매될 필요도 없고 Quality 값도 떨어지지 않습니다.")
    @Test
    public void Sulfuras는_전설의_아이템이므로_반드시_판매될_필요도_없고_Quality_값도_떨어지지_않음(){
        //given
        Item2 item = new Sulfuras2("Sulfuras, Hand of Ragnaros",0,10,new SulfurasGildedRoseManagement());

        List<Item2> items = Arrays.asList(item);

        //when
        GildedRoseStrategy2 gildedRoseStrategy2 = new GildedRoseStrategy2();
        gildedRoseStrategy2.updateQuality2(items);

        //then
        assertThat(10).isEqualTo(items.get(0).quality);
        assertThat(0).isEqualTo(items.get(0).sellIn);
    }
/*
    @DisplayName("\"Backstage passes(백스테이지 입장권)\"는 \"Aged Brie\"와 유사하게 " +
        "SellIn 값에 가까워 질수록 Quality 값이 상승하고, 10일 부터는 매일 2 씩 증가하다, " +
        "5일 부터는이 되면 매일 3 씩 증가하지만, 콘서트 종료 후에는 0으로 떨어집니다.")
    @Test
    public void Backstage_passes는_SellIn_값에_가까워_질수록_Quality_값이_상승하고_10일_부터는_매일_2_씩_증가하다(){
        //given
        Item2 item = Item2.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(10)
            .build();
        Item2 item1 = Item2.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(5)
            .build();
        Item2 item2 = Item2.itemCreate()
            .name("Backstage passes to a TAFKAL80ETC concert")
            .quality(10)
            .sellIn(0)
            .build();

        List<Item2> items = new ArrayList<>();
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
    }*/
}
