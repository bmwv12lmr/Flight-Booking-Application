package io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ErrorTxtTest {

    @Test
    void write() {
        File fileObj = new File("src/test/play_ground/test.txt");
        ErrorTxt.setFilePath(fileObj.getPath());
        ErrorTxt.write("Person 1", "Credit Card Error");
        ErrorTxt.write("Person 2", "Lack of Seat");

        try {
            Scanner myReader = new Scanner(fileObj);
            assertEquals("Please enter correct booking details for Person 1: Credit Card Error", myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}