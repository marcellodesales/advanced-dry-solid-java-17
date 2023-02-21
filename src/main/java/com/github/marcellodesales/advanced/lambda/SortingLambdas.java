package com.github.marcellodesales.advanced.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingLambdas {

    public static void main(String[] args) {
        // List.of is immutable list, so create the arraylist to be mutable with sort.
        var names = new ArrayList<>(List.of("Joe", "Susan", "John"));

        // 6 lines of code to write the anonymous method
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length()); // this is the only thing that matters in the code
            }
        });

        // easier to read code without plumming code
        // lambda functions are anonymous methods, allowing functional expressions
        names.sort((first, second) -> Integer.compare(first.length(), second.length()));

        // to re-write the compare function above
//        (String first, String second) -> {
//            return Integer.compare(first.length(), second.length());
//        };

        // types of the functional parameters are optional
        // (first, second) -> {
//            return Integer.compare(first.length(), second.length());
//        };

        // can specify var, but it doesn't have much value
        // (var first, var second) -> {
//            return Integer.compare(first.length(), second.length());
//        };

        // () -> empty parameter
        // name -> single parameter can remove the braces

        // Body as a bllock can use { }, but it can be removed when a single expression is used
        // (first, second) -> Integer.compare(first.length(), second.length())

        // Lambda expressions always implements a functional interface
        // Use @FunctionalInterface is used to indicate an interface type declaration.
        // java.lang.FunctionalInteface from module java.base

        // (first, second) -> Integer.compare(first.length(), second.length())
        // this implemnts Comparator<T> {  int compare(T 01, T 02) }

        // ERROR below
        //var comparator = (String 01, String 02) -> Integer.compare(01.length(), 02.length());
        System.out.println(names);
    }
}
