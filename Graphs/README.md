# Graphs

### What are Graphs  

Graphs are a set of values related in a pair-wise fashion. It is a network of nodes connected by edges. Graphs are data structures used to model real-world relationships.  

There are different types of Graphs:  
  - Directed vs. Undirected, the difference between directed and undirected graphs is the flow of direction between nodes. Much like the Facebook Friends social network system vs. the Instagram Followers social network system.  
  - Weight vs. Unweighted, the difference between weighted and unweighted graphs is that in a weighted graph the edges hold values. For example, Google Maps utilizes weighted graphs to find the optimal route to a destination among its multiple routes.  
  - Cyclic vs. Acyclic, in a cyclic graph the nodes are connected in a circular fashion. Cyclic Graphs are commonly found in weighted graphs such as Google Maps where for a given destination, there will be a return destination.  

### Building a Graph Data Structure  

There is no built in class for the Graph data structure in Java. The following class was built from scratch to demonstrate the inner workings of an Undirected Cyclic Graph.  
The [MyGraph class](./src/datastructures/graphs.MyGraph.java) was built with methods to add nodes, create connections between nodes, and to print the values of the nodes and their connections.    


```Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyGraph {

    // Properties of the Graph data structure
    private int numberOfNodes;
    private HashMap<Integer, ArrayList<Integer>> adjacentList;

    // Constructor for initializing an empty Graph
    public MyGraph(){
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public static void main(String[] args) {

        // Creating new Instance of a Graph
        MyGraph graph = new MyGraph();

        // Adding the Nodes to the Graph
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        // Creating undirected Cyclic connection between nodes
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(6,5);

        // Prints all the Nodes of the graph and their connections to one another
        graph.showConnections();

        // Prints
        // 0: [1, 2]
        // 1: [3, 2, 0]
        // 2: [4, 1, 0]
        // 3: [1, 4]
        // 4: [3, 2, 5]
        // 5: [4, 6]
        // 6: [5]
    }

    // Method for adding new Nodes
    public void addVertex(int node){
        this.adjacentList.put(node, new ArrayList<Integer>());
        this.numberOfNodes++;
    }

    // Method for creating connection between Nodes
    // Undirected graphs require a back and forth connection between nodes
    public void addEdge(int nodeOne, int nodeTwo){
        this.adjacentList.get(nodeOne).add(nodeTwo);
        this.adjacentList.get(nodeTwo).add(nodeOne);
    }

    // Method to print all the values of the Graph and their connection points
    public void showConnections(){
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjacentList.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```  
