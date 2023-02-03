package main.java.com.github.marcellodesales.advanced;

import main.java.com.github.marcellodesales.advanced.records.Customer;
import main.java.com.github.marcellodesales.advanced.records.Order;
import main.java.com.github.marcellodesales.advanced.records.OrderLine;
import main.java.com.github.marcellodesales.advanced.records.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Application {

    private static Product makeNewProduct() {
        // we can use the var for the object
        var computer = new Product(1, "computer", "Super awesome product");
        System.out.println("Created " + computer);
        return computer;
    }

    private static Customer makeNewCustomer() {
        var newCustomer = new Customer(23, "Marcello", "DeSales");
        var newCustomerLater = new Customer(23, "Marcello", "DeSales");
        if (newCustomer == newCustomerLater) {
            System.out.println("Customers points to the same object");
        }
        if (newCustomer.equals(newCustomerLater)) {
            System.out.println("Customers are the same per their values");
        }
        return newCustomer;
    }

    public static OrderLine newOrderLine() {
        return new OrderLine(makeNewProduct(), 4, new BigDecimal("5.43"));
    }

    public static Order makeNewOrder() {
        var orderLines = Arrays.asList(
                newOrderLine(),
                new OrderLine(new Product(4, "Monitor", "Wide"), 5,
                        new BigDecimal("548.33"))
        );
        var newOrder = new Order(120, LocalDateTime.now(), orderLines);
        System.out.println("Created the order: " + newOrder);
        return newOrder;
    }

    public static boolean isOrderIsImmutable(Order order) {
        var newOrder = makeNewOrder();
        try {
            System.out.println("We know we can't modify the list as it is immutable!");
            newOrder.lines().add(newOrderLine());
            return false;

        } catch(UnsupportedOperationException cantChangeList) {
            System.out.println("Indeed, we can modify the order");
            return true;
        }
    }

    public static void main(String[] args) {
        makeNewProduct();
        makeNewCustomer();
        var order = makeNewOrder();
        System.out.println("Order is immutable? " + isOrderIsImmutable(order));
    }
}
