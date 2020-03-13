# Arrays  

### What are Arrays?  

Arrays are data structures that organizes and stores data sequentially (indexed).  
There are 2 types of arrays:  
  - Static Arrays: Used in lower level languages like C++ and Java where a fixed memory is allocated for the size of the array.
  - Dynamic Arrays: Used in higher level languages like JavaScript where memory is automatically allocated and resized underneath the hood.  

### Building an Array  

Although array is already a built-in Class within Java, the following Java code demonstrates a dynamic array data structure built from scratch. The following MyArray class has been equip with all the methods for adding, manipulating and deleting data to the data structure.  
The Java code can be found here: [MyArray.java class](./src/datastructures/arrays/MyArray.java)  

By instantiating and utilizing the MyArray class, we get the following outputs on our [Main.java](./src/datastructures/arrays/Main.java)  

```Java
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
```  

### Examples Working with Arrays  

##### Reverse String  

```Java
public class ReverseString {

    public static void main(String[] args) {

        // Call reverse Function
        reverse("Hello, World"); // Outputs and Prints "dlroW ,olleH"
    }

    // Takes in a String argument and outputs the reversed version of the String.
    // Strings are by nature an array of Characters in sequence.
    // Using the split and join methods, successfully reverse the sequence of characters

    public static String reverse(String input){

        String[] stringArray = input.split("");
        int arraySize = stringArray.length;
        String[] reversedArray = new String[arraySize];

        for(int i = arraySize - 1; i>=0; i--){
            reversedArray[(arraySize-1)-i] = stringArray[i];
        }

        String reversedString = String.join("", reversedArray);

        System.out.println(reversedString);
        return reversedString;
    }
}
```  

##### Merge Sorted Arrays  

```Java
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
```  

### When to Use an Array  

##### Pros:  
  - Fast Lookups
  - Fast Push/Pop
  - Ordered/Sequential  

##### Cons:  
  - Slow Inserts
  - Slow Deletes
  - Fixed Sizes for Static Arrays  
