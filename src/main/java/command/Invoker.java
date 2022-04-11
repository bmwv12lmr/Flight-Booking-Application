package command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> commandList = new ArrayList<>();
    public void setCommand(Command command){
        commandList.add(command);
    }
    public void executeCommand(){
        for (Command command : commandList) {
            command.execute();
        }
    }
}
