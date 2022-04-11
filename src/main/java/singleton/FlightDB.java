package singleton;

import data.FlightData;
import io.FlightCSV;

import java.util.ArrayList;
import java.util.Objects;

public class FlightDB {
    static private FlightDB instance = null;
    static private String filePath = null;
    static private ArrayList<FlightData> flightDataArrayList = null;

    private FlightDB(){
        FlightCSV obj = new FlightCSV();
        flightDataArrayList = obj.read(FlightDB.filePath);
    }

    public static synchronized FlightDB getInstance() {
        if (instance == null) {
            instance = new FlightDB();
        }
        return instance;
    }

    public static boolean checkFlightExist(String flightNumber) {
        for (FlightData data: flightDataArrayList) {
            if(Objects.equals(data.flightNumber, flightNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSeatAvail(String flightNumber, String seatCategory, int needSeat) {
        for (FlightData data: flightDataArrayList) {
            if(Objects.equals(data.flightNumber, flightNumber) &&
                    Objects.equals(data.seatCategory, seatCategory) &&
               data.availableSeats >= needSeat) {
                return true;
            }
        }
        return false;
    }

    public static double calculatePrice(String flightNumber, String seatCategory, int needSeat) {
        for (FlightData data: flightDataArrayList)
            if (Objects.equals(data.flightNumber, flightNumber) &&
                    Objects.equals(data.seatCategory, seatCategory)) {
                return data.price * needSeat;
            }
        return -1;
    }

    public static synchronized void bookFlight(String flightNumber, String seatCategory, int needSeat) {
        for (FlightData data: flightDataArrayList)
            if (Objects.equals(data.flightNumber, flightNumber) &&
                    Objects.equals(data.seatCategory, seatCategory)) {
                data.availableSeats -= needSeat;
            }
    }

    public static void setFilePath(String filePath) {
        FlightDB.filePath = filePath;
    }

}
