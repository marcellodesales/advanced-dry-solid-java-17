package main.java.com.github.marcellodesales.advanced.records;

import java.time.LocalDateTime;

// Records are inpliccitly ifinal
// Records cannot extend classes, but can implemnt interfaces
// Common superclass is "java.lang.Record", which contains abstract methods for equals, hashCode, toString
public record CustomerRecord(long id, String firstName, String lastName) {

    // prefer to use factory methods
    public static CustomerRecord makeNewCustomer(String firstName, String lastName) {
        return new CustomerRecord(0, firstName + LocalDateTime.now(), lastName);
    }
}
