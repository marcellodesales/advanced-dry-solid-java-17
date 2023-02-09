package com.github.marcellodesales.advanced.generics;

/**
 * The tree node
 * @param <T>
 */
public interface TreeNode<T> {
    T getValue();
    TreeNode<T> getLeft();
    TreeNode<T> getRight();
}
