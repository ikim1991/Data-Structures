package algorithms.recursion;

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
