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
        data.flightNumber = "SJ456";
        data.seatCategory = "Economy";
        data.numberOfSeat = 2;
        data.totalPrice = 500;

        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();

        Agent seatChecker = new SeatChecker();
        seatChecker.handleRequest(data);
        assertTrue(seatChecker.endSuccess);


        String fileName = "error_" + System.currentTimeMillis() + ".txt";

        File fileObj = new File("src/test/play_ground/" + fileName);
        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
        ErrorTxt.setFilePath(fileObj.getPath());

        data.numberOfSeat = 100;

        seatChecker.handleRequest(data);
        assertFalse(seatChecker.endSuccess);

        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
    }
}