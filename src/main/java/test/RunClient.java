package test;

import command.*;

public class RunClient {
    public static void main(String[] args) {
        
        FileHandler arg1 = new FileHandler(args[0]);
        FileHandler arg2 = new FileHandler(args[1]);
        FileHandler arg3 = new FileHandler(args[2]);
        FileHandler arg4 = new FileHandler(args[3]);
        

        /*
        FileHandler arg1 = new FileHandler("/Users/yswu/IdeaProjects/IndividualProject/src/test/Sample.csv");
        FileHandler arg2 = new FileHandler("/Users/yswu/IdeaProjects/IndividualProject/src/test/flights.csv");
        FileHandler arg3 = new FileHandler("/Users/yswu/IdeaProjects/IndividualProject/src/test/play_ground/test.csv");
        FileHandler arg4 = new FileHandler("/Users/yswu/IdeaProjects/IndividualProject/src/test/play_ground/test.txt");
        */


        Command bookingCSVInitializer = new BookingCSVInitializer(arg1);
        Command dbInitializer = new DBInitializer(arg2);
        Command successCSVInitializer = new SuccessCSVInitializer(arg3);
        Command errorTxtInitializer = new ErrorTxtInitializer(arg4);

        Invoker invoker = new Invoker();
        invoker.setCommand(dbInitializer);
        invoker.setCommand(successCSVInitializer);
        invoker.setCommand(errorTxtInitializer);
        invoker.setCommand(bookingCSVInitializer);
        invoker.executeCommand();
    }
}
