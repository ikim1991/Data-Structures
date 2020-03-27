package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        // Creating a Binary Search Tree
        BST tree = new BST();

        // Inserting values to data structure
        // A binary tree of 4 levels deep
        tree.insert(29);
        tree.insert(12); tree.insert(75);
        tree.insert(9); tree.insert(20); tree.insert(50); tree.insert(100);
        tree.insert(7); tree.insert(10); tree.insert(11); tree.insert(14); tree.insert(40); tree.insert(60); tree.insert(80); tree.insert(110);

        // Run BreadthFirstSearch method
        tree.breadthFirstSearch(); // Prints -> 29	12	75	9	20	50	100	7	10	14	40	60	80	110	11	29
    }

}

// Binary Tree Class
class BST{

    public Node root;

    public BST(){ }

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

    // Method for performing Breath First Search
    public void breadthFirstSearch(){

        BST.Node currentNode = this.root;
        // An empty list initialized to store values of items to be traversed
        ArrayList<Integer> traversal = new ArrayList<>();
        // An empty queue initialized, to keep track of the order to add items to the traversal list
        LinkedList<BST.Node> queue = new LinkedList<>();

        queue.push(currentNode);

        // Queuing values and adding values to traversal list until we reach the end
        while(queue.size() > 0){
            currentNode = queue.removeFirst();
            traversal.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }

        // Print values of our traversal list
        for(int i : traversal){
            System.out.print(i + "\t");
        }

    }

    public class Node{
        public int value;
        public Node left, right;

        public Node(int value){
            this.value = value;
        }
    }
}
