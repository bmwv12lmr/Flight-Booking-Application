package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;
import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SeatCheckerTest {

    @Test
    void handleRequest() {
        CustomerData data = new CustomerData();
        data.bookingName = "Sam";
        data.flightNumber = "CA453";
        data.seatCategory = "Economy";
        data.numberOfSeat = 2;
        data.totalPrice = 600;

        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();

        Agent seatChecker = new SeatChecker();
        seatChecker.handleRequest(data);
        assertTrue(seatChecker.endSuccess);


        File fileObj = new File("src/test/play_ground/test.txt");
        ErrorTxt.setFilePath(fileObj.getPath());

        data.numberOfSeat = 100;

        seatChecker.handleRequest(data);
        assertFalse(seatChecker.endSuccess);
    }
}