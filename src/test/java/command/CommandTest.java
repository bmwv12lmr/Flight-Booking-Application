package command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void execute() {
        FileHandler fileHandler = new FileHandler("Test");
        Command cmd = new Command(fileHandler) {
            @Override
            public void execute() {
                assertEquals("Test", fileHandler.action());
            }
        };
        cmd.execute();
    }
}