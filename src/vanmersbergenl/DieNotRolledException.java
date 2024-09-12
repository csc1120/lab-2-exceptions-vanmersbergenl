/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Landon Van Mersbergen
 * Last Updated: 9/12/2024
 */
package vanmersbergenl;

/**
 * Exception thrown when the value of the die is read before it is rolled
 */
public class DieNotRolledException extends RuntimeException {
    @Override
    public String getMessage(){
        return "getCurrentValue() cannot be called before rolling";
    }
}
