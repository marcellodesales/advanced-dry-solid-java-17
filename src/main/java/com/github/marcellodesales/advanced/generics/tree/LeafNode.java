package com.github.marcellodesales.advanced.generics.tree;

public class LeafNode<T> implements TreeNode<T> {

    private final T value;

    public LeafNode(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public TreeNode<T> getLeft() {
        return null;
    }

    @Override
    public TreeNode<T> getRight() {
        return null;
    }

    @Override
    public String toString() {
        return "InnerNode{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        var three = new LeafNode<Integer>(3);
        // with type inference.
        var five = new LeafNode<>(5);
        var binaryTree = new InnerNode<>(10, five, three);

        System.out.println(binaryTree);
    }
}
