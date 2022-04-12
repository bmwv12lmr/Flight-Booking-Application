package command;

import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import static org.junit.jupiter.api.Assertions.*;

class InvokerTest {

    @Test
    void executeCommand() {
        FileHandler fileHandler = new FileHandler("src/test/data/flights.csv");
        Command dbInitializer = new DBInitializer(fileHandler);
        Invoker invoker = new Invoker();
        invoker.setCommand(dbInitializer);
        invoker.executeCommand();
        assertTrue(FlightDB.checkFlightExist("SJ456"));
    }
}