package custom_exceptions;

public class DurationLimitException extends Exception {

    public DurationLimitException() {
        super("The reserve duration limit is 6 hours.");
    }
}
