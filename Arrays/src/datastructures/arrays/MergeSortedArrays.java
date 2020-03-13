package datastructures.arrays;

import java.util.*;

public class MergeSortedArrays{

    // Creating 2 Arrays to be Merged and Compared
    private static ArrayList<Integer> array1 = new ArrayList<>();
    private static ArrayList<Integer> array2 = new ArrayList<>();

    public static void main(String[] args) {
        // Adding elements to both arrays
        array1.add(9);
        array1.add(4);
        array1.add(29);
        array1.add(7);
        array2.add(10);
        array2.add(5);
        array2.add(6);
        array2.add(12);

        // Calling mergeSortedArrays method to merge and sort both arrays into 1
        mergeSortedArrays(array1, array2); // Prints -> 4	5	6	7	9	10	12	29
    }

    // Takes in 2 arrays as arguments, appends second array to the first then sorts the array.
    // Traverses new sorted array
    public static void mergeSortedArrays(ArrayList array1, ArrayList array2){

        array1.addAll(array2);

        Collections.sort(array1, new Comparator<Integer>() {
            @Override
            public int compare(Integer t, Integer t1) {
                return t.compareTo(t1);
            }
        });

        for(Object num : array1){
            System.out.print(num+"\t");
        }
    }
}
