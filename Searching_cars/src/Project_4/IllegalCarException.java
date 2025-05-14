package Project_4;

/**
 * Custom exception class for invalid car data.
 * Extends IllegalArgumentException to handle cases where car data is invalid
 * or improperly formatted.
 */
public class IllegalCarException extends IllegalArgumentException {
    /**
     * Constructor creates a new Project_4.IllegalCarException with the specified error message.
     * @param message The detailed error message explaining why the car data is invalid
     */
    public IllegalCarException(String message) {
        super(message);
    }
}
