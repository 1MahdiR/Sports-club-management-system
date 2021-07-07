package custom_exceptions;

public class ReservationIdNotFoundException extends Exception {

    public ReservationIdNotFoundException() {
        super("Can not find the reservation with this id.");
    }
}
