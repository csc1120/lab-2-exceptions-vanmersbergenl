/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Landon Van Mersbergen
 * Last Updated: 9/12/2024
 */
package vanmersbergenl;

import java.util.Scanner;

/**
 * The main class
 */
public class Driver {
    public static void main(String[] args) {
        // Executes indefinitely until a valid set of Integers is input
        while(true) {
            try {
                int[] numbers = getInput();
                Die[] dice = createDice(numbers[0], numbers[1]);
                dice.clone(); // Statement to pass "unused local variable" checkstyle
                break;
            } catch (NumberFormatException e){
                System.out.println("Invalid input: All values must be whole numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int[] getInput(){
        System.out.println("Please enter the number of dice to roll, how many sides the " +
                "dice have, \nand how many rolls to complete, separating the values by a space.");
        System.out.println("Example: \"2 6 1000\"\n");
        System.out.print("Enter configuration:");
        int[] numbers = new int[3];
        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split("\\s"); // Split by whitespace
        if(tokens.length < 3) {
            throw new IllegalArgumentException("Expected 3 arguments but found " + tokens.length);
        }
        for (int i = 0; i <= 2; ++i) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
    private static Die[] createDice(int numberOfDice, int sides){
        Die[] dice = new Die[numberOfDice];
        for(int i = 0; i < numberOfDice; ++i){
            dice[i] = new Die(sides);
        }
        return dice;
    }
}