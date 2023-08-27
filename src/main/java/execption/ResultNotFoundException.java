package execption;

public class ResultNotFoundException extends RuntimeException {

    public ResultNotFoundException() {
        super();
    }

    public ResultNotFoundException(String message) {
        super(message);
    }
}
