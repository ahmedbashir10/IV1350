package se.kth.iv1350.POS.integration.Exceptions;

/**
 * An unchecked exception that is thrown when database access is unsuccessful
 */
public class DatabaseAccessException extends RuntimeException{
    /**
     * Is thrown when something is wrong with accessing the database.
     * @param message The message that explains why the exception is thrown.
     */
    public DatabaseAccessException(String message) {
        super(message);
    }
}
