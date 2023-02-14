package com.github.marcellodesales.advanced.generics;

/**
 * The tree node, with restrictions
 * @param <T>
 */
public interface ComparableTreeNode<T extends Comparable> {

    T getValue();

    ComparableTreeNode<T> getLeft();

    ComparableTreeNode<T> getRight();
}
