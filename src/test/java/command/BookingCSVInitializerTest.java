package command;

import io.ErrorTxt;
import io.SuccessCSV;
import org.junit.jupiter.api.Test;
import singleton.FlightDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingCSVInitializerTest {

    @Test
    void execute() {
        FlightDB.setFilePath("src/test/data/flights.csv");
        FlightDB.getInstance();
        File errorFileObj = new File("src/test/play_ground/test.txt");
        File successFileObj = new File("src/test/play_ground/test.csv");
        ErrorTxt.setFilePath(errorFileObj.getPath());
        SuccessCSV.setFilePath(successFileObj.getPath());

        FileHandler fileHandler = new FileHandler("src/test/data/Sample.csv");
        Command bookingCSVInitializer = new BookingCSVInitializer(fileHandler);

        bookingCSVInitializer.execute();

        try {
            Scanner myReader = new Scanner(successFileObj);
            assertEquals("Booking name, flight number, Category, number of seats booked, total price", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}