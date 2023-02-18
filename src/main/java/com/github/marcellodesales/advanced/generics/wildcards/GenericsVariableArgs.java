package com.github.marcellodesales.advanced.generics.wildcards;

import java.util.HashMap;
import java.util.Map;

record Pair<T, U>(T first, U second) {}

public class GenericsVariableArgs {

    /**
     * Default definition of arrays in varargs
     * @param lines
     */
    static void printLines(String ... lines) {
        for (var line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        printLines("Marcello", "Leandro", "Thiago");
        printLines(new String[]{ "Marcello", "Leandro", "Thiago" });

        var map = new HashMap<Integer, String>();
        putInMap(map, new Pair<>(1, "one"), new Pair<>(2, "two"));
    }

    /**
     * The pattern of the maps and the values
     * This can lead to heap pollution from parameterized vararg type Pairs
     * @param map
     * @param pairs
     * @param <T>
     * @param <U>
     */
    @SafeVarargs // ask the compiler to not check the varargs
    static <T, U> void putInMap(Map<? super T, ? super U> map, Pair<? extends T, ? extends U> ... pairs) {
        // pairs is non-reifiable values
        // arrays are covariant as it allows values to be added
        //
        for (var pair : pairs) {
            map.put(pair.first(), pair.second());
        }
    }
}
