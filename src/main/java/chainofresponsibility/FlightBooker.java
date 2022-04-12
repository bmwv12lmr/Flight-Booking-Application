package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;
import io.SuccessCSV;

public class FlightBooker extends Agent {
    public FlightBooker() {
        this.agentName = "FlightBooker";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        FlightDB.getInstance();
        FlightDB.bookFlight(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat);
        SuccessCSV.write(customerData);
        leaveSuccess();
    }
}