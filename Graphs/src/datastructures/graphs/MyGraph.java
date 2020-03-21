package datastructures.graphs;

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
