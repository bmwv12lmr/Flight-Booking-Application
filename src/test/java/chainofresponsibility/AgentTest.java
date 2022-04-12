package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AgentTest {

    @Test
    void setNext() {
        Agent agent1 = new CreditCardChecker();
        Agent agent2 = new FlightChecker();
        agent1.setNext(agent2);
        assertEquals(agent2.agentName, agent1.next.agentName);
    }

    @Test
    void getNext() {
        Agent agent1 = new CreditCardChecker();
        Agent agent2 = new FlightChecker();
        agent1.setNext(agent2);
        assertEquals(agent2.agentName, agent1.getNext().agentName);
    }

    @Test
    void leaveSuccess() {
        CustomerData customerData = new CustomerData();
        Agent agent = new Agent() {
            @Override
            public void handleRequest(CustomerData customerData) {
                leaveSuccess();
            }
        };
        agent.handleRequest(customerData);
        assertTrue(agent.endSuccess);
    }

    @Test
    void leaveFailed() {
        File fileObj = new File("src/test/play_ground/test.txt");
        ErrorTxt.setFilePath(fileObj.getPath());
        CustomerData customerData = new CustomerData();
        Agent agent = new Agent() {
            @Override
            public void handleRequest(CustomerData customerData) {
                this.reason = "Credit Card Error";
                leaveFailed("Person 1");
            }
        };
        agent.handleRequest(customerData);
        assertFalse(agent.endSuccess);
    }
}