package command;

import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import static org.junit.jupiter.api.Assertions.*;

class DBInitializerTest {

    @Test
    void execute() {
        FileHandler fileHandler = new FileHandler("src/test/data/flights.csv");
        Command cmd = new DBInitializer(fileHandler);
        cmd.execute();
        assertTrue(FlightDB.checkFlightExist("SJ456"));
    }
}