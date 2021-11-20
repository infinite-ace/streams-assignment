package org.infinite.tap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.infinite.tap.domain.*;

public class Main {

    public static void main(String[] args) {

        /*      Mock data    */
        Customer customer = new Customer("Bobby", 9);
        Customer customer1 = new Customer("Michael", 2);
        Customer customer2 = new Customer("Zohan", 3);
        Customer customer3 = new Customer("George", 123);
        Customer customer4 = new Customer("Valyo", 700);

        Product product = new Product("Smartphone", Category.ELECTRONICS, 800.00);
        Product product1 = new Product("Bethooven stamp T-Shirt", Category.CLOTHES, 35.20);
        Product product2 = new Product("Picasso stamp T-Shirt", Category.CLOTHES, 45.20);
        Product product3 = new Product("Tribal stamp T-Shirt", Category.CLOTHES, 15.20);
        Product product4 = new Product("The Four Agreements: A Practical Guide to Personal Freedom", Category.BOOKS, 55.00);

        List<Product> productArrayList = new ArrayList<>();
        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);

        List<Product> productArrayList1 = new ArrayList<>();
        productArrayList1.add(product);

        List<Product> productArrayList2 = new ArrayList<>();
        productArrayList2.add(product4);

        Order order1 = new Order(productArrayList, LocalDate.now(), Status.PENDING);
        Order order2 = new Order(productArrayList1, LocalDate.now(), Status.CANCELED);
        Order order3 = new Order(productArrayList2, LocalDate.now(), Status.DELIVERED);
        Order order4 = new Order(productArrayList1, LocalDate.now(), Status.DELIVERED);

        List<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);
        allOrders.add(order3);
        allOrders.add(order4);

        // 1. Refactor with Streams
        /*
        List<Customer> secondTierCustomer = new ArrayList<>();
        Iterator<Customer> iterator = Customer.getAll().iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getTier() == 2) {
                secondTierCustomer.add(customer);
            }
        }
        */

        List<Customer> secondTierCustomerList = new ArrayList<>();
        List<Customer> filteredList = new ArrayList<>();

        secondTierCustomerList.add(customer1);
        secondTierCustomerList.add(customer2);
        secondTierCustomerList.add(customer3);
        secondTierCustomerList.add(customer4);

        secondTierCustomerList.stream()
                .filter( c -> c.getTier() == 2)
                .map(c -> filteredList.add(c))
                .collect(Collectors.toList());


        /* Test */
        System.out.println("Task 1 solution: Filtered Objects : " + filteredList.size());

        // 2. Find all canceled orders
        // List<Order> canceledOrders = ...

        List<Order> cancelledOrders = new ArrayList<>();
        cancelledOrders.stream()
                .filter(order -> order.getStatus() == Status.CANCELED)
                .collect(Collectors.toList());

        // 3. Find all pending orders created on Monday
        // List<Order> pendingOrders = ...

//        List<Order> pendingOrders = allOrders.stream()
                // solution:

                // filter by the enum and



        // 4. Find the names of all tier 1 customers
        // List<String> tier1Names = ...


//                .filter( c -> c.getTier() == 1 )
//


        // 5. Find the sum of all TOYS products prices
        // double toysSum = ...

        // 6. Find how many clothes have been ordered
        // long countClothes = ...

        // 7. Find if we have a tier 3 customer named "George"
        // boolean hasGeorge = ...

        //two filters

        // 8. Find if all orders from September are delivered
        // boolean areAllDelivered = ...

        // 9. Find the category of the max priced product that have ever been ordered
        // Category category = ...

        // 10. Sum the prices in each category of products
        // Map<Category, Double> pricesSum = ...

        // 11. Count all the products with map and reduce operations only
        // Integer productCount = ...

        // 12. For given number n generate a list of square of each number in [1..n]

        // 13. Generate 10 random numbers
//        create list


        // 14. Find all orders containing any electronics
        // List<Order> ordersWithElectronics = ...

        // 15. Implement a collector that concatenates String - StringJoiner implements Collector
        // String names = Customer.getAll().collect(new StringJoiner());





    }
}
