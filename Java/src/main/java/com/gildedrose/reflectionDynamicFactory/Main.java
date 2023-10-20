package com.gildedrose.reflectionDynamicFactory;

public class Main {

    public static void main(String[] args) {
        Product productA = DynamicFactory.createProduct("com.gildedrose.dynamicFactory.ConcreteProductA");
        if (productA != null) {
            productA.create(); // Output: Creating Product A
        }

        Product productB = DynamicFactory.createProduct("com.gildedrose.dynamicFactory.ConcreteProductB");
        if (productB != null) {
            productB.create(); // Output: Creating Product B
        }
    }
}
