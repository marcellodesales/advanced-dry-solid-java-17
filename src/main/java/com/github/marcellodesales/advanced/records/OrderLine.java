package com.github.marcellodesales.advanced.records;

import com.github.marcellodesales.util.Validator;

import java.math.BigDecimal;

public record OrderLine(Product product, int quantity, BigDecimal price) {

    /**
     * Compact constructor without repeating the parameters.
     * We can't assign the values as the compiler will place these assignments.
     * Any modification to the paramers is allowed.
     * @param product
     * @param quantity
     * @param price
     */
    public OrderLine {
        Validator.checkThatAndReturn(product, product != null, "Product must be provided");
        Validator.checkThatAndReturn(quantity, quantity > 0, "We need a quantity");
    }

    /**
     * Overridden compact constructor when the product is for free :) 0.0
     * @param product
     * @param quantity
     */
    public OrderLine(Product product, int quantity) {
        // this call must be called as the first call in the constructor.
        this(product, quantity, new BigDecimal("0.0"));
    }
}

