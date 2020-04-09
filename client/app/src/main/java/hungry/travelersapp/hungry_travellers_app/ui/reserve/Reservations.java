package hungry.travelersapp.hungry_travellers_app.ui.reserve;

public class Reservations {

    String reservationId;
    String reservationName;
    String reservationNumber;
    String reservationAmount;
    String reservationDate;


    public Reservations() {

    }

    public Reservations(String reservationId, String reservationAmount, String reservationName, String reservationNumber, String reservationDate) {
        this.reservationId = reservationId;
        this.reservationAmount = reservationAmount;
        this.reservationName = reservationName;
        this.reservationNumber = reservationNumber;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() { return reservationId; }

    public String getReservationAmount() {
        return reservationAmount;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }
}