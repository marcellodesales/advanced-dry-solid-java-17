package com.github.marcellodesales.advanced.lambda;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *         // java.util.function
 *
 *         // T -> Function<T, R> -> R = Takes one parameter and returns a type R
 *         // T -> Consumer<T>         = Takes a parameter but doesn't return a value (foreach method in collections)
 *         //      Supplier<T>    -> R = Takes no parameter but returns a type R   (factory methods)
 *
 *         // T, U ->  BiFunction< T, U, R> -> R = takes two parameters and returns R
 *         // T, U ->  BiConsumer<T, U>          = Takes parameters and don't return
 *
 *         // T -> Predicate<T>  -> Boolean      = filter operator in streams
 *         // T U -> BiPredicate<T, U>     -> R  = same thing, but two
 *         // T -> UnaryOperator<T>         -> T  = same time for input and return
 *         // TT BinaryOperator<T>          -> T = same for binary
 */

record Product(long id, String name, BigDecimal price) {}

public class StandardFunctionalInterfaces {

    static void print(List<String> names) {
        // lambda expression define an anonymous method on the spot
        names.forEach(name -> System.out.println(name));

        // method reference implements an interface, pointing to an existing method
        names.forEach(System.out::println);

        // statuc netgid reference using "::"

        // TypeName::staticMethod       -> for static methods
        // objectRef::instanceMethod    -> reference of an instance of an object
        // TypeName::instanceMethod     -> reference to an instance method, context determines the obj
        // TypeName::new                -> reference to a constructor
    }

    static void writeToFile(List<String> names)  {
        try (FileWriter out = new FileWriter("/tmp/names.txt")) {
            for (var name : names) {
                out.write(name);
            }
            // lambda expressions that has methods that throws exceptions must add try-catch
            names.forEach(name -> {
                try {
                    out.write(name + "\n");

                } catch (IOException e) {
                    // when inside the lambda, throw runtime exception, as sneaky throw
                    throw new RuntimeException(e.getMessage());
                }
            });

        } catch (IOException | RuntimeException e) {
            System.err.println("Can't write: " + e.getMessage());
        }
    }

    static List<Product> makeListOfExpensiveProds() {
        return List.of(
                new Product(1L, "apple", new BigDecimal("2.34")),
                new Product(1L, "cheese", new BigDecimal("40.20")),
                new Product(1L, "wine", new BigDecimal("9.23"))
        ).stream().filter(StandardFunctionalInterfaces::isExpensive).toList();
    }

    static boolean isExpensive(Product p) {
        return p.price().compareTo(new BigDecimal("4.0")) >= 0;
    }

    public static void main(String[] args) {
        var names = List.of("Leandro", "Thiago");
        var result1 = new ArrayList<>();
        for (var n : names) {
            result1.add(n.toUpperCase());
        }

        // now we can use another variationv
        var result2 = new ArrayList<>();
        names.forEach(name -> result2.add(name.toUpperCase())); // lambda expression with a side effect

        // Using streams to define functions, but with single execution
        var result3 = names.stream().map(name -> name.toUpperCase()).toList();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        var expensiveProducts = makeListOfExpensiveProds();
        expensiveProducts.forEach(System.out::println);

        // using the type to get the price
        var totalPrice = expensiveProducts.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add); //
        System.out.println("total: " + totalPrice);

        var productNames = expensiveProducts.stream()
                .map(Product::name)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("prods: " + productNames);

        // no side effects in principles of unctional programming
        // working with checked exceptions
        // method references
    }

}