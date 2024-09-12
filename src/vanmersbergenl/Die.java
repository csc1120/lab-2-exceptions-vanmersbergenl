/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Landon Van Mersbergen
 * Last Updated: 9/12/2024
 */
package vanmersbergenl;

import java.util.Random;

/**
 * Die class used for creating dice
 */
public class Die {
    /**
     * the minimum number of sides a die can have
     */
    public static final int MIN_SIDES = 2;
    /**
     * the maximum number of sides a die can have
     */
    public static final int MAX_SIDES = 100;
    private int currentValue = 0;
    private int numSides;
    private final Random random = new Random();

    /**
     * Creates a new Die
     * @param numSides the number of sides for the die
     * @throws IllegalArgumentException when numSides is out of bounds
     */
    public Die(int numSides) throws IllegalArgumentException {
        if(numSides > MAX_SIDES || numSides < MIN_SIDES){
            throw new IllegalArgumentException("Bad die creation: " +
                    "Illegal number of sides: " + numSides);
        }
        this.numSides = numSides;
    }

    /**
     * Gets the current value of the die
     * @return the currentValue of the die after the last roll
     * @throws DieNotRolledException if currentValue was already returned or called before rolling
     */
    public int getCurrentValue() throws DieNotRolledException {
        if (currentValue == 0){
            throw new DieNotRolledException();
        }
        int temp = currentValue;
        currentValue = 0;
        return temp;
    }

    /**
     * Rolls the Die. Sets the current value to a number between 1 and the number of sides
     */
    public void roll(){
        currentValue = random.nextInt(0, numSides) + 1;
    }
}