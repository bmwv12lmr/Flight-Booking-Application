package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class FlightChecker extends Agent {
    public FlightChecker() {
        this.reason = "invalid flight number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        FlightDB obj = FlightDB.getInstance();
        if(obj.checkFlightExist(customerData.flightNumber)) {
            getNext().handleRequest(customerData);
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }

}
