package se.kth.iv1350.POS.integration.Exceptions;

import se.kth.iv1350.POS.model.Identifier;

public class InvalidIdentifierException extends Exception{
    private Identifier invalidIdentifier;

    public InvalidIdentifierException(Identifier invalidIdentifier) {
        super("The identifier: " + invalidIdentifier.getBarcode() + " is not found in the inventory system");
        this.invalidIdentifier = invalidIdentifier;
    }

    public String getInvalidbarcode(){
        return invalidIdentifier.getBarcode();
    }
}
