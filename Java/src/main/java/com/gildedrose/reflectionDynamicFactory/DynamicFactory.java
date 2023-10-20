package com.gildedrose.reflectionDynamicFactory;

import java.lang.reflect.Constructor;

public class DynamicFactory {
    public static Product createProduct(String className) {
        try {
            Class<?> productClass = Class.forName(className);
            Constructor<?> constructor = productClass.getConstructor();
            return (Product) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
