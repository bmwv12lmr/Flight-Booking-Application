package chainofresponsibility;

import data.CustomerData;
import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void handleRequest() {
        CustomerData data = new CustomerData();
        data.bookingName = "Sam";
        data.flightNumber = "SJ456";
        data.seatCategory = "Economy";
        data.numberOfSeat = 2;
        data.totalPrice = 500;

        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();

        Agent priceCalculator = new PriceCalculator();
        priceCalculator.handleRequest(data);
        assertTrue(priceCalculator.endSuccess);
    }
}