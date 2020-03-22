# Algorithms: Recursion  

### What is Recursion?  

Recursion is a function that refers to itself within the function. It is used when a problem requires a repetition subtasks to be performed, such as searching and sorting tasks. For example, it was previously used to traverse through a binary search tree.  

###### Steps of Recursion  

  1. Define the Base case, a stopper to prevent stack overflow.  
  2. Define the Recursive case, subtask to be performed.  
  3. Return the Recursive and Base cases.  

Every problem solved using a recursive process can also be solved using an iterative process. Recursions allows us to write cleaner and simpler code compared to iterations. Recursion requires additional resources as it has a higher space complexity. In certain cases, recursions can have high time complexities as well, such as using recursion to find the Fibonacci number.  

### Implementing Recursion  

##### Factorial  

The [Factorial class](./src/algorithms/recursion/Factorial.java) demonstrates the use of Recursion to find the value of a factorial. To compare, it also demonstrates the use of an iterative process to find the factorial.  

```Java
public class Factorial {

    public static void main(String[] args) {
        // Recursion: Factorial of 5
        System.out.println(factorialRecursive(5)); // Prints --> 5	4	3	2	1	120

        // Iteration: Factorial of 5
        System.out.println(factorialIterative(5)); // Prints --> 1	2	3	4	5	120
    }

    // Method for finding the factorial recursively
    public static int factorialRecursive(int n){

        // Base Case: Stop when n = 1
        if(n == 1){
            System.out.print(n + "\t");
            return 1;
        }

        // Recursive Case: Call until n = 1
        System.out.print(n + "\t");
        return n * factorialRecursive(n - 1);
    }

    // Method for finding the factorial iteratively
    public static int factorialIterative(int n){

        int factorial = 1;

        for(int i = 1; i <= n; i++){
            System.out.print(i + "\t");
            factorial *= i;
        }

        return factorial;
    }
}
```  

##### Fibonacci Sequence  

The [Fibonacci class](./src/algorithms/recursion/Fibonacci.java) demonstrates the use of Recursion to find the value of the Fibonacci Number. To compare, it also demonstrates the use of an iterative process to find the Fibonacci Number. Using recursion to find the Fibonacci Number may be inefficient as it has time complexity of exponential time, O($2^n$).  

```Java
public class Fibonacci {

    public static void main(String[] args) {

        // Fibonacci Sequence: 0 1 1 2 3 5 8 13 21 34 55 89 144 ...

        // Recursion: Fibonacci Number of 5
        System.out.println(fibonacciRecursive(5)); // Outputs --> 5
        printFibonacci(5); // Prints --> 0	1	1	2	3	5

        // Iterative: Fibonacci Number of 5
        fibonacciIterative(5); // Prints --> 0	1	1	2	3	5
    }

    // Recursive method for finding the Fibonacci number of the input
    public static int fibonacciRecursive(int n){
        if(n < 2){
            return n;
        } else {
            int fibonacci = fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
            return fibonacci;
        }
    }

    // Printing the Fibonacci Sequence
    public static void printFibonacci(int n){
        for(int i = 0; i<=n; i++){
            System.out.print(fibonacciRecursive(i) + "\t");
        }
        System.out.println();
    }

    // Method for finding the Fibonacci number using an iterative process
    public static int fibonacciIterative(int n){

        ArrayList<Integer> fibonacci = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            if(i == 0){
                fibonacci.add(i);
            } else if(i < 2){
                fibonacci.add(i);
            } else{
                fibonacci.add((fibonacci.get(i-1) + fibonacci.get(i-2)));
            }
        }

        // Prints the Fibonacci Sequence
        for(Integer i : fibonacci){
            System.out.print(i +"\t");
        }

        return fibonacci.get(fibonacci.size()-1);
    }
}
```  
