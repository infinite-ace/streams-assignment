package org.infinite.tap;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.infinite.tap.domain.*;

public class Main {

    public static void main(String[] args) {

        List<Product> productArrayList = Product.getFirstList();
        List<Product> productArrayList1 = Product.getSecondList();
        List<Product> productArrayList2 = Product.getThirdList();

        /* End mock data phase */

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

        List<Customer> secondTierCustomerList = Customer.getAll();
        List<Customer> filteredList = new ArrayList<>();

        secondTierCustomerList.stream()
                .filter( c -> c.getTier() == 2)
                .map(c -> filteredList.add(c))
                .collect(Collectors.toList());

        System.out.println(
                "======= Task 1 solution: Filtered & mapped Objects ======="
                + '\n'
                + filteredList.size()
                + '\n'
        );

        // 2. Find all canceled orders
        List<Order> cancelledOrders = Order.getAll()
                .stream()
                .filter(order -> order.getStatus() == Status.CANCELED)
                .collect(Collectors.toList());

        System.out.println("======= Task 2: Cancelled orders =======");
        for (Order order : cancelledOrders) {
            order.printOrderInfo();
        }

        // 3. Find all pending orders created on Monday
        List<Order> orders = Order.getAll();

        List<Order> pendingOrders = orders.stream()
                .filter(o -> o.getStatus() == Status.PENDING)
                .filter(o -> o.getOrderDate().getDayOfWeek() == DayOfWeek.MONDAY)
                .collect(Collectors.toList());

        System.out.println("======= Task 3: Pending orders created on Monday =======");
        for (Order order : pendingOrders) {
            order.printOrderInfo();
        }

        // 4. Find the names of all tier 1 customers
         List<String> tier1Names = Customer.getAll().stream()
                 .filter( c -> c.getTier() == 1 )
                 .map(Customer::getName)
                 .collect(Collectors.toList());

        System.out.println("======= Task 4 solution: tier 1 names filter & map =======");
        System.out.println(tier1Names);

        // 5. Find the sum of all TOYS products prices
         double toysSum = Product.getAll()
                 .stream()
                 .filter(p -> p.getCategory() == Category.TOYS)
                 .mapToDouble(Product::getPrice)
                 .sum();
        System.out.println("======= Task 5 solution: Sum of all toys prices is =======");
        System.out.println(toysSum);

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
