package com.github.marcellodesales.advanced.nastedtypes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Useful for handlers
 * Can be create a lambda function
 */
public class AnnonymousClasses {

    public static void main(String[] args) {

        var names = Arrays.asList("joe", "susan", "john");

        // anonymous class has no constructor, all shadowing rules apply here
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });

        // The lambda function that compares instead of the anonymous class above
        // This is much better and simpler
        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);
    }
}
