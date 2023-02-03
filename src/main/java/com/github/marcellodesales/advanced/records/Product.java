package main.java.com.github.marcellodesales.advanced.records;

import main.java.com.github.marcellodesales.advanced.records.customer.FamilyName;

/**
 * String
 * BitInteger, BigDecimal
 * Wrapper classes for primitive types (Integer, Long)
 * Date and time classes in the package java.time
 *
 * * Immutability makes programs less complicated
 * * Immutable objects are thread-safe, don't need synchornization because they are already
 * * Collections such as HashMap and HashSet expect immutability for keys so it doesn't produce unexpected results if hashCode value changes
 * * Immutable objects can be safely shared and reused (String pool reuses, Autoboxing for numbers)
 *
 * Strings created by a loop are problems because each iteraction of the loop creates a new instance of the string in the String pool.
 * New strings and copies. That's why using StringBuilder is used.
 *
 * It avoids creating circular references and immutability avoids designing classes with circular references bc chicken-egg problem rises.
 *
 * Constructor is called "Canonical Constructor", initializes the records to have its own. Make defensive and validation
 */
public record Product(long id, String name, String description) {

    // the compiler translates this to the Java Immutable class Pattern: final class, private final encapsulation of
    // properties, constructor params, just getters,
    // hashCode and equals implementation and toString.

    // Records accessor methods does NOT use java beans, instead uses methods with the name of the properties.
    // public long id() { return this.id };
    // public String name() { return this.name; }

    // New instance fields are NOT allowed
    // static fields are allowed
    private final static String PREFIX = "PRDCT";
    private static final Long START_INDEX = 1000L;
    private final static String SIGNATURE_SPLITTER = "-";

    /**
     * Make sure to never change the value because of copies
     * @return Overridden id with the prefix
     */
    @Override
    public long id() {
        return START_INDEX + this.id;
    }

    /**
     * Methods are allowed as well
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(PREFIX);
        builder.append(this.id());
        builder.append(SIGNATURE_SPLITTER);
        builder.append(this.name);
        builder.append(SIGNATURE_SPLITTER);
        builder.append(this.description);
        return builder.toString();
    }

    /**
     * TODO: We can use Lombok for these:
     * @return an instance of the builder method as a fluid API
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Fluid API for the Product
     */
    public static class Builder {
        private long id;
        private String name;
        private String description;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.name, this.description);
        }
    }
}
