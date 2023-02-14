package com.github.marcellodesales.advanced.generics;

public class LeafNodeCompatible<T extends Comparable> implements ComparableTreeNode<T> {

    private final T value;

    public LeafNodeCompatible(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public ComparableTreeNode<T> getLeft() {
        return null;
    }

    @Override
    public ComparableTreeNode<T> getRight() {
        return null;
    }

    @Override
    public String toString() {
        return "InnerNode{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        var three = new LeafNodeCompatible<Integer>(3);
        // with type inference.
        var five = new LeafNodeCompatible<>(5);

    }
}
