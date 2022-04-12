package io;

import data.FlightData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlightCSVTest {

    @Test
    void read() {
        FlightCSV obj = new FlightCSV();
        ArrayList<FlightData> read_list = obj.read("src/test/data/flights.csv");
        assertEquals("Economy", read_list.get(0).seatCategory);
        assertEquals("SJ456", read_list.get(0).flightNumber);
        assertEquals(5, read_list.get(0).availableSeats);
        assertEquals(250.0, read_list.get(0).price);
        assertEquals("Seattle", read_list.get(0).arrival);
        assertEquals("San Jose", read_list.get(0).departure);

        assertEquals("Business", read_list.get(4).seatCategory);
        assertEquals("CA453", read_list.get(4).flightNumber);
        assertEquals(5, read_list.get(4).availableSeats);
        assertEquals(1500.0, read_list.get(4).price);
        assertEquals("Seattle", read_list.get(4).arrival);
        assertEquals("San Jose", read_list.get(4).departure);

    }
}