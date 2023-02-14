package com.github.marcellodesales.advanced.generics.tree;

public record LeafNodeRecord<T>(T value) implements TreeNode<T> {

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
        var three = new LeafNodeRecord<Integer>(3);
        // with type inference.
        var five = new LeafNodeRecord<>(5);
        var binTree = new InnerNode<>(10, five, three);

        System.out.println(binTree);
    }
}
