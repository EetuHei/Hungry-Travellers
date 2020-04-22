package hungry.travelersapp.hungry_travellers_app.ui.reserve;

public class Reservations {

    String reservationId;
    String reservationName;
    String reservationNumber;
    String reservationAmount;
    String reservationDate;
    String reservationTime;


    public Reservations() {

    }

    public Reservations(String reservationId, String reservationAmount, String reservationName, String reservationNumber, String reservationDate, String reservationTime) {
        this.reservationId = reservationId;
        this.reservationAmount = reservationAmount;
        this.reservationName = reservationName;
        this.reservationNumber = reservationNumber;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
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

    public String getReservationTime() { return reservationTime; }
}