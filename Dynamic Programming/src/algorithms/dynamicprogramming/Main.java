package algorithms.dynamicprogramming;

import java.util.HashMap;

public class Main {

    // Initialize Cache
    private static HashMap<Integer, Integer> cache = new HashMap<>();
    // Measures the computation speed of recursion
    private static int recursionComputation = 0;
    // Measures the computation speed using a cache
    private static int cachingComputation = 0;

    public static void main(String[] args) {

        // Fibonacci Sequence
        // 0 1 1 2 3 5 8 13 21 34 55 89 144 233

        // Fibonacci using Recursion
        System.out.println(fibonacci(12)); // Outputs -> 144
        System.out.println("Computating by Recursion: " + recursionComputation); // Prints -> Computating by Recursion: 465

        // Fibonacci using Caching
        System.out.println(fibonacciCache(12)); // Outputs -> 144
        System.out.println("Computating by Caching " + cachingComputation); // Prints -> Computating by Recursion: 465
    }

    // Calculating the Fibonacci Number using Recursion
    public static int fibonacci(int number){
        recursionComputation++;
        if(number <2){
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    // Calculating the Fibonacci Number using Cache
    public static int fibonacciCache(int number){
        cachingComputation++;
        if(cache.containsKey(number)){
            return cache.get(number);
        } else{
            if(number < 2){
                cache.put(number, number);
                return cache.get(number);
            } else{
                cache.put(number, fibonacciCache(number -1) + fibonacciCache(number - 2));
                return cache.get(number);
            }
        }
    }
}
