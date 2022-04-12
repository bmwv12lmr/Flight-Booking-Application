package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;

public abstract class Agent {
    public String agentName;
    public Agent next;
    public String reason;
    public boolean endSuccess = false;
    public void setNext(Agent next) {
        this.next = next;
    }
    public Agent getNext() {
        return next;
    }
    public void leaveSuccess(){endSuccess = true;}
    public void leaveFailed(String customerName){
        ErrorTxt.write(customerName, this.reason);
        endSuccess = false;
    }
    public abstract void handleRequest(CustomerData customerData);
}
