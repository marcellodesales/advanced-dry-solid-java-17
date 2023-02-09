package com.github.marcellodesales.advanced.nastedtypes;

public class MethodWithLocalClass {

    private String name = "Marcello";

    // use this instance to create a class that transforms the parameters
    public void example(int x, int y) {
        int number = 23;

        //
        // static class NOT OK
        class Local {

            // we can do static
            // public static void method2() {}
            private void method() {
                System.out.println(x + y);
                System.out.println(name);
            }
        }

        var obj = new Local();
        obj.method();
        number++;
        name = "new update";
    }
}
