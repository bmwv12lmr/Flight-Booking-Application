package command;

import singleton.FlightDB;

public class DBInitializer extends Command{
    public DBInitializer(FileHandler fileHandler){
        super(fileHandler);
    }
    @Override
    public void execute() {
        FlightDB.setFilePath(fileHandler.action());
        FlightDB.getInstance();
    }
}
