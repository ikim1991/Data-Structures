package algorithms.search;

import java.util.ArrayList;

public class DepthFirstSearch {

    public static void main(String[] args) {

        // Creating a Binary Search Tree
        BST2 tree = new BST2();

        // Inserting values to data structure
        // A binary tree of 4 levels deep
        tree.insert(29);
        tree.insert(15); tree.insert(75);
        tree.insert(9); tree.insert(17); tree.insert(50); tree.insert(100);
        tree.insert(7); tree.insert(10); tree.insert(16); tree.insert(20); tree.insert(40); tree.insert(60); tree.insert(80); tree.insert(110);

        // Call BreadthFirstSearch In Order method
        System.out.println(tree.dfsInOrder()); // Outputs -> [7, 9, 10, 15, 16, 17, 20, 29, 40, 50, 60, 75, 80, 100, 110]

        // Call BreadthFirstSearch Pre Order method
        System.out.println(tree.dfsPreOrder()); // Outputs -> [29, 15, 9, 7, 10, 17, 16, 20, 75, 50, 40, 60, 100, 80, 110]

        // Call BreadthFirstSearch Post Order method
        System.out.println(tree.dfsPostOrder()); // Outputs -> [7, 10, 9, 16, 20, 17, 15, 40, 60, 50, 80, 110, 100, 75, 29]
    }
}

// Binary Tree Class
class BST2{

    public Node root;

    public BST2(){ }

    // Method for inserting values into data structure
    public void insert(int value){

        Node currentNode = this.root;

        if(currentNode == null){
            this.root = new Node(value);
        } else{
            while(true){
                if(value > currentNode.value){
                    if(currentNode.right == null){
                        currentNode.right = new Node(value);
                        break;
                    } else{
                        currentNode = currentNode.right;
                    }
                }
                if(value < currentNode.value){
                    if(currentNode.left == null){
                        currentNode.left = new Node(value);
                        break;
                    } else{
                        currentNode = currentNode.left;
                    }
                }
            }
        }
    }

    // Method for performing Depth First Search In Order Recursively
    public ArrayList<Integer> dfsInOrder(){
        return traverseInOrder(this.root, new ArrayList<Integer>());
    }
    public ArrayList<Integer> traverseInOrder(BST2.Node node, ArrayList<Integer> numbers){
        if(node.left != null){
            traverseInOrder(node.left, numbers);
        }
        numbers.add(node.value);
        if(node.right != null){
            traverseInOrder(node.right, numbers);
        }

        return numbers;
    }

    // Method for performing Depth First Search Pre Order Recursively
    public ArrayList<Integer> dfsPreOrder(){
        return traversePreOrder(this.root, new ArrayList<Integer>());
    }
    public ArrayList<Integer> traversePreOrder(BST2.Node node, ArrayList<Integer> numbers){
        numbers.add(node.value);
        if(node.left != null){
            traversePreOrder(node.left, numbers);
        }
        if(node.right != null){
            traversePreOrder(node.right, numbers);
        }

        return numbers;
    }

    // Method for performing Depth First Search Post Order Recursively
    public ArrayList<Integer> dfsPostOrder(){
        return traversePostOrder(this.root, new ArrayList<Integer>());
    }
    public ArrayList<Integer> traversePostOrder(BST2.Node node, ArrayList<Integer> numbers){
        if(node.left != null){
            traversePostOrder(node.left, numbers);
        }
        if(node.right != null){
            traversePostOrder(node.right, numbers);
        }
        numbers.add(node.value);
        return numbers;
    }

    public class Node{
        public int value;
        public Node left, right;

        public Node(int value){
            this.value = value;
        }
    }
}
