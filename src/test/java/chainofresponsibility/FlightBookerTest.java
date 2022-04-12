package chainofresponsibility;

import data.CustomerData;
import io.SuccessCSV;
import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FlightBookerTest {

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

        File fileObj = new File("src/test/play_ground/test.csv");
        SuccessCSV.setFilePath(fileObj.getPath());

        Agent flightBooker = new FlightBooker();
        flightBooker.handleRequest(data);

        try {
            Scanner myReader = new Scanner(fileObj);
            assertEquals("Booking name, flight number, Category, number of seats booked, total price", myReader.nextLine());
            assertEquals("Sam,SJ456,Economy,2,500", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}