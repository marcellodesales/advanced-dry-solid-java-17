package com.github.marcellodesales.advanced.nastedtypes;

import java.math.BigDecimal;

/**
 * Define a common contract for implementing classes
 * Abstract class  provide a way to share implementation of code
 */
public interface InterfaceType {

    // this class is static by default
    class InnerStaticDefault {

    }

    BigDecimal calculatePrice();

    // private method can be now reused in Interfaces to support the default methods
    private BigDecimal calculate() {
        return BigDecimal.ONE;
    }

    // the default implementation of a method can now be defined with a default
    // This makes interfaces look like an abstract class where implementation can exist
    default BigDecimal calculateDiscount() {
        return BigDecimal.ZERO.add(calculate());
    }
}
