package datastructures.arrays;

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
