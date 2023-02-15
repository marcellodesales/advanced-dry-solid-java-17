package com.github.marcellodesales.advanced.generics.multipleparams;

import com.github.marcellodesales.util.Validator;

/**
 * The record now implements the interface hasId and hasName
 */
public record Product(long id, String name, String description) implements HasId, HasName {

    public Product {
        Validator.checkThatAndReturn(id, id > 0, "ID must be larger than 0");
        Validator.checkThatAndReturn(id, !name.isEmpty(), "Name must be provided");
        Validator.checkThatAndReturn(id, !description.isBlank(), "Descrition must be provided");
    }
}
