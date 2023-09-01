package execption;

/**
 * The type Result not found exception.
 */
public class ResultNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Result not found exception.
     */
    public ResultNotFoundException() {
        super();
    }

    /**
     * Instantiates a new Result not found exception.
     *
     * @param message the message
     */
    public ResultNotFoundException(String message) {
        super(message);
    }
}
