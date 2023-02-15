package com.github.marcellodesales.advanced.generics.multipleparams;

import java.util.Comparator;
import java.util.List;

public class ProductsSorted {

    public static List<Product> makeList() {
        return List.of(
                new Product(3, "Coffee", "super coffee from"),
                new Product(33, "Rice", "super japanese rice"),
                new Product(1, "Beans", "beans from brazil")
        );
    }

    /**
     * The methods has the same erasure with the generic version
     * @param prods
     * @return
     */
//    public static List<String> sortByIdExtractingOnlyNames(List<Product> prods) {
//        return prods.stream()
//                .sorted(Comparator.comparing(Product::id))
//                .map(Product::name)
//                .toList();
//    }

    /**
     * Restricting the types that will be on the list of names provided. This is a good pattern
     * as Records already creates a method to access the values, and we can use the interface as
     * the parameters for the values that is needed.
     * @param prods
     * @param <T>
     * @return
     */
    public static <T extends HasId & HasName> List<String> sortByIdExtractingOnlyNames(List<T> prods) {
        return prods.stream()
                .sorted(Comparator.comparing(HasId::id))
                .map(HasName::name)
                .toList();
    }

    public static void main(String[] args) {
        var products = makeList();
        var sortedNames = sortByIdExtractingOnlyNames(products);
        System.out.println(sortedNames);
    }
}
