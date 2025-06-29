package com.leon;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

// Given a list of products with categories, group them into a Map<String, List<Product>> by category.
public class CategoryMap {
    private record Product(String productName, String category, Double price) {};

    public static void main(String... args)
    {
        List<Product> products = Arrays.asList(new Product("Rubik cube", "toy", 10.5), new Product("Bike", "toy", 5.5), new Product("Air rifle", "toy", 121.2), new Product("cake", "food", 5.1), new Product("cookie", "food", 2.1));
        Map<String, List<String>> map = products.stream().collect(Collectors.groupingBy(Product::category, Collectors.mapping(Product:: productName, Collectors.toList())));
        map.forEach((key, value) -> System.out.println("category: " + key + " has products: " + value));

        // Given a list of Product(name, category, price), determine the most expensive product per category.
        Map<String, Optional<Product>> mostExpensivePerCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.maxBy(Comparator.comparingDouble(Product::price))));

        mostExpensivePerCategory.forEach((cat, prod) -> System.out.println(cat + " -> " + prod.map(Product::productName).orElse("None")));
    }
}
