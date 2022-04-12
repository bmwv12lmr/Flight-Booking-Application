package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class SeatChecker extends Agent {
    public SeatChecker() {
        this.reason = "invalid seat number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        FlightDB.getInstance();
        if(FlightDB.checkSeatAvail(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat)) {
            getNext().handleRequest(customerData);
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }
}
