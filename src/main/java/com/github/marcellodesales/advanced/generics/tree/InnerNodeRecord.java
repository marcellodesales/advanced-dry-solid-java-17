package com.github.marcellodesales.advanced.generics.tree;

import java.util.Collections;

public record InnerNodeRecord<T>(T value, TreeNode<T> left,
                                 TreeNode<T> right) implements TreeNode<T> {

    @Override
    public TreeNode<T> getLeft() {
        return left;
    }

    @Override
    public TreeNode<T> getRight() {
        return right;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        final String bottom = "<- " + left + "  ....  " + right + " ->";
        return String.join("", Collections.nCopies(bottom.length() / 3, " ")) +
                "/ InnerNode (" + value + ") \\ \n" + bottom;
    }
}
