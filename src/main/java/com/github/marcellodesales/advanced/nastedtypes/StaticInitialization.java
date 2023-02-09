package com.github.marcellodesales.advanced.nastedtypes;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

final public class StaticInitialization {



    private static final Properties CONFIG = new Properties();

    // Multiple static blocks can be defined and they are executed in the order they were defined...
    static {
        try {
            System.out.println("Loading the config...");
            CONFIG.load(StaticInitialization.class.getClassLoader().getResourceAsStream("/example.properties"));

        } catch (IOException e) {
            System.out.println("Can't load the config...: " + e.getMessage());
            throw new IllegalStateException("Can't find config file...");

        } catch (Exception otherError) {
            System.out.println("Other error: " + otherError.getMessage());
        }
    }

    static {
        System.out.println("Can we execute?");
    }

    private class Product {

    }

    public static void readFile() throws IOException {
        throw new IOException("IOException");
    }

    public static String tryToReadFile() throws IOException {
        try {
            readFile();
            return "try";
        } catch (IOException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Does it initialize?");
        System.out.println(StaticInitialization.CONFIG);
        int max = 2147483647;
        System.out.println(max + 1);

        String result = tryToReadFile();
        System.out.println("result = " + result);

        char c1 = 'A';
        float f = c1 + 0.9f;
        char c2 = (char)f;
        System.out.println(c2);


        Stream<Stream<String>> stream =
                Stream.of(Stream.empty(),
                        Stream.of("one", "four"),
                        Stream.of("three"),
                        Stream.of(""));
        Stream<Optional<String>> optionalStream =
                stream.map(str -> str.max(Comparator.comparing(String::length)));


        int[] tab = {1, 2, 3, 4};

        int loop = 0;
        for (int i : tab) {
            loop++;
            if (i > 2)
                break;
            loop++;
        }
        System.out.println("loop = " + loop);

        List<String> list = Arrays.asList("Foo ", "bar ", "Foo ", "Bar ");
        Stream<String> stream2 = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct();
        stream2.forEach(System.out::print);

        int score = 70;
        switch (score) {
            case 70:
                System.out.println("Great score!");
            case 50:
                System.out.println("Pass score");
            default:
                System.out.println("Unknown score");
        }

        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = isEven.negate();

        Parent p = new Parent();
        Parent c = new Child();
        System.out.println(p.greet());
        System.out.println(c.greet());

        int i = 0;

        Predicate<Integer> pq = (x) -> x > 10;
        Predicate<Integer> a = (y) -> y < 5;

        int result2 = 0;
        int j = 2;
        switch (j) {
            case 1: result2 = 1;
            case 2: result2 = 2;
            case 3: result2 = 3;
            case 4: result2 = 4;
        }
        System.out.println("result = " + result2);

        Predicate<Integer> p1 = xx -> xx > 1;
        Stream.of(1, 2, 3, 4)
                .filter( xx -> xx < 4 && xx > 1 )
                .forEach(System.out::print);

        StaticInitialization mc = new StaticInitialization();
        System.out.println(myNum);
        mc.doubleThisNumber();
        System.out.println(myNum);
    }

    static int myNum = 5;

    public void doubleThisNumber() {
        myNum = myNum * 2;
    }

    @FunctionalInterface
    interface StringValidator {
        boolean test(String s);
        default boolean initialTest(String s) {
            return !s.isEmpty();
        }
    }

    public static void someMethod(long arg, int... args) {
        // assume implementation here
    }

    interface A {
        default int size() {
            return 10;
        }
    }

    interface B extends A {
        int size();
    }

     static class Parent {
        public static String greet() {
            return "This is the parent speaking";
        }
    }
    static class Child extends Parent {
        public static String greet() {
            return "This is the child speaking";
        }
    }


}
