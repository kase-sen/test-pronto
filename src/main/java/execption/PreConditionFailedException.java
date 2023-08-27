package execption;

public class PreConditionFailedException extends RuntimeException {

    public PreConditionFailedException() {
        super();
    }

    public PreConditionFailedException(String message) {
        super(message);
    }
}
