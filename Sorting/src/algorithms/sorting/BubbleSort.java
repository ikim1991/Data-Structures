package algorithms.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        // Array of random numbers to be sorted
        int[] numbers = {99, 4, 29, 9, 7, 0, 5, 6, 1, 69};

        // Call bubbleSort method on numbers array
        bubbleSort(numbers);
        // Prints -->   0	1	4	5	6	7	9	29	69	99
    }


    // Bubble Sort Method
    private static void bubbleSort(int[] numbers){
        int placeHolder;
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] > numbers[j]){
                    placeHolder = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = placeHolder;
                }
            }
        }

        for(int i : numbers){
            System.out.print(i + "\t");
        }
    }
}
