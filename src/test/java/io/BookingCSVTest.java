package io;

import data.CustomerData;

import java.util.ArrayList;

public class BookingCSVTest {
    public static void main(String[] args) {
        BookingCSV obj = new BookingCSV();
        ArrayList<CustomerData> read_list = obj.read("/Users/yswu/IdeaProjects/IndividualProject/src/test/Sample.csv");
        for (CustomerData read : read_list) {
            System.out.print(read.bookingName + " | ");
            System.out.print(read.flightNumber + " | ");
            System.out.print(read.seatCategory + " | ");
            System.out.print(read.numberOfSeat + " | ");
            System.out.println(read.paymentCardNumber);
        }
    }
}
