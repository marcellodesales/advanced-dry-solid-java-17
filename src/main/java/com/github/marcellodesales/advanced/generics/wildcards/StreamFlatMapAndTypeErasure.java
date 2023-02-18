package com.github.marcellodesales.advanced.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapAndTypeErasure {

    /**
     * In this example, we have a list of lists, where each inner list contains a set of integers. We want to flatten
     * this list of lists into a single list of integers.
     *
     * To achieve this, we first create a Stream of List<Integer> using listOfLists.stream(). We then use flatMap()
     * to flatten this stream of lists into a stream of integers.
     *
     * The lambda expression list -> list.stream() passed to flatMap() specifies that for each list in the stream,
     * we want to create a new stream of its elements. The flatMap() method then combines all of these individual
     * streams into a single flattened stream of integers.
     *
     * Finally, we use the collect() method to convert the flattened stream into a list using the
     * Collectors.toList() method. Consider T as a list of lists...
     *
     * INPUT STREAM -------- (T1) ---(T2)-----------
     *     MAPPER FUNCTION                    <---- mapper will flatten the results into the output stream flattened
     * OUTPUT STREAM ----(R1)-(R1)---(R2)-(R2)-(R2)----
     *
     * The output of the above code will be:
     *
     * Examples of these are in
     * * class java.util.Collections and class java.util.stream.Collectors
     * * interface java.util.Comparator and interface java.util.stream.Stream
     * @param args
     */
    public static void main(String[] args) {
        // In this example, T is the list of lists and R are each of the elements
        // Streams are One-to-many transformation of a stream T into a stream of R
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // <R> Stream<R> flatMap(Functio<? super T>, ? extends Stream<? extends R>> mapper);
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream()) // .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList);

        // Type erasure in generics is how the compiler deals with the type checking
        // At runtime does nothing. So, Generics are a compile-time only feature. For generic and parameterized types,
        // type paramters and type arguments do not exist at runtime.
        // Type parameters are replaced by Object or the leftmost bound.
        // Type arguments are discarded.
        // Parameterized types are replaced by Raw types
        // Type casts are placed where necessary

        // For instance, type erasure will remove the parameters and use the raw objects
        // The compiler re-writes the code as if the code were written without generics
        interface TreeNode {
            Object getValue();
            TreeNode getLeft();
            TreeNode getRight();
        }

        // with type erasure, if interface ComparableTreeNode<T extends Comparable> {}, it uses the leftmost param
        interface ComparableTreeNode {
            Comparable getValue();
            ComparableTreeNode getLeft();
            ComparableTreeNode getRight();
        }

        // LIMITATIONS or Type erasure
        // 1. you cannot use primitive types as type arguments because primitive types are not objects
        // 2. we cannot create new types, as there's no new T(), but we can create using reflection.
        // 3. instanceof doesn't work with non-reifiable types
        // obj instance List<String> can't be used because re-reifiale
        // no class literals for parameters types
        // Class<?> cls = List<String>.class // error!
        // unchecked warnings
        // Cannot overload methods with the same method signature after type erasure
        // void print(List<String> strings) and void print(List<Integer> ints) because
        // void print(List strings) and void print(List ints) will be the result of the erasure

        // Heap pollution with the type you are casting doesn't contain what you need

        List dogs = new ArrayList<>();
        dogs.add(new Dog("days"));
        dogs.add(new Dog("day1s"));

        // this is ok
        List<Cat> cats = dogs;
        Cat cat = cats.get(0); // ClassCastException is heap pollution

        List<? extends Animal> animals = dogs;
        List<Dog> dogsAgain = (List<Dog>)animals; // casting to a non-reifiable type "unchecked warning
        List<Cat> catsAgain = (List<Cat>)animals; // "unchecked" earning and heap pollution


    }
}
