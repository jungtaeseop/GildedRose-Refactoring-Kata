package com.gildedrose.gildedDynamicFectory_v2.context;

import com.gildedrose.gildedDynamicFectory_v2.Management.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DynamicSupplierFactory {

    private static final String BASIC_DEFAULT_VALUE= "basic";
    private static final Map<String, Supplier<? extends InventoryManagement>> resisterSupplier = new HashMap<>();

    static {
        resisterSupplier.put("Aged Brie", AgedBrieInventoryManagement::new);
        resisterSupplier.put("Sulfuras, Hand of Ragnaros", SulfurasInventoryManagement::new);
        resisterSupplier.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassesInventoryManagement::new);
        resisterSupplier.put(BASIC_DEFAULT_VALUE, BasicInventoryManagement::new);
    }

    public static void resisterSupplier(String type, Supplier<? extends InventoryManagement> supplier) {
        resisterSupplier.put(type,supplier);
    }

    public static InventoryManagement getInventoryManagement(String type) {
        Supplier<? extends InventoryManagement> supplier = resisterSupplier.get(type);
        return supplier!= null ? supplier.get() : resisterSupplier.get(BASIC_DEFAULT_VALUE).get();
    }
}
