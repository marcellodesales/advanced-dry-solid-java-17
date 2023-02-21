package com.github.marcellodesales.advanced.optionals;

import com.github.marcellodesales.advanced.records.customer.Customer;
import com.github.marcellodesales.advanced.records.customer.FamilyName;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * NullPointerException occurs when you dereference a null value
 * Billion-dollar mistake to invent null reference in 1965.
 *
 * Optional is container can be either contain value or empty
 * - It is an immutable value class, dont use as a synchronization
 * - Designed as return type for methods.
 * - It is not serializable
 *
 * Can be used as streams.
 */
public class Optionals {

    /**
     * @param val
     * @return the return is expected to be a customer, but it might also come as null
     */
    public static Customer getCustomer(long val) {
        return (val > 0) ? null : null;
    }

    /**
     * @param name
     * @return It's explicit that there might be a customer or empty
     */
    public static Optional<Customer> getCustomer(String name) {
        return name.equals("Marcello")
                ? Optional.of(new Customer(1, new FamilyName("marcello", "desales")))
                : Optional.empty();
    }

    public static void main(String[] args) {
        Optional<Customer> marcelloOptional = getCustomer("marcello");
        if (marcelloOptional.isPresent()) {
            var marcello = marcelloOptional.get();
            System.out.println("Found marcello: " + marcello);
        }

        // define the other value with orElse
        Customer other = marcelloOptional.orElse(null);

        // Use a supplier function to call another method (this fixes the above)
        other = marcelloOptional.orElseGet(() -> getCustomer("Marcello").get());

        System.out.println(other);

        // Now, we can use with functional
        marcelloOptional = getCustomer("Marcello");
        marcelloOptional.ifPresent(customer -> System.out.println("Found it here: " + customer));

        // methods to transform from the optional as well.
        String text = marcelloOptional.map(Customer::toString).orElse("Customer not found");
        System.out.println(text);

        // Optional stream() can be used for flatMap to simplify the filtering of values
    }

}
