package command;

import io.SuccessCSV;

public class SuccessCSVInitializer  extends Command{
    public SuccessCSVInitializer(FileHandler fileHandler){
        super(fileHandler);
    }
    @Override
    public void execute() {
        SuccessCSV.setFilePath(fileHandler.action());
    }
}