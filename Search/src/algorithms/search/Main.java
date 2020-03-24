package algorithms.search;

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
