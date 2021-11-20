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

    public static List<Product> getFirstList() {

        //TODO: That introduces so many duplicates, which makes my code ugly. I am wondering how to improve this?
        Product product1 = new Product("Bethooven stamp T-Shirt", Category.CLOTHES, 35.20);
        Product product2 = new Product("Picasso stamp T-Shirt", Category.CLOTHES, 45.20);
        Product product3 = new Product("Tribal stamp T-Shirt", Category.CLOTHES, 15.20);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }

    public static List<Product> getSecondList() {

        Product product = new Product("Smartphone", Category.ELECTRONICS, 800.00);

        List<Product> products = new ArrayList<>();
        products.add(product);

        return products;

    }

    public static List<Product> getThirdList() {

        Product product1 = new Product("Bethooven stamp T-Shirt", Category.CLOTHES, 35.20);

        List<Product> products = new ArrayList<>();
        products.add(product1);

        return products;

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
        Product product5 = new Product("Batman toy", Category.TOYS, 23.99);
        Product product6 = new Product("Lego Technics Set - Oldsmobile and Electric engine", Category.TOYS, 150.00);
        Product product7 = new Product("Barbie & Ken Toy Set", Category.TOYS, 48.00);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);

        return products;
    }
}

