package datastructures.trees;

public class MyNode {

    private int data;
    private MyNode left;
    private MyNode right;

    public MyNode(int value){
        this.data = value;
    }

    public int getData() {
        return data;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }
}
