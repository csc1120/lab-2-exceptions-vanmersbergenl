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
        int[] inputs;
        Die[] dice;
        while(true) {
            try {
                inputs = getInput();
                dice = createDice(inputs[0], inputs[1]);
                break;
            } catch (NumberFormatException e){
                System.out.println("Invalid input: All values must be whole numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int[] results = rollDice(dice, inputs[1], inputs[2]);
        //System.out.println(findMax(results));
        report(inputs[0], results, findMax(results));
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
    private static int[] rollDice(Die[] dice, int numSides, int numRolls){

        int[] results = new int[numSides * dice.length - (dice.length-1)];

        for(int i = 0; i < numRolls; ++i){
            int roll = 0;
            for(Die die : dice){
                die.roll();
                roll += die.getCurrentValue();
            }
            results[roll-dice.length]++;
        }
        return results;
    }
    private static int findMax(int[] results){
        int max = 0;
        for(int rolls : results){
            if(rolls > max){
                max = rolls;
            }
        }
        return max;
    }
    private static void report(int numDice, int[] rolls, int max){
        final int scale = max / 10;
        for(int i = 0; i < rolls.length; ++i){
            System.out.printf("%-2d:%-10d ", i + numDice, rolls[i]);
            for(int j = 0; j<rolls[i]/scale; ++j){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}

