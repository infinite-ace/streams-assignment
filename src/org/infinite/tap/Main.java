package org.infinite.tap;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
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
                 .map(Customer::getName) // same as .map(customer -> customer.getName())
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
        long countClothes = Order.getAll()
                .stream()
                /* Logical explanation: Having the stream of all orders */
                /* we then use the mapToLong method to give us: */
                /* 1. We need a starting point, so we retrieve all orders as usual.  */
                /* 2. We get all products inside each order, using the filter on line 99 */
                .mapToLong(o ->
                        o.getProducts()
                        .stream()
                        .filter(p -> p.getCategory() == Category.CLOTHES)
                        .count())
                /* 3. We use the count method to count each product and keep it */
                /* 4. At this point mapToLong is a LongStream containing all elements. */
                .sum();
                /* 5. Finally we sum the elements */

        System.out.println("======= Task 6 solution: Count all clothes ordered =======");
        System.out.println(countClothes);
        // 7. Find if we have a tier 3 customer named "George"
        boolean hasGeorge = Customer.getAll()
                .stream()
                .anyMatch(customer ->
                            customer.getTier() == 3 &&
                                customer.getName().endsWith("George")
                );

        System.out.println("======= Task 7 solution: Do we have a Tier 3 customer named George? =======");
        System.out.println(hasGeorge ? "We do have a Tier 3 George" : "Nope, we could not find Tier 3 George");

        // 8. Find if all orders from September are delivered
        boolean areAllDelivered = Order.getAll()
                .stream()
                .allMatch(order -> order.getOrderDate().getMonth() == Month.SEPTEMBER &&
                        order.getStatus() == Status.DELIVERED);

        System.out.println("======= Task 8 solution: Do all orders from september have a status of Delivered? =======");
        System.out.println(areAllDelivered ? "All orders are delivered" : "Not all orders are delivered");

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
