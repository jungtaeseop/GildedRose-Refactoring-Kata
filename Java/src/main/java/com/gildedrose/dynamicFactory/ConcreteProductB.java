package com.gildedrose.dynamicFactory;

import lombok.NoArgsConstructor;

class ConcreteProductB implements Product {
    public void create() {
        System.out.println("Creating Product B");
    }

    public ConcreteProductB() {
    }
}
