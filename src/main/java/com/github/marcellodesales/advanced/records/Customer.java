package main.java.com.github.marcellodesales.advanced.records;

import java.time.LocalDateTime;

// Records are inpliccitly ifinal
// Records cannot extend classes, but can implemnt interfaces
// Common superclass is "java.lang.Record", which contains abstract methods for equals, hashCode, toString
public record Customer(long id, String firstName, String lastName) {

    // prefer to use factory methods
    public static Customer makeNewCustomer(String firstName, String lastName) {
        return new Customer(0, firstName + LocalDateTime.now(), lastName);
    }
}
