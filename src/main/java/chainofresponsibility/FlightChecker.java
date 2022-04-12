package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;

public class FlightChecker extends Agent {
    public FlightChecker() {
        this.agentName = "FlightChecker";
        this.reason = "invalid flight number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        endSuccess = false;
        FlightDB.getInstance();
        if(FlightDB.checkFlightExist(customerData.flightNumber)) {
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
