package com.github.marcellodesales.advanced.generics.tree;

/**
 * The tree node, with restrictions
 * @param <T>
 */
public interface TreeNode<T> {

    T getValue();

    TreeNode<T> getLeft();

    TreeNode<T> getRight();
}
