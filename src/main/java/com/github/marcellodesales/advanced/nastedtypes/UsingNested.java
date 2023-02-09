package com.github.marcellodesales.advanced.nastedtypes;

import static com.github.marcellodesales.advanced.nastedtypes.Enclosing.Nested;

public class UsingNested {

    public static void main(String[] args) {
        // regular
        var nested = new Nested();
        var nested2 = new Enclosing.Nested();
    }
}
