package command;

import io.ErrorTxt;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ErrorTxtInitializerTest {

    @Test
    void execute() {
        File fileObj = new File("src/test/play_ground/test.txt");
        FileHandler fileHandler = new FileHandler(fileObj.getPath());
        Command command = new ErrorTxtInitializer(fileHandler);
        command.execute();
        ErrorTxt.write("Person 1", "Credit Card Error");
        try {
            Scanner myReader = new Scanner(fileObj);
            assertEquals("Please enter correct booking details for Person 1: Credit Card Error", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}