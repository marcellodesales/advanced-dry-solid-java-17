package com.github.marcellodesales;

import com.github.marcellodesales.advanced.algebricdatatype.*;
import com.github.marcellodesales.advanced.records.Product;

import java.math.BigDecimal;
import java.util.Arrays;

public class AlgebricDataTypesDriver {

    public static BigDecimal calculateTotalAmount(AlgebricOrder order) {
        BigDecimal total = BigDecimal.ZERO;
        for (SealedOrderLine orderLine : order.orderLines()) {
            // Pattern variables for the instanceof methods
            // https://docs.oracle.com/en/java/javase/17/language/pattern-matching-instanceof-operator.html#:~:text=The%20pattern%20variables%20are%20those,Rectangle%20r%20and%20Circle%20c%20.
            if (orderLine instanceof SaleOrderLine orderLineInstance) {
                total = total.add(orderLineInstance.amount().multiply(new BigDecimal(orderLineInstance.quantity())));
            }
            if (orderLine instanceof DiscountOrderLine discountOrderLine) {
                total = total.subtract(discountOrderLine.amount());
            }
        }
        return total;
    }

    public static Double calculateAmount(AlgebricOrder order) {
        var total = 0d;
        for (SealedOrderLine orderLine : order.orderLines()) {
            // https://docs.oracle.com/en/java/javase/17/language/pattern-matching-switch-expressions-and-statements.html
            // ATTENTION: You must accept the terms of legal notice of the beta Java specification to enable support
            // for "17 (Preview) - Pattern matching for switch".
            total += switch (orderLine) {
                case SaleOrderLine s -> s.quantity() * s.amount().doubleValue();
                case DiscountOrderLine d -> d.amount().doubleValue() * -1;
            };
        }
        return total;
    }

    public static void main(String[] args) {

        var monitor = Product.builder()
                .withId(10)
                .withName("Samsumg GSync")
                .withDescription("Wide-screen")
                .build();

        var myOrder = new AlgebricOrder(Arrays.asList(
           new SaleOrderLine(monitor, 3, new BigDecimal("300.00")),
                new DiscountOrderLine(DiscountCode.WELCOME_DISCOUNT, new BigDecimal("30.00"))
        ));

        System.out.println("Total value of order: " + calculateTotalAmount(myOrder));
        System.out.println("Total from switch: " + calculateAmount(myOrder));
    }
}
