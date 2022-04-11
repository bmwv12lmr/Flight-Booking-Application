package chainofresponsibility;

import data.CustomerData;

public class CreditCardChecker extends Agent {
    public CreditCardChecker() {
        this.reason = "invalid card number";
    }
    @Override
    public void handleRequest(CustomerData customerData) {
        if(checkCreditCard(customerData.paymentCardNumber)) {
            getNext().handleRequest(customerData);
        } else {
            this.leaveFailed(customerData.bookingName);
        }
    }
    public boolean checkCreditCard(String paymentCardNumber) {
        if(paymentCardNumber.length()<=16 && paymentCardNumber.length()>=13){
            if(paymentCardNumber.length() == 15 &&
               paymentCardNumber.charAt(0) == '3' &&
               (paymentCardNumber.charAt(1) == '4' ||
                paymentCardNumber.charAt(1) == '7')) {
                return true; // AMEX
            }
            if(paymentCardNumber.charAt(0) == '4' &&
              (paymentCardNumber.length() == 13 ||
               paymentCardNumber.length() == 16)) {
                return true; // VISA
            }
            if(paymentCardNumber.length() == 16 &&
            paymentCardNumber.charAt(0) == '6' &&
            paymentCardNumber.charAt(1) == '0' &&
            paymentCardNumber.charAt(2) == '1' &&
            paymentCardNumber.charAt(3) == '1') {
                return true; // DISCOVER
            }
            if(paymentCardNumber.length() == 16 &&
            paymentCardNumber.charAt(0) == '5' &&
            (paymentCardNumber.charAt(1) == '0' ||
            paymentCardNumber.charAt(1) == '1' ||
            paymentCardNumber.charAt(1) == '2' ||
            paymentCardNumber.charAt(1) == '3' ||
            paymentCardNumber.charAt(1) == '4' ||
            paymentCardNumber.charAt(1) == '5')) {
                return true; // MASTER
            }
        }
        return false;
    }

}
