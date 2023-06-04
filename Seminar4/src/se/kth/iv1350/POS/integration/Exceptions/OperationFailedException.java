package se.kth.iv1350.POS.integration.Exceptions;

/**
 * Is thrown when other exceptions from other type of layers is throwing too detailed exceptions
 */
public class OperationFailedException extends Exception{

    /**
     * The exception that is thrown
     * @param message Information about the thrown exception
     * @param cause The exceptions that caused this exception to be thrown.
     */
    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
