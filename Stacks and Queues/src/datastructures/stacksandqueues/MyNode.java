package datastructures.stacksandqueues;

public class MyNode {

    private int data;
    private MyNode next;
    private MyNode prev;

    public MyNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public MyNode(int data, MyNode prev){
        this.data = data;
        this.prev = prev;
        this.next = null;
    }

    public MyNode getNext(){
        return this.next;
    }

    public MyNode getPrev(){
        return this.prev;
    }

    public void setNext(MyNode next){
        this.next = next;
    }

    public void setPrev(MyNode next){
        this.prev = prev;
    }

    public int getData() {
        return data;
    }
}
