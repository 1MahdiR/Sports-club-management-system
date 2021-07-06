package custom_exceptions;

public class ReservationDatePassedException extends Exception {

    public ReservationDatePassedException() {
        super("Reservation date can not be a date before now.");
    }
}
