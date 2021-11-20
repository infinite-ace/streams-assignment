package org.infinite.tap.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;
    private final LocalDate orderDate;
    private final Status status;

    public Order(List<Product> products, LocalDate orderDate, Status status) {
        this.products = products;
        this.orderDate = orderDate;
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Status getStatus() {
        return status;
    }


    public static List<Order> getAll() {
        return new ArrayList<>();
    }
}

