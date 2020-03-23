# Algorithms: Sorting  

### Bubble Sort  

Bubble Sort is a basic sorting algorithm. Bubble sorts work by bubbling up or bubbling down the largest or smallest number. It is a brute force approach where we are trying every possible combination utilizing nested loops. This gives us a time complexity of quadratic time, O($n^2$), and a space complexity of O(1).  

##### Implementing Bubble Sort  

[BubbleSort class](./src/algorithms/sorting/BubbleSort.java)  

```Java
public class BubbleSort {

    public static void main(String[] args) {
        // Array of random numbers to be sorted
        int[] numbers = {99, 4, 29, 9, 7, 0, 5, 6, 1, 69};

        // Call bubbleSort method
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
```  

### Selection Sort  

Selection sort is another basic sorting algorithm much like the Bubble Sort, it has a time complexity of quadratic time, O($n^2$) and a space complexity of O(1). The algorithm works way through the list and starts off by finding the minimum value. It is then place at the first index, moving up an index every iteration.  

##### Implementing Selection Sort  

[SelectionSort class](./src/algorithms/sorting/SelectionSort.java)

```Java
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
```  

### Insertion Sort  

Insertion sort is another basic sorting algorithm that works best with small datasets or lists that are nearly sorted. In best case scenario it can achieve a time complexity of linear time, O(n). Insertion sort works as if we to sort playing cards in our hand, indexing up, we move sort from right to left.

##### Implementing Insertion Sort  

[SelectionSort class](./src/algorithms/sorting/InsertionSort.java)  

```Java
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
```  

### Merge Sort  



##### Implementing Merge Sort  

[SelectionSort class](./src/algorithms/sorting/MergeSort.java)  

```Java



```  

### Quick Sort  


##### Implementing Quick Sort  

[SelectionSort class](./src/algorithms/sorting/QuickSort.java)  

```Java



```  
