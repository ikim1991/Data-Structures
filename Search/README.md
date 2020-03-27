# Algorithms: Search  

### Linear Search  

Linear search is a method of finding a target value within a list. It uses a brute force approach where it sequentially searches through every value until either a match is found or it reaches the end of an array. The time complexity of linear search is linear time, O(n).  

### Binary Search  

For sorted lists, we can use Binary search to improve the time complexity to logarithmic time, O(log n). Binary search uses the divide and conquer approach where half of the dataset is discarded every iteration.  

##### Implementing Linear Search / Binary Search  

[Linear and Binary Search Java Code](./src/algorithms/search/Main.java)

```Java
public class Main {

    public static void main(String[] args) {

        // Create list of sorted numbers
        int[] numbers = {0, 4, 5, 6, 7, 9, 10, 12, 29, 31, 34};

        // Perform linear search. Returns index of target value
        System.out.println(linearSearch(numbers, 7)); // Returns -> 4

        // Performs binary search. Returns index of target value
        System.out.println(binarySearch(numbers, 9)); // Returns -> 5
    }

    // Method for linear search
    private static int linearSearch(int[] numbers, int target){

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == target){
                return i;
            }
        }

        return -1;
    }

    // Method for binary search
    private static int binarySearch(int[] numbers, int target){
        // Initialize left, right, and middle indexes
        int right = numbers.length - 1;
        int left = 0;
        int mid;

        // Loop until it cannot be halved anymore
        while(left <= right){
            mid = (right + left) / 2;

            // If Target value is found, return index
            // If Target value is greater than the middle value, discard everything to its left
            // If Target value is less than the middle value, discard everything to its right
            if(target == numbers[mid]){
                return mid;
            } else if(target > numbers[mid]){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        // Return -1 if no match found
        return -1;
    }
}
```  

### Breadth First Search (BFS)  

Breadth First Search is a method of traversing through trees and graphs. This operation has a time complexity of linear time as each node must be visited at least once. BFS has a higher overhead when it comes to space complexity.  
BFS starts at the root node, goes down level to level going left to right on each level.  
BFS is good when we are looking for the shortest path of a tree or graph.  

##### Implementing BFS  

[BreadthFirstSearch class](./src/algorithms/search/BreadthFirstSearch.java)  

```Java
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
```  

### Depth First Search (DFS)  

Depth First Search is another method of traversing through trees and graphs. Unlike BFS, it has a lower overhead when it comes to space complexity.  
DFS starts at the root node and works its way down to the leaf node. It goes from top to bottom, going left to right. As the name suggests, it goes depth first or left most. There are 3 different methods for traversing in DFS: InOrder, PreOrder, and PostOrder.  
DFS is good for when we need to check whether something exists within a tree or graph.  
The image below shows the difference between the traversal order of BFS vs. DFS.  

[BFS vs. DFS](./bfsvsdfs.png)  

##### Implementing DFS  

[DepthFirstSearch class](./src/algorithms/search/DepthFirstSearch.java)  

```Java
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
```  
