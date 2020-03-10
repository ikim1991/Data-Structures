package datastructures.bigO;

import java.util.ArrayList;

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
