package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class PriceCalculator extends Agent {
    public PriceCalculator() {
        this.agentName = "PriceCalculator";
        this.reason = "invalid price number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        endSuccess = false;
        FlightDB.getInstance();
        customerData.totalPrice = FlightDB.calculatePrice(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat);
        if(customerData.totalPrice != -1) {
            if (getNext() != null) {
                getNext().handleRequest(customerData);
            }else {
                leaveSuccess();
            }
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }
}

