package command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void action() {
        FileHandler fileHandler = new FileHandler("Test");
        assertEquals("Test", fileHandler.action());
    }
}