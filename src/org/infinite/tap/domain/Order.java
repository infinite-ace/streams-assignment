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

    public void printOrderInfo() {
        System.out.println(
                "Order date: " + this.orderDate.toString() + "\n" +
                "Products in order: " + this.products.size() + "\n" +
                "Order status: " + this.status  + "\n"
        );
    }


    public static List<Order> getAll() {

        Order order = new Order(Product.getAll(), LocalDate.of(2021, 3, 22), Status.DELIVERED);
        Order order1 = new Order(Product.getAll(), LocalDate.of(2021, 11, 15), Status.PENDING);
        Order order2 = new Order(Product.getAll(), LocalDate.of(2021, 3, 22),  Status.CANCELED);
        Order order3 = new Order(Product.getAll(), LocalDate.of(2021, 3, 1),  Status.DELIVERED);
        Order order4 = new Order(Product.getAll(), LocalDate.of(2021, 3, 2),  Status.DELIVERED);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);

        return orders;
    }
}

