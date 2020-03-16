package datastructures.linkedlists;

public class MyLinkedList {

    // Properties of the Linked List Data Structures, the size, and the pointers to the root and tail Nodes
    private int size;
    private MyNode root;
    private MyNode tail;

    // Constructor initializing an empty Linked List data structure
    public MyLinkedList(){
        this.size = 0;
    }

    public static void main(String[] args) {

        // Creating a new Linked List data structure
        MyLinkedList linkedList = new MyLinkedList();

        // Adding data to the Linked List and Traversing
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.traverse(); // Prints -> 0	1	2	3	4

        // Inserting new data by index and Traversing
        linkedList.insert(0, 4);
        linkedList.insert(2, 7);
        linkedList.insert(6,9);
        linkedList.traverse(); // Prints -> 4	0	7	1	2	3	9	4

        // Removing data from the Linked List to go back to the original
        linkedList.remove(6);
        linkedList.remove(2);
        linkedList.remove(0);
        linkedList.traverse(); // Prints -> 0	1	2	3	4
    }

    // add Method takes in a value to add into the Linked List data structure
    // add will automatically add new data at the end of the linked list
    // The item added becomes the tail node of the linked list
    public void add(int value){

        if(this.size == 0){
            this.root = new MyNode(value);
            this.tail = this.root;
            this.root.setNext(null);
            this.size++;
        } else{
            MyNode newNode = new MyNode(value);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.size++;
        }
    }

    // insert method much like the Add method adds new data to the linked list
    // Except it adds data into a specified index location. The Insert method needs
    // to handle 3 different cases:
    // 1. When the index is out of range, it will automatically call the add method
    // 2. When the index = 0, the data is added to the beginning of linked list, which becomes the new root node
    // 3. When the index > 0 and within range, the data is inserted in place
    public void insert(int index, int value){
        MyNode currentNode = this.root;
        if(index >= this.size || index < 0){
            add(value);
        } else if(index == 0){
            MyNode placeHolder = new MyNode(value);
            placeHolder.setNext(currentNode);
            this.root = placeHolder;
            this.size++;
        } else {
            for(int i = 0; i<index-1; i++){
                currentNode = currentNode.getNext();
            }
            MyNode placeHolder = currentNode.getNext();
            currentNode.setNext(new MyNode(value));
            currentNode.next.setNext(placeHolder);
            this.size++;
        }
    }

    // The remove method removes a node from the linked list within the specified index
    // If the index is out of range, it will throw an error, otherwise it will de-reference
    // the node at the specified index. Once de-referenced, the Java garbage collection
    // will delete it from memory
    public void remove(int index) {
        if(index < 0 || index >= this.size){
            System.out.println("Index Out of Range");
        } else {
            MyNode currentNode = this.root;
            if(index == 0){
                this.root = currentNode.getNext();
                this.size--;
            } else {
                for(int i = 0; i<index-1; i++){
                    currentNode = currentNode.getNext();
                }
                MyNode placeHolder = currentNode.getNext().getNext();
                currentNode.setNext(placeHolder);
                this.size--;
            }
        }
    }

    // Loops through all the linked nodes and prints the values from the root node to the tail node
    public void traverse(){
        MyNode currentNode = this.root;
        if(this.size == 1){
            System.out.print(currentNode.getValue() + "\t");
        } else{
            for(int i = 0; i < this.size; i++) {
                System.out.print(currentNode.getValue() + "\t");
                currentNode = currentNode.getNext();
            }
        }
        System.out.println();
    }

    // Data is stored in a linked list by Nodes
    private class MyNode{

        // Properties of Nodes, data it holds and a reference to the next linked node
        private int value;
        private MyNode next;

        // Constructor of initializing a new Node
        public MyNode(int value){
            this.value = value;
        }

        // Returns the value of the node
        public int getValue() {
            return value;
        }

        // Returns the location of its linked node
        public MyNode getNext() {
            return next;
        }

        // Method to change its linking node, used for removing, adding, and inserting data
        public void setNext(MyNode next) {
            this.next = next;
        }
    }
}
