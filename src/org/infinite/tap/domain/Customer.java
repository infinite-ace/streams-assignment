package org.infinite.tap.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final int tier;

    public Customer(String name, int tier) {
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    public static List<Customer> getAll() {

        Customer customer = new Customer("Bobby", 9);
        Customer customer1 = new Customer("Michael", 2);
        Customer customer2 = new Customer("Zohan", 3);
        Customer customer3 = new Customer("George", 1);
        Customer customer4 = new Customer("Valyo", 700);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        return customers;
    }
}
