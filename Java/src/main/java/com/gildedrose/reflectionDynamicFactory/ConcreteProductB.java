package com.gildedrose.reflectionDynamicFactory;

class ConcreteProductB implements Product {
    public void create() {
        System.out.println("Creating Product B");
    }

    public ConcreteProductB() {
    }
}
