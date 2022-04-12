package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlightDBTest {

    void init() {
        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();
    }

    @Test
    void checkFlightExist() {
        init();
        assertTrue(FlightDB.checkFlightExist("SJ456"));
        assertFalse(FlightDB.checkFlightExist("CB123"));
    }

    @Test
    void checkSeatAvail() {
        init();
        assertTrue(FlightDB.checkSeatAvail("BY110", "Premium Economy", 5));
        assertFalse(FlightDB.checkSeatAvail("SJ456","Economy", 10 ));
    }

    @Test
    void calculatePrice() {
        init();
        assertEquals(2500, FlightDB.calculatePrice("BY110", "Premium Economy", 5));
    }

    @Test
    void bookFlight() {
        init();
        assertTrue(FlightDB.checkSeatAvail("BY110", "Premium Economy", 5));
        FlightDB.bookFlight("BY110", "Premium Economy", 5);
        assertFalse(FlightDB.checkSeatAvail("BY110", "Premium Economy", 5));
    }
}