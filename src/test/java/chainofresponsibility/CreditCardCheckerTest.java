package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardCheckerTest {

    @Test
    void handleRequest() {
        CustomerData data = new CustomerData();
        data.paymentCardNumber = "5410000000000000";

        Agent creditCardChecker = new CreditCardChecker();
        creditCardChecker.handleRequest(data);
        assertTrue(creditCardChecker.endSuccess);

        String fileName = "error_" + System.currentTimeMillis() + ".txt";

        File fileObj = new File("src/test/play_ground/" + fileName);
        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }
        ErrorTxt.setFilePath(fileObj.getPath());

        data.paymentCardNumber = "1234561323130";

        creditCardChecker.handleRequest(data);
        assertFalse(creditCardChecker.endSuccess);

        if (fileObj.exists()) {
            assertTrue(fileObj.delete());
        }

    }
}