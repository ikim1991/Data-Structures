package datastructures.stacksandqueues;

public class MyQueue {

    // Properties of the Queue. Size, first node, and last node
    private int size;
    private MyNode first;
    private MyNode last;

    // Constructor for initializing an empty queue
    public MyQueue(){
        this.size = 0;
    }

    public static void main(String[] args) {

        // Initializing a queue data structure
        MyQueue queue = new MyQueue();

        // Adding items to the queue
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Gets and outputs the first item on queue.
        queue.peek(); // Outputs -> 0

        // Following First In First Out, outputs and dequeues the first item of the queue
        queue.dequeue(); // Outputs -> 0
        queue.dequeue(); // Outputs -> 1
        queue.dequeue(); // Outputs -> 2
        queue.dequeue(); // Outputs -> 3
    }

    // Grabs the first data in queue
    public int peek(){
        System.out.println(this.first.getData());
        return this.first.getData();
    }

    // Adds item to the queue
    public void enqueue(int value){
        MyNode newNode = new MyNode(value, this.last);
        if(this.size == 0){
            this.first = newNode;
            this.last = newNode;
        } else{
            MyNode currentNode = this.last;
            currentNode.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }

    // Following the First In First Out order, outputs and dequeues the first item in the queue
    public int dequeue(){
        int value = this.first.getData();
        if(this.size == 1){
            this.first = null;
            this.last = null;
            System.out.println(value);
            return value;
        } else{
            this.first = this.first.getNext();
            this.first.setPrev(null);
        }
        this.size--;

        System.out.println(value);
        return value;
    }
}
