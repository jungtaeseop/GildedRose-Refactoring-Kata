package com.gildedrose;

import java.util.List;

public class GildedRose2 {

    List<Item> items;

    public GildedRose2(List<Item> items){
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // Quality 값은 결코 음수 안됨 , 오류 값이 들어 오면 오류 추가
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {  // Aged Brie, Backstage 일때
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }
            //sulf 가 아닌 것들만 실행한다.
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            // sellIn 값이 0 들어와서 -1로 수정이되면 실행
            if (item.sellIn < 0) {
                // Aged Brie 아니면 참
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else { //Aged Brie 일 경우
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public void updateQuality_refecter() {
        for(Item item: items){

        }
    }

}
