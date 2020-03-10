# The Big-O  

### What is Big-O?  

The Big-O measures the scalability, or the time efficiency, of an algorithm. In other words, it is a measure of how long it takes the algorithm to solve the problem relative to its input size.  
For example, we know that the bigger the size of an input, the larger the number of operations that the algorithm needs to perform. Now we need to consider how the runtime of an algorithm grows as the size of the input grows.  

### The Big-O Notation  

<div style="text-align: center"><img src="./big_o_complexity_chart.jpeg" /></div>  

##### Linear Time O(n)  

In linear time, the number of operations in an algorithm grows linearly to the size of the input. For example, the Java code below illustrates a loop function which prints each element of an array. The run time of the input sizes: 1, 10, 100, and 1000, in nanoseconds is approximately 724500, 1454800, 3625399, and 31344801. The run time outputs will vary every time and will depend on the CPU of your system but we can see that it is linearly increasing.  

```Java
public class LinearTime {
    // Initializing Array that stores integer values
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    // Initializing Array that stores the Input Size
    private static Integer[] inputs = {1, 10, 100, 1000};
    // Initializing Array that stores the run times
    private static ArrayList<Long> runTimes = new ArrayList<Long>();

    public static void main(String[] args) {

        // Initialize start time and stop time to measure execution time using System.nanoTime()
        long startTime;
        long stopTime;

        // Loops for each item in the inputs array, measures the run time of each input size and stores it into the runTimes array
        for(int i = 0; i<inputs.length; i++){
            addToList(inputs[i]);
            startTime = System.nanoTime();
            printNumber(numbers);
            stopTime = System.nanoTime();
            runTimes.add(stopTime - startTime);
            numbers.clear();
        }

        // Prints the run times of each iteration from above
        for(Long runTime : runTimes){
            System.out.print(runTime+"\t");
        }

    }

    // Method takes in an integer as an argument and adds the number to the numbers array in increments
    public static void addToList(int number){
        if(number > 0){
            for(int i = 0; i<=number; i++){
                numbers.add(i);
            }
        }
    }

    // Method call prints each element in our array
    public static void printNumber(ArrayList<Integer> a){
        for(int i = 0; i<a.size(); i++){
            System.out.println(i);
        }
    }
}
```  
[LinearTime.java code](./src/datastructures/bigO/LinearTime.java)  

##### Constant Time O(1)  

In constant time, the number of operations in an algorithm is irrelevant to the size of the input. For example, when we are searching from an item in an array where we already know the index location of the element, we will always find it in constant time. For example, the Java code below illustrates a function that gets the element at the i-th index. The run time of the input sizes: 10, 100, 1000, and 10000, in nanoseconds is approximately 384300, 137200, 193600, and 137200. The run time outputs will vary every time and will depend on the CPU of your system but we can see that the run times are consistent. There is a factor of randomness but keep in mind that the time is in nanoseconds.  

```Java
public class ConstantTime {
    // Initializing Array that stores integer values
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    // Initializing Array that stores the Input Size
    private static Integer[] inputs = {10, 100, 1000, 10000};
    // Initializing Array that stores the run times
    private static ArrayList<Long> runTimes = new ArrayList<Long>();

    public static void main(String[] args) {

        // Initialize start time and stop time to measure execution time using System.nanoTime()
        long startTime;
        long stopTime;

        // Loops for each item in the inputs array, measures the run time of each input size and stores it into the runTimes array
        for(int i = 0; i<inputs.length; i++){
            addToList(inputs[i]);
            startTime = System.nanoTime();
            printNumber(numbers, 5);
            stopTime = System.nanoTime();
            runTimes.add(stopTime - startTime);
            numbers.clear();
        }

        // Prints the run times of each iteration from above
        for(Long runTime : runTimes){
            System.out.print(runTime+"\t");
        }
    }

    // Method takes in an integer as an argument and adds the number to the numbers array in increments
    public static void addToList(int number){
        if(number > 0){
            for(int i = 0; i<=number; i++){
                numbers.add(i);
            }
        }
    }

    // Method prints each element of the array
    public static void printNumber(ArrayList<Integer> a, Integer i){
        System.out.println(a.get(i));
    }
}
```  
[ConstantTime.java code](./src/datastructures/bigO/ConstantTime.java)  

##### Quadratic Time O($n^2$)  

In quadratic time, the number of operations grows quadratically in relation to the input size. This usually occurs when every element in a collection needs to be compared to one another, such as in nested loops. In the case of a three nested loop, the Big-O Notation would become O($n^3$). For example, the Java code below illustrates a nested loop function which prints each element of an array in 2-dimension. The run time of the input sizes: 1, 10, 100, and 1000, in nanoseconds is approximately 36815200, 10596500, 199621800, 9489535600	. The run time outputs will vary every time and will depend on the CPU of your system. Although there is randomness to the run time outputs, we can clearly see that when the input size is 1000, it takes a significantly longer time to compute than the other cases.

```Java
public class QuadraticTime {
    // Initializing Array that stores integer values
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    // Initializing Array that stores the Input Size
    private static Integer[] inputs = {1, 10, 100, 1000};
    // Initializing Array that stores the run times
    private static ArrayList<Long> runTimes = new ArrayList<Long>();

    public static void main(String[] args) {

        // Initialize start time and stop time to measure execution time using System.nanoTime()
        long startTime;
        long stopTime;

        // Loops for each item in the inputs array, measures the run time of each input size and stores it into the runTimes array
        for(int i = 0; i<inputs.length; i++){
            addToList(inputs[i]);
            startTime = System.nanoTime();
            nestedLoop(numbers);
            stopTime = System.nanoTime();
            runTimes.add(stopTime - startTime);
            nestedLoop(numbers);
            numbers.clear();
        }

        // Prints the run times of each iteration from above
        for(Long runTime : runTimes){
            System.out.print(runTime+"\t");
        }
    }

    // Method takes in an integer as an argument and adds the number to the numbers array in increments
    public static void addToList(int number){
        if(number > 0){
            for(int i = 0; i<=number; i++){
                numbers.add(i);
            }
        }
    }

    // A method that calls a loop within a loop, or a nested loop that prints each element in 2-dimensions
    public static void nestedLoop(ArrayList<Integer> a){
        int num = 0;
        for(int i = 0; i<a.size(); i++){
            for(int j=0; j<a.size(); j++){
                System.out.println(i + ", " + j);
            }
        }
    }
}
```  
[QuadraticTime.java code](./src/datastructures/bigO/QuadraticTime.java)  

##### Factorial Time O(n!)  

In factorial time, the number of operation grows as a function of a nested loop per input size. Meaning we are nesting loops for every element. This is the most computationally expensive and an unlikely scenario.  


### The 4 Rules of Big-O  

##### Rule 1: Worst Case  

Always consider the worst case scenario when analyzing the run time of an algorithm. For example, a searching algorithm with an O(n) could achieve its results in O(1) by chance in a best-case scenario.  

##### Rule 2: Remove Constants  

In the grand scheme, we are interested in scalability. When determining the time complexity, we drop any constants. For example, O(2n) would become O(n) or O(3n+10) would also become O(n).  

##### Rule 3: Different Terms for Inputs  

Different inputs have different variables when determining the Big-O Notation. When dealing with nested functions, the Big-O Notation becomes the multiplication of the two variables. For example, if there is a nested loop of n and m, and n $\approx$ m, then the Big-O Notation is O(n*m) or just O($n^2$).  

##### Rule 4: Drop Non Dominants  

In the grand scheme, we are interested in scalability. When determining the time complexity, we drop the non-dominant variables. For example, O($n^2$ + 4n + 10) would become O($n^2$).
