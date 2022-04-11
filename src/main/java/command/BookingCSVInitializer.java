package command;

import chainofresponsibility.*;
import data.CustomerData;
import io.BookingCSV;

import java.util.ArrayList;

public class BookingCSVInitializer extends Command{
    public BookingCSVInitializer(FileHandler fileHandler){
        super(fileHandler);
    }
    @Override
    public void execute() {
        BookingCSV obj = new BookingCSV();
        ArrayList<CustomerData> customerDataList = obj.read((fileHandler.action()));

        Agent flightChecker = new FlightChecker();
        Agent seatChecker = new SeatChecker();
        Agent priceCalculator = new PriceCalculator();
        Agent creditCardChecker = new CreditCardChecker();
        Agent flightBooker = new FlightBooker();

        flightChecker.setNext(seatChecker);
        seatChecker.setNext(priceCalculator);
        priceCalculator.setNext(creditCardChecker);
        creditCardChecker.setNext(flightBooker);

        for(CustomerData data: customerDataList) {
            flightChecker.handleRequest(data);
        }
    }
}