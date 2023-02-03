package main.java.com.github.marcellodesales.advanced.records.customer;

import main.java.com.github.marcellodesales.advanced.util.Validator;

/**
 * Value objects just holds better object representation of immutable values.
 * It's more clear to define the params of this object with these values as tokens
 */
public record FamilyName(String firstName, String lastName) {

    public FamilyName {
        Validator.checkThatAndReturn(firstName, !firstName.isEmpty(), "First name must be provided");
        Validator.checkThatAndReturn(lastName, !lastName.isBlank(), "Last name must be provided");
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
     }
}
