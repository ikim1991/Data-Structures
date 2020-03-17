# Stacks and Queues  

### What are Stacks and Queues?  

Stacks and Queues are linear data structures with flexible sizes, meaning we can add and remove items with ease.  
Stacks are a LIFO (Last In, First Out) data structure.  
Queues are a FIFO (First In, First Out) data structure.  
Stacks can be implemented using arrays or linked lists. Arrays are used due to cache locality, where memory is stored sequentially and near each other. This gives faster access and performance benefits over linked lists where memory is scattered. Linked lists are useful due to its flexibility in memory allocation. Linked lists have more dynamic memory.  
Queues can be implemented using linked lists. The sequential indexing of arrays make it a bad fit for queues. Queues are FIFO, so when we start removing items from a queue, the array would need to shift the indexes one by one. This adds time and space complexities that are not ideal.  
Many programming languages are modelled using the Stack architecture. Function calls follows the Last In, First Out model and the JavaScript engine uses stacks and queues in its architecture.  

### Implementing a Stack Data Structure  

Java has a built-in Stack class but the Java code below demonstrates the inner workings of the Stack data structure. It uses a linked list to push, pop, and peek the data of the stack in Last In, Last Out order. The [MyStack class](./src/datastructures/stacksandqueues/MyStack.java) uses the [MyNode class](./src/datastructures/stackedqueues/MyNode.java) to store the data as a linked list.  

```Java
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
          pushNode.setNext(null);
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
```  

### Implementing the Queue Data Structure  

Java has a built-in Queue class but the Java code below demonstrates the inner workings of the Queue data structure. It uses a linked list to enqueue, dequeue, and peek the data of the queue in First In, First Out order. The [MyQueue class](./src/datastructures/stacksandqueues/MyQueue.java) uses the [MyNode class](./src/datastructures/stackedqueues/MyNode.java) to store the data as a linked list.  

```Java
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
```  

### When to Use a Stack or Queue  

##### Pros  
  - Fast Operations, Removing and Inserting Items
  - Fast Peek
  - Ordered  

##### Cons  
  - Slow Lookup
  - Space Complexity  
