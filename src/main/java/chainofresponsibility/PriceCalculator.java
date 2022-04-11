package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class PriceCalculator extends Agent {
    public PriceCalculator() {
        this.reason = "invalid price number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        FlightDB obj = FlightDB.getInstance();
        customerData.totalPrice = obj.calculatePrice(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat);
        if(customerData.totalPrice != -1) {
            getNext().handleRequest(customerData);
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }
}

