package io;

import data.CustomerData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingCSV {
    public static final String delimiter = ",";
    public ArrayList<CustomerData> read(String filePath) {
        ArrayList<CustomerData> customerData = new ArrayList<>();
        try {
            File customerFile = new File(filePath);
            Scanner CsvLine = new Scanner(customerFile);
            boolean headerLine = true;
            while (CsvLine.hasNextLine()) {
                String line = CsvLine.nextLine();
                if (headerLine) {
                    headerLine = false;
                    continue;
                }
                CustomerData data = new CustomerData();
                String[] tempArr = line.split(delimiter);
                data.bookingName = tempArr[0];
                data.flightNumber = tempArr[1];
                data.seatCategory = tempArr[2];
                data.numberOfSeat = Integer.parseInt((tempArr[3]));
                data.paymentCardNumber = tempArr[4];
                customerData.add(data);
            }
            CsvLine.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customerData;
    }
}
