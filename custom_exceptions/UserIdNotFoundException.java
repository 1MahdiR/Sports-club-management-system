package custom_exceptions;

public class UserIdNotFoundException extends Exception {

    public UserIdNotFoundException() {
        super("Can not find the user with this id.");
    }
}
