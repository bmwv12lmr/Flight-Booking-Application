package chainofresponsibility;

import data.CustomerData;
import singleton.FlightDB;
import io.SuccessCSV;

public class FlightBooker extends Agent {
    @Override
    public void handleRequest(CustomerData customerData) {
        FlightDB obj = FlightDB.getInstance();
        obj.bookFlight(customerData.flightNumber, customerData.seatCategory, customerData.numberOfSeat);
        SuccessCSV.write(customerData);
    }
}