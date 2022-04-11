package command;

import io.ErrorTxt;
import singleton.FlightDB;

public class ErrorTxtInitializer  extends Command{
    public ErrorTxtInitializer(FileHandler fileHandler){
        super(fileHandler);
    }
    @Override
    public void execute() {
        ErrorTxt.setFilePath(fileHandler.action());
    }
}