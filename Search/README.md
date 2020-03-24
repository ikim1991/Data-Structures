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

### Depth First Search  



##### Implementing Depth First Search  



### Breadth First Search  



##### Implementing Breadth First Search  
