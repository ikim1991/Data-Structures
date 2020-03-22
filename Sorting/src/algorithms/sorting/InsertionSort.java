package algorithms.sorting;

public class InsertionSort {

    public static void main(String[] args) {

        // Array of random numbers to be sorted
        int[] numbers = {99, 4, 29, 9, 7, 0, 5, 6, 1, 69};

        // Call selectionSort method on numbers array
        insertionSort(numbers);
        // Prints ->    0	1	4	5	6	7	9	29	69	99

    }

    // Method for Insertion Sort
    private static void insertionSort(int[] numbers){
        // Value of Current Value being Compared
        int currentValue;
        for(int i = 1; i < numbers.length; i++){
            // Comparing right most value
            // All values to the left of the currentValue is already sorted as per the Insertion sort Algorithm
            currentValue = numbers[i];
            // Comparing currentValue with value to the left of it
            int j = i - 1;

            //
            // Compares currentValue to the value on its left and shifts every value to the right
            while(j >= 0 && numbers[j] > currentValue){
                // Shifts the numbers in order to the right until the loop evaluates to false
                numbers[j + 1] = numbers[j];
                j--;
            }
            // Inserting currentValue where the loop evaluated to false, indicating its order in the list
            numbers[j + 1] = currentValue;
        }

        // Prints numbers of array
        for(int i : numbers){
            System.out.print(i + "\t");
        }
    }
}
