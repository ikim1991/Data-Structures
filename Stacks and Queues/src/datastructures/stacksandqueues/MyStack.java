package datastructures.stacksandqueues;

public class MyStack {

    // Properties of the Stack. Size, Top Node, and Bottom Node
    private int size;
    private MyNode top;
    private MyNode bottom;

    // Constructor Initializing an empty stack
    public MyStack(){
        this.size = 0;
    }

    public static void main(String[] args) {

        // Initializing new Stack
        MyStack stack = new MyStack();

        // Pushing new Data into the stack
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Gets the data at the Top Stack
        stack.peek(); // Outputs -> 3
        // Pops from the Top of the Stack
        // Last In Last Out
        stack.pop(); // Outputs -> 3
        stack.pop(); // Outputs -> 2
        stack.pop(); // Outputs -> 1
        stack.pop(); // Outputs -> 0
    }

    // Grabs the data at the top stack
    public int peek() throws NullPointerException{
        System.out.println(this.top.getData());
        return this.top.getData();
    }

    // Pops the top node off the stack. Last In Last Out
    public int pop() throws NullPointerException{
        int data = this.top.getData();
        this.top = this.top.getPrev();
        this.size--;

        System.out.println(data);
        return data;
    }

    // Pushes a new node into our stack. New node becomes the top stack
    public void push(int value){
        MyNode pushNode = new MyNode(value, this.top);
        if(this.size == 0){
            this.top = pushNode;
            this.bottom = pushNode;
        } else{
            MyNode currentNode = this.top;
            currentNode.setNext(pushNode);
            this.top = pushNode;
        }
        this.size++;
    }
}
