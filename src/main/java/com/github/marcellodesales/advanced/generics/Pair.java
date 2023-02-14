package com.github.marcellodesales.advanced.generics;

import java.util.function.BiFunction;

/**
 * Generic types can using single capital letter names for type parameters
 * are widely accepted convention
 * You can not use primitive types as type arguments
 * Anonymous inner classes, enums and exception classes cannot have type parameters
 *
 * Generic Data Structures
 * Code Reuse
 *
 * @param <T>
 * @param <U>
 */
public record Pair<T, U>(T first, U second) {

    /**
     * Static instance can't get access to T and U, and so, they must be different.
     * For this reason, we need to use a different type parameter V and W.
     * @return the instance of pair of type T and U.
     */
    public static <V, W> Pair<V, W> of(V first, W second) {
        return new Pair<>(first, second);
    }

    public Pair<T, U> withFirst(T newFirst) {
        return Pair.<T, U>of(newFirst, this.second);
    }

    public Pair<T, U> withSecond(U newSecond) {
        return Pair.<T, U>of(this.first, newSecond);
    }

    /**
     * @param <V>
     * @param <W>
     * @return BiFunction is a generic function that takes 2 parameters and returns a value
     */
    public <V, W> Pair<V, W> map(BiFunction<T, U, Pair<V, W>> func) {
        // since it's an instance method, just add the values as they are mapped to the BiFunction params T and U
        return func.apply(this.first, this.second);
    }

    public static void main(String[] args) {
        var pair = Pair.<Integer, String>of(1, "first");

        // Type inference without <>
        var sec = Pair.of(2, "second");

        // bifunction just maps
        var rev = sec.map((left, right) -> Pair.of(right, left));
        //var same = sec.<Integer, String>map((Integer left, String right) -> Pair.<String, Integer>of(right, left));
        System.out.println(rev);

        var newPair = Pair.<Long, Pair<String, String>>of(1L, Pair.of("Marcello", "DeSales"));
        System.out.println(newPair);

        // More of a functional language paradigm
        newPair = newPair
                .withFirst(2L)
                .withSecond(Pair.of("Leandro", "de Sales"));
        System.out.println(newPair);

    }
}
