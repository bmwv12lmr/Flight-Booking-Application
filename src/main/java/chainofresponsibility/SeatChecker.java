package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class SeatChecker extends Agent {
    public SeatChecker() {
        this.agentName = "SeatChecker";
        this.reason = "invalid seat number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        endSuccess = false;
        FlightDB.getInstance();
        if(FlightDB.checkSeatAvail(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat)) {
            if (getNext() != null) {
                getNext().handleRequest(customerData);
            }
            else{
                leaveSuccess();
            }
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }
}
