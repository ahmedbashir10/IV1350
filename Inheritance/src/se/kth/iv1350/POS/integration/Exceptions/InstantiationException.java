package se.kth.iv1350.POS.integration.Exceptions;

/**
 * A checked exception that is thrown when an instance of a class is not created as desired.
 */
public class InstantiationException extends Exception{
    public InstantiationException(String message) {
        super(message);
    }
}
