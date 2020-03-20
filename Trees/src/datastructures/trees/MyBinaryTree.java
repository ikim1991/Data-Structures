package datastructures.trees;

public class MyBinaryTree {

    // Properties of the Binary Tree, the Root Node
    private MyNode root;

    // Constructor for initializing an empty Binary Tree
    public MyBinaryTree(){}

    public static void main(String[] args) {

        // Creating new Binary Tree
        MyBinaryTree binaryTree = new MyBinaryTree();

        // Inserting Values into the Binary Tree
        binaryTree.insert(9);
        binaryTree.insert(5);
        binaryTree.insert(12);
        binaryTree.insert(7);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(14);

        // Binary Search to test whether the Binary Tree contains the input values
        binaryTree.contains(9); // Outputs True, Prints -> Contains: 9
        binaryTree.contains(7); // Outputs True, Prints -> Contains: 7
        binaryTree.contains(3); // Outputs True, Prints -> Contains: 3

        binaryTree.contains(1); // Outputs False, Prints -> Does not Contain: 1
        binaryTree.contains(4); // Outputs False, Prints -> Does not Contain: 4
        binaryTree.contains(29); // Outputs False, Prints -> Does not Contain: 29

        // Traverses and Prints the data of the Binary Tree in order
        binaryTree.traverse(binaryTree.root); // Prints --> 3	5	7	9	10	12	14

        // Removing Nodes from Tree
        binaryTree.remove(14);
        binaryTree.remove(3);
        binaryTree.remove(5);
        binaryTree.remove(10);
        System.out.println();
        binaryTree.traverse(binaryTree.root); // Prints -> 7	9	12
    }

    // Insert Method to add new nodes to the tree
    // If value is smaller than value of the Node, it will be inserted to the left of the node
    // If value is bigger than the value of the Node, it will be inserted to the right of the node
    public boolean insert(int value){
        if(this.root == null){
            this.root = new MyNode(value);
        } else{
            MyNode currentNode = this.root;
            while(true){
                if(currentNode.getLeft() != null && value < currentNode.getData()){
                    currentNode = currentNode.getLeft();
                } else if(currentNode.getRight() != null && value > currentNode.getData()){
                    currentNode = currentNode.getRight();
                } else if(currentNode.getLeft() == null && value < currentNode.getData()){
                    currentNode.setLeft(new MyNode(value));
                    return true;
                } else{
                    currentNode.setRight(new MyNode(value));
                    return true;
                }
            }
        }
        return false;
    }

    // Binary Search method to find whether or not the Binary Tree contains specified values
    public boolean contains(int value){
        MyNode currentNode = this.root;
        while(true){
            if(currentNode.getData() == value){
                System.out.println("Contains: " + value);
                return true;
            } else if(value < currentNode.getData() && currentNode.getLeft() != null){
                currentNode = currentNode.getLeft();
            } else if(value > currentNode.getData() && currentNode.getRight() != null){
                currentNode = currentNode.getRight();
            } else{
                System.out.println("Does not Contain: " + value);
                return false;
            }
        }
    }

    // Method for removing a Node from the Tree
    public boolean remove(int value){

        if(this.root == null){
            return false;
        }

        MyNode currentNode = this.root;
        MyNode parentNode = null;

        // Iterate until a match is found
        while(true){
            if(value < currentNode.getData() && currentNode.getLeft() != null){
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if(value > currentNode.getData() && currentNode.getRight() != null){
                parentNode = currentNode;
                currentNode = currentNode.getRight();
            } else if(value == currentNode.getData()){

                // There are 3 different scenarios to consider when removing a node from the tree.
                // To maintain the integrity of the Binary Tree, we must abide by its rules.
                // Essentially, smaller values to the left, and larger values to the right rule.
                // To maintain this rule, the Current Node must be replaced with the next smallest
                // valued node on the Right side of he Current Node.

                // Scenario 1 - When the Current Node has no Right Child,
                // the Left Child (the next smallest valued Node) replaces the Current Node
                if(currentNode.getRight() == null){
                    if(parentNode == null){
                        this.root = currentNode.getLeft();
                    } else {
                        if(currentNode.getData() < parentNode.getData()){
                            parentNode.setLeft(currentNode.getLeft());
                        } else if(currentNode.getData() > parentNode.getData()){
                            parentNode.setRight(currentNode.getLeft());
                        }
                    }
                    return true;
                }

                // Scenario 2 - When the Right Child of the Current Node doesn't have a Left Child,
                // the Right Child (the next smallest valued Node) replaces the Current Node
                if(currentNode.getRight()!= null && currentNode.getRight().getLeft() == null){

                    if(parentNode == null){
                        this.root = currentNode.getRight();
                    } else{
                        currentNode.getRight().setLeft(currentNode.getLeft());
                        if(currentNode.getRight().getData() < parentNode.getData()){
                            parentNode.setLeft(currentNode.getRight());
                        } else if(currentNode.getRight().getData() > parentNode.getData()){
                            parentNode.setRight(currentNode.getRight());
                        }
                    }

                    return true;
                }

                // 3 - When the Right Child has a Left Child, we must find the Left Most Node as this will be
                // the next smallest value. By doing so and replacing the Current Node, we
                // preserve the rules of the Binary Tree
                if(currentNode.getRight() != null && currentNode.getRight().getLeft() != null){
                    MyNode leftMost = currentNode.getRight().getLeft();
                    MyNode leftMostParent = currentNode.getRight();
                    while(leftMost.getLeft() != null){
                        leftMostParent = leftMost;
                        leftMost = leftMost.getLeft();
                    }

                    leftMostParent.setLeft(leftMost.getRight());
                    leftMost.setLeft(currentNode.getLeft());
                    leftMost.setRight(currentNode.getRight());

                    if(parentNode==null){
                        this.root = leftMost;
                    } else{
                        if(currentNode.getData() < parentNode.getData()){
                            parentNode.setLeft(leftMost);
                        } else if(currentNode.getData() > parentNode.getData()){
                            parentNode.setRight(leftMost);
                        }
                    }
                    return true;
                }
            } else{
                return false;
            }
        }
    }

    // Using Recursion to traverse and print all the data in the tree in order, starting from left to right
    // Takes in an argument, the entry point, at the Root Node
    public void traverse(MyNode node){
        if(node.getLeft() != null){
            traverse(node.getLeft());
        }
        System.out.print(node.getData() + "\t");
        if(node.getRight() != null){
            traverse(node.getRight());
        }
    }
}
