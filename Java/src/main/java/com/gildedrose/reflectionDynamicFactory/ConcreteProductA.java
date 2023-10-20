package com.gildedrose.reflectionDynamicFactory;


class ConcreteProductA implements Product {
    public void create() {
        System.out.println("Creating Product A");
    }

    public ConcreteProductA() {
    }
}
