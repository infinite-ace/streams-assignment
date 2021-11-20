package org.infinite.tap.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String name;
    private final Category category;
    private final double price;

    public Product(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public static List<Product> getAll() {

        Product product = new Product("Smartphone", Category.ELECTRONICS, 800.00);
        Product product1 = new Product("Bethooven stamp T-Shirt", Category.CLOTHES, 35.20);
        Product product2 = new Product("Picasso stamp T-Shirt", Category.CLOTHES, 45.20);
        Product product3 = new Product("Tribal stamp T-Shirt", Category.CLOTHES, 15.20);
        Product product4 = new Product("The Four Agreements: A Practical Guide to Personal Freedom", Category.BOOKS, 55.00);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        return products;
    }
}

