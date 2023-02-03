package main.java.com.github.marcellodesales.advanced.records.customer;

import java.time.LocalDateTime;

// Records are inpliccitly ifinal
// Records cannot extend classes, but can implemnt interfaces
// Common superclass is "java.lang.Record", which contains abstract methods for equals, hashCode, toString
public record Customer(long id, FamilyName familyName) {

    // prefer to use factory methods
    public static Customer makeNewCustomer(String firstName, String lastName) {
        return new Customer(0, new FamilyName(firstName, lastName));
    }
}
