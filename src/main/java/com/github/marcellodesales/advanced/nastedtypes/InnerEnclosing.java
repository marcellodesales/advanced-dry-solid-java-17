package com.github.marcellodesales.advanced.nastedtypes;

public class InnerEnclosing {

    private String name = "Tati";

    // Only make an inner class if there's a good reason
    // Iterators return a private class that implements the interface
    class Inner {

        private String name = "Marcello";

        void run() {
            System.out.println(name);
            System.out.println(InnerEnclosing.this.name);
        }
    }

    public void createInner() {
        var inner = this.new Inner();
    }


}
