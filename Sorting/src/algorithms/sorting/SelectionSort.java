package algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        // Array of random numbers to be sorted
        int[] numbers = {99, 4, 29, 9, 7, 0, 5, 6, 1, 69};

        // Call selectionSort method on numbers array
        selectionSort(numbers);
        // Prints ->    0	1	4	5	6	7	9	29	69	99
    }

    // Selection Sort Method
    private static void selectionSort(int[] numbers){

        int min;
        int minIndex;

        for(int i = 0; i < numbers.length; i++){
            // Set Current Index has minimum
            min = numbers[i];
            minIndex = i;
            // Loop through to find minimum
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[j] < min){
                    min = numbers[j];
                    minIndex = j;
                }
            }
            // Swap and Set Current Index with new Minimum
            numbers[minIndex] = numbers[i];
            numbers[i] = min;
        }

        // Prints List
        for(int i : numbers){
            System.out.print(i + "\t");
        }
    }
}
