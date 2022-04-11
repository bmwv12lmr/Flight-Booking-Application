package io;

import data.FlightData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightCSV {
    public static final String delimiter = ",";
    public ArrayList<FlightData> read(String filePath) {
        ArrayList<FlightData> flightData = new ArrayList<>();
        try {
            File flightFile = new File(filePath);
            Scanner CsvLine = new Scanner(flightFile);
            boolean headerLine = true;
            while (CsvLine.hasNextLine()) {
                String line = CsvLine.nextLine();
                if (headerLine) {
                    headerLine = false;
                    continue;
                }
                FlightData data = new FlightData();
                String[] tempArr = line.split(delimiter);
                data.seatCategory = tempArr[0];
                data.flightNumber = tempArr[1];
                data.availableSeats = Integer.parseInt(tempArr[2]);
                data.price = Double.parseDouble(tempArr[3]);
                data.arrival = tempArr[4];
                data.departure = tempArr[5];
                flightData.add(data);
            }
            CsvLine.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flightData;
    }
}
