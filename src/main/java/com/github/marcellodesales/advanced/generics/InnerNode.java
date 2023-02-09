package com.github.marcellodesales.advanced.generics;

import java.util.Collections;

public class InnerNode<T> implements TreeNode<T> {

    private final TreeNode<T> left;
    private final TreeNode<T> right;
    private final T value;

    public InnerNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

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
