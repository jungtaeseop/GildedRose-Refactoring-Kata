package com.gildedrose.supplierDynamicFactory;

public class MainDynamic {
        public static void main(String[] args) {

            DynamicSupplierFactory2.setResisterSupplier("SpecialItem", ConcreteProductC1::new);

            // Test the factory method with different types of items.
            String[] types = {"Aged Bire", "Sulfuras, Hand of Ragnaros","SpecialItem","Unknown"};

            for (String type : types) {
                Product2 product2 = DynamicSupplierFactory2.getProduct2(type);
                if (product2 != null) {
                    product2.message();
                } else {
                    System.out.println("No management strategy for type: " + type);
                }
            }

            // Test the factory method with an unknown item type.
            String unknownType = "Unknown_type";
            Product2 imUnknown = DynamicSupplierFactory2.getProduct2(unknownType);
            if (imUnknown != null) {
                imUnknown.message();
            } else {
                System.out.println("No management strategy for type: " + unknownType);
            }

        }
}
