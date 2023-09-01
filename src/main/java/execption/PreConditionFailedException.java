package execption;

/**
 * The type Pre condition failed exception.
 */
public class PreConditionFailedException extends RuntimeException {

    /**
     * Instantiates a new Pre condition failed exception.
     */
    public PreConditionFailedException() {
        super();
    }

    /**
     * Instantiates a new Pre condition failed exception.
     *
     * @param message the message
     */
    public PreConditionFailedException(String message) {
        super(message);
    }
}
