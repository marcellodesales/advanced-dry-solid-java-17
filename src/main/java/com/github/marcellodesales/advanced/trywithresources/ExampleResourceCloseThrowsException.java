package com.github.marcellodesales.advanced.trywithresources;

public record ExampleResourceCloseThrowsException(String name) implements AutoCloseable {

    public ExampleResourceCloseThrowsException {
        System.out.println("Initializing " + name);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing " + name);
        throw new Exception("Exception thrown while closing resource " + name);
    }

    public static void main(String[] args) {
        // when an exception occurs while closing a resource, exception is suppressed and attached into the exception
        // The exceptions suppresed can be captured by e.getSuppressed();
        //Initializing 1
        //Initializing 2
        //Inside the try-block
        //Closing 2
        //Closing 1
        //Inside the catch-block
        //java.lang.Exception: Exception thrown in try-block
        //	at com.github.marcellodesales.advanced.trywithresources.ExampleResourceCloseThrowsException.main(ExampleResourceCloseThrowsException.java:33)
        //	Suppressed: java.lang.Exception: Exception thrown while closing resource 2
        //		at com.github.marcellodesales.advanced.trywithresources.ExampleResourceCloseThrowsException.close(ExampleResourceCloseThrowsException.java:12)
        //		at com.github.marcellodesales.advanced.trywithresources.ExampleResourceCloseThrowsException.main(ExampleResourceCloseThrowsException.java:31)
        //
        //Process finished with exit code 0
        try (var example1 = new ExampleResource("1"); var example2 = new ExampleResourceCloseThrowsException("2")) {
            System.out.println("Inside the try-block");
            throw new Exception("Exception thrown in try-block");

        } catch (Exception error) {
            System.out.println("Inside the catch-block");
            error.printStackTrace(System.out);

            //Suppressed was the following...
            //java.lang.Exception: Exception thrown while closing resource 2
            //	at com.github.marcellodesales.advanced.trywithresources.ExampleResourceCloseThrowsException.close(ExampleResourceCloseThrowsException.java:12)
            //	at com.github.marcellodesales.advanced.trywithresources.ExampleResourceCloseThrowsException.main(ExampleResourceCloseThrowsException.java:31)
            if (error.getSuppressed() != null && error.getSuppressed().length > 0) {
                System.out.println("Suppressed exceptions occurred");
                for (Throwable t : error.getSuppressed()) {
                    System.out.println("Suppressed was the following...");
                    t.printStackTrace();
                }
            }
        }
    }
}
