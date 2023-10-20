package com.gildedrose.supplierDynamicFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DynamicSupplierFactory2 {

    protected static final String DEFAULT_VAULE = "BASIC";
    private static final Map<String, Supplier<? extends Product2>> resisterSupplier = new HashMap<>();

    static {
        resisterSupplier.put("Aged Bire",ConcreteProductA1::new);
        resisterSupplier.put("Sulfuras, Hand of Ragnaros",ConcreteProductB1::new);
    }

    public static void setResisterSupplier(String type, Supplier<? extends Product2> supplier) {
        resisterSupplier.put(type,supplier);
    }

    public static Product2 getProduct2(String type) {
        Supplier<? extends Product2> supplier = resisterSupplier.get(type);
        return supplier != null ?  supplier.get() : null;
    }
}
