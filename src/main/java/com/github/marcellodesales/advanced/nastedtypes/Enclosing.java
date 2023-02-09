package com.github.marcellodesales.advanced.nastedtypes;

import java.time.LocalDate;

public class Enclosing {

    private static int number = 23;
    private static LocalDate date = LocalDate.of(2033, 4, 10);
    private String name = "Joe";

    private static void printNumber() {
        System.out.println(number);
    }

    private void printName() {
        System.out.println(name);
    }

    private static void printDate() {
        System.out.println(date);
    }

    static class Nested {
        // Shadowing the value of the date...
        private static LocalDate date = LocalDate.of(2033, 4, 10);

        private void printDate() {
            System.out.println(date);
        }

        void run() {
            // Accessing static members are ok
            System.out.println(number);
            printNumber();

            // Shadowing date instance
            printDate();
            System.out.println(Enclosing.date);

            printNumber();

            // Accessing instance members DOES NOT WORK
            //printName();
        }
    }
}
