package algorithms.recursion;

import java.util.ArrayList;

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
