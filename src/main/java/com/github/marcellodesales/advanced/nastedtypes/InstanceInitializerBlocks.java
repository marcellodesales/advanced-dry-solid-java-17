package com.github.marcellodesales.advanced.nastedtypes;

import java.nio.file.Files;
import java.time.Period;
import java.util.*;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InstanceInitializerBlocks {

    private final byte[] randomBytes;

    // All constructors will reuse this block of initialization
    {
        System.out.println("Initializing...");
        randomBytes = new byte[16];
        new Random().nextBytes(randomBytes);
    }

    // Will first initialize the local variables
    // Then it calls the method defined inside
    public InstanceInitializerBlocks(int color) {
        System.out.println("From color");
    }

    /**
     *
     */
    public InstanceInitializerBlocks() {
        System.out.println("From default");
        Period age = Period.between(null, null);

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        var obj = new InstanceInitializerBlocks();
        for (byte b : obj.randomBytes) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        var obj2 = new InstanceInitializerBlocks(4);
        for (byte b : obj2.randomBytes) {
            System.out.printf("%02X ", b);
        }
        Predicate<Integer>  a = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };

        IntPredicate b = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return false;
            }
        };

        int max = 2147483647;
        System.out.println(max + 1);
    }
}
