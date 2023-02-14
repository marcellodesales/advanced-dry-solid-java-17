package com.github.marcellodesales.advanced.generics.tree;

public record MaxValueInnerNode<T extends Comparable>(ComparableTreeNode<T> left, ComparableTreeNode<T> right) implements ComparableTreeNode<T> {

    @Override
    public T getValue() {
        T leftVal = this.left.getValue();
        T rightVal = this.right.getValue();
        var comparison = leftVal.compareTo(rightVal);
        return comparison >= 0 ? leftVal : rightVal;
    }

    @Override
    public ComparableTreeNode<T> getLeft() {
        return this.left;
    }

    @Override
    public ComparableTreeNode<T> getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return "MaxValueInnerNode{" +
                "value=" + this.getValue() +
                '}';
    }

    public static void main(String[] args) {
        var tree = new MaxValueInnerNode<>(
                new LeafNodeCompatible<>(2),
                new MaxValueInnerNode<>(new LeafNodeCompatible<>(3), new LeafNodeCompatible<>(5)));
        // with type inference.
        var max = tree.getValue();

        System.out.printf("%d", max);
    }
}
