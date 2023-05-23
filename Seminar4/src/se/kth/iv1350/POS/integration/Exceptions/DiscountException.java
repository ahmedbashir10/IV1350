package se.kth.iv1350.POS.integration.Exceptions;

import se.kth.iv1350.POS.model.Customer;

public class DiscountException extends Exception{
    private Customer customer;

    public DiscountException(Customer customer) {
        super("Could not find a discount for customerID " + customer);
        this.customer = customer;
    }

    //public String getCustomerID(){
       // return this.customer;
    //}
}
