package singleton;

public class FlightDBTest {
    public static void main(String[] args) {
        FlightDB.setFilePath("/Users/yswu/IdeaProjects/IndividualProject/src/test/flights.csv");
        FlightDB obj = FlightDB.getInstance();
        System.out.println("Test Flight SJ456: " + obj.checkFlightExist("SJ456"));
        System.out.println("Test Flight 999: " + obj.checkFlightExist("999"));
        System.out.println("Test Seat: " + obj.checkSeatAvail("SJ456","Economy", 10 ));
        System.out.println("Test Seat: " + obj.checkSeatAvail("BY110", "Premium Economy", 5));
        System.out.println("Test calculatePrice: " + obj.calculatePrice("BY110", "Premium Economy", 5));
        System.out.println("Test bookFlight");
        obj.bookFlight("BY110", "Premium Economy", 5);
        System.out.println("Test Seat: " + obj.checkSeatAvail("BY110", "Premium Economy", 5));
    }
}
