package io;

import data.CustomerData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SuccessCSVTest {

    @Test
    void write() {
        File fileObj = new File("src/test/play_ground/test.csv");
        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
        SuccessCSV.setFilePath(fileObj.getPath());
        CustomerData testData1 = new CustomerData();
        testData1.bookingName = "Sam";
        testData1.flightNumber = "SJ456";
        testData1.seatCategory = "Economy";
        testData1.numberOfSeat = 2;
        testData1.totalPrice = 500;
        CustomerData testData2 = new CustomerData();
        testData2.bookingName = "Richard";
        testData2.flightNumber = "BY110";
        testData2.seatCategory = "Premium Economy";
        testData2.numberOfSeat = 2;
        testData2.totalPrice = 1000;
        SuccessCSV.write(testData1);
        SuccessCSV.write(testData2);

        try {
            Scanner myReader = new Scanner(fileObj);
            assertEquals("Booking name, flight number, Category, number of seats booked, total price", myReader.nextLine());
            assertEquals("Sam,SJ456,Economy,2,500", myReader.nextLine());
            assertEquals("Richard,BY110,Premium Economy,2,1000", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTrue(fileObj.delete());
    }
}