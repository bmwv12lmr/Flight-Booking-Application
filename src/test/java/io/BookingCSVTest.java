package io;

import data.CustomerData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingCSVTest {

    @Test
    void read() {
        BookingCSV obj = new BookingCSV();
        ArrayList<CustomerData> read_list = obj.read("src/test/data/Sample.csv");
        assertEquals("Sam", read_list.get(0).bookingName);
        assertEquals("SJ456", read_list.get(0).flightNumber);
        assertEquals("Economy", read_list.get(0).seatCategory);
        assertEquals(2, read_list.get(0).numberOfSeat);
        assertEquals("5410000000000000", read_list.get(0).paymentCardNumber);

        assertEquals("Sierra", read_list.get(4).bookingName);
        assertEquals("BY110", read_list.get(4).flightNumber);
        assertEquals("Business", read_list.get(4).seatCategory);
        assertEquals(1, read_list.get(4).numberOfSeat);
        assertEquals("1234561323130", read_list.get(4).paymentCardNumber);
    }
}