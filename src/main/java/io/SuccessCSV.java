package io;
import data.CustomerData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SuccessCSV {
    static private FileWriter fileHandler = null;
    static private String filePath = null;
    static private SuccessCSV instance = null;

    private SuccessCSV() {
        File newFile = new File(filePath);
        try {
            if (newFile.createNewFile()) {
                fileHandler = new FileWriter(filePath);
                fileHandler.write("Booking name, flight number, Category, number of seats booked, total price\n");
                fileHandler.flush();
            } else {
                System.out.println("Error: File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean initFilePath(){
        if (instance == null) {
            if (filePath != null) {
                instance = new SuccessCSV();
            }
            else {
                System.out.println("Error: filePath is not set!");
                return false;
            }
        }
        return true;
    }

    public static synchronized void write(CustomerData customerData) {
        if (initFilePath()) {
            try {
                fileHandler.write(
                                customerData.bookingName + "," + customerData.flightNumber + "," +
                                customerData.seatCategory + "," + customerData.numberOfSeat + "," +
                                (int) customerData.totalPrice + "\n");
                fileHandler.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void setFilePath(String filePath) {
        SuccessCSV.filePath = filePath;
    }
}
