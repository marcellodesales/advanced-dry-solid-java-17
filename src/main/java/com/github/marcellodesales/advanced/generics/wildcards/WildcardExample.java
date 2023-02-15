package com.github.marcellodesales.advanced.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardExample {

    /**
     * * Upper bound parameter using "extends" is useful for input parameters
     * * Lower bound parameter using "super" is useful for output parameters which receives the parameters
     *
     * @param source
     * @param destination
     * @param <T>
     */
    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    /**
     * The parameters with unbounded wildcard can be used for any type of list does not need to know the type
     * @param list
     * @return
     */
    public static int size(List<?> list) {
        return list.size();
    }

    public static void main(String[] args) {
        var dogs = Arrays.asList(new Dog("chiawa"), new Dog("Fila"));
        var cats = new ArrayList<Animal>();
        cats.add(new Cat("Siamese"));
        copy(dogs, cats);

        System.out.println(cats);
        System.out.println(size(cats));
    }
}
