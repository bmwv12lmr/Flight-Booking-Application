package io;

import data.CustomerData;

public class SuccessCSVTest {
    public static void main(String[] args) {
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
        SuccessCSV.setFilePath("/Users/yswu/IdeaProjects/IndividualProject/src/test/play_ground/test.csv");
        SuccessCSV.write(testData1);
        SuccessCSV.write(testData2);
    }
}
