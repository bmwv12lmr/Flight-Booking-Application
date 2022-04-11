package io;

import data.FlightData;

import java.util.ArrayList;

public class FlightCSVTest {
    public static void main(String[] args) {
        FlightCSV obj = new FlightCSV();
        ArrayList<FlightData> read_list = obj.read("/Users/yswu/IdeaProjects/IndividualProject/src/test/flights.csv");
        for (FlightData read : read_list) {
            System.out.print(read.seatCategory + " | ");
            System.out.print(read.flightNumber + " | ");
            System.out.print(read.availableSeats + " | ");
            System.out.print(read.price + " | ");
            System.out.print(read.arrival + " | ");
            System.out.println(read.departure);
        }
    }
}
