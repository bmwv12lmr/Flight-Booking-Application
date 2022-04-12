package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;
import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FlightCheckerTest {

    @Test
    void handleRequest() {
        CustomerData data = new CustomerData();


        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();

        Agent flightChecker = new FlightChecker();
        data.flightNumber = "SJ456";
        data.bookingName = "Allen";
        flightChecker.handleRequest(data);
        assertTrue(flightChecker.endSuccess);

        data.flightNumber = "BB123";
        data.bookingName = "Bob";

        String fileName = "error_" + System.currentTimeMillis() + ".txt";

        File fileObj = new File("src/test/play_ground/" + fileName);
        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
        ErrorTxt.setFilePath(fileObj.getPath());
        flightChecker.handleRequest(data);
        assertFalse(flightChecker.endSuccess);

        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
    }
}