package datastructures.hashtables;

import java.util.LinkedList;

public class MyHashMap {

    // Properties of the Hash Table, number of buckets/array size
    private int size;
    private LinkedList<String>[] buckets;

    public static void main(String[] args) {

        // Instantiating Hash Table with 10 buckets, 0 - 9 Index
        // Each bucket stores a Linked List of data in case of collision
        MyHashMap myHashTable = new MyHashMap(10);

        // Creating 10 keys to Hash and store into Hash Table
        String key1 = "Federer";
        String key2 = "Nadal";
        String key3 = "Djokovic";
        String key4 = "Thiem";
        String key5 = "Tsitipas";
        String key6 = "Monfils";
        String key7 = "Zverev";
        String key8 = "Raonic";
        String key9 = "Medvedev";
        String key10 = "Murray";

        // Storing Keys to Hash Table
        myHashTable.addKey(key1);
        myHashTable.addKey(key2);
        myHashTable.addKey(key3);
        myHashTable.addKey(key4);
        myHashTable.addKey(key5);
        myHashTable.addKey(key6);
        myHashTable.addKey(key7);
        myHashTable.addKey(key8);
        myHashTable.addKey(key9);
        myHashTable.addKey(key10);

        // Printing out the buckets and seeing where each data is stored
        for(LinkedList<String> key : myHashTable.buckets){
            System.out.print(key + "\t");
        }
        // Prints -> [Monfils, Raonic]	[Djokovic, Zverev]	[Tsitipas, Medvedev]	[Nadal]	null	[Federer, Thiem]	[Murray]	null	null	null
        // We see Collision for Indexes 0, 1, 2, 5
        // While Indexes 4, 7, 8, 9 have not been initialized
    }

    // Constructor for the Hash Table takes in an argument of the number of buckets
    // Creates an empty HashTable of defined size
    public MyHashMap(int size){
        this.size = size;
        this.buckets = new LinkedList[size];
    }

    // Method Hashes the Key and maps it to an index
    // the hashCode() method is a built in Java Hash Function
    // When the memory is not occupied currently, a Linked List is initialized and the data is stored.
    // When the memory is already occupied due to collision, the new data is linked
    // to the existing data through a linked list
    public void addKey(String key){
        int index = Math.abs(key.hashCode() % (size-1));
        System.out.println("Hash Function Generated index of: " + index);

        if(buckets[index] == null){
            buckets[index] = new LinkedList<String>();
        }

        System.out.println("Key: " + key + " was Added to index: " + index);
        buckets[index].add(key);
    }
}