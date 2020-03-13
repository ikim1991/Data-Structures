package datastructures.arrays;

public class Main {
    public static void main(String[] args) {
        // Initializing Array Data Structure
        MyArray array = new MyArray();

        // Adding data to our array
        array.add(1);
        array.add(2);
        array.add(3);
        array.add("Do");
        array.add("Re");
        array.add("Mi");
        array.add(false);
        array.add(true);
        array.add('A');
        array.add('B');
        array.add('C');

        // Outputs the size of the array
        System.out.println(array.size());
        // Outputs the data at the specified index // Prints the value 2 in our example
        System.out.println(array.get(1));

        // Prints every element of our array
        array.traverse(); // Prints -> 1    2   3   Do	Re	Mi	false	true	A	B	C

        // Takes in a value and index location as parameters to replace currently existing data in our array
        array.set(true, 6);
        array.traverse(); // Prints -> 1	2	3	Do	Re	Mi	true	true	A	B	C

        // Removing data at the first index
        array.remove(0);
        array.traverse(); // Prints -> 2	3	Do	Re	Mi	true	true	A	B	C
        // Removing data at the 4th index
        array.remove(4);
        array.traverse(); // Prints -> 2	3	Do	Re	true	true	A	B	C
        // Removing data at the last index
        array.remove(array.size()-1);
        array.traverse(); // Prints -> 2	3	Do	Re	true	true	A	B
    }
}
