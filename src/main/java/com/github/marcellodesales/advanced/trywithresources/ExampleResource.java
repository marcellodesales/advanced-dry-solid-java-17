package com.github.marcellodesales.advanced.trywithresources;

public record ExampleResource(String name) implements AutoCloseable {

    public ExampleResource {
        System.out.println("Initializing " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }

    public static void main(String[] args) {
        // The order of the initialization and destruction is on a stack
        //Initializing 1
        //Initializing 2
        //Inside the try-block
        //Closing 2
        //Closing 1
        try (var example1 = new ExampleResource("1"); var example2 = new ExampleResource("2")) {
            System.out.println("Inside the try-block");
        }

        System.out.println();
        System.out.println();

        // when an exception occurs within the try, the resources are still closed before the exception
        //Initializing 1
        //Initializing 2
        //Inside the try-block
        //Closing 2
        //Closing 1
        //Inside the catch-block
        //java.lang.Exception: Exception thrown in try-block
        //	at com.github.marcellodesales.advanced.trywithresources.ExampleResource.main(ExampleResource.java:31)
        try (var example1 = new ExampleResource("1"); var example2 = new ExampleResource("2")) {
            System.out.println("Inside the try-block");
            throw new Exception("Exception thrown in try-block");

        } catch (Exception error) {
            System.out.println("Inside the catch-block");
            error.printStackTrace(System.out);
        }
    }
}
