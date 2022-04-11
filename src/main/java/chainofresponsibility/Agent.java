package chainofresponsibility;

import data.CustomerData;
import io.ErrorTxt;

public abstract class Agent {
    public Agent next;
    public String reason;
    public void setNext(Agent next) {
        this.next = next;
    }
    public Agent getNext() {
        return next;
    }
    public void leaveFailed(String customerName){
        ErrorTxt.write(customerName, this.reason);
    }
    public abstract void handleRequest(CustomerData customerData);
}
