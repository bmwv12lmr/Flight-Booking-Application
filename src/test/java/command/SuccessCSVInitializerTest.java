package command;

import data.CustomerData;
import io.SuccessCSV;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SuccessCSVInitializerTest {

    @Test
    void execute() {
        FileHandler fileHandler = new FileHandler("src/test/play_ground/test.csv");
        Command successCSVInitializer = new SuccessCSVInitializer(fileHandler);
        successCSVInitializer.execute();
        CustomerData data = new CustomerData();
        SuccessCSV.write(data);
        File fileObj = new File("src/test/play_ground/test.csv");

        try {
            Scanner myReader = new Scanner(fileObj);
            assertEquals("Booking name, flight number, Category, number of seats booked, total price", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}