package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.Exceptions.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.Exceptions.OperationFailedException;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.model.Printer;
import se.kth.iv1350.POS.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest {

    private View view;
    private Controller controller;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer printer;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void tearUp() {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        printer = new Printer();
        controller = new Controller(inventorySystem,accountingSystem,printer);
        view = new View(controller);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        controller = null;
        view = null;
        System.setOut(System.out);
    }

    @Test
    void print_validOutput_outputIsCorrect1() throws OperationFailedException, InvalidIdentifierException {
       String barcodeForMilk = "m1020k";
        String barcodeForChips = "c1020k";
        String barcodeForGodis = "g1020k";
        controller.startSale();
        controller.scanItem(barcodeForMilk);
        controller.scanItem(barcodeForChips);
        controller.scanItem(barcodeForGodis);
        double totalPrice = controller.getTotalPrice();
        double totalVAT = controller.getSale().getTotalVAT();
        double totalPaidAmount = controller.getSale().getPaidAmount();
        double totalChange = controller.getSale().getChange();

        // Arrange
        String expectedOutput = "A new sale has been started" + "\n\n" +
                "Items has been scanned" + "\n\n" +
                "The price is: " + totalPrice + "\n\n" +
                "The customer with id 662 want a discount based on his age: " + "\n\n" +
                "******************************************************************" + "\n" +
                "                          RECEIPT                      			 " + "\n" +
                "******************************************************************" + "\n" +
                "Description" + "                                               Quantity" + "\n" +
                "Chips" +  "                                                  			" +"1"+ "\n\n" +
                "Milk" +  "                                                  			" +"1"+ "\n\n" +
                "Godis" + "                                                  			" +"1"+ "\n" +
                "******************************************************************" + "\n" +
                "                          TOTAL                     			 " + "\n\n" +
                "Total price of the sale 								   " + totalPrice + "\n" +
                "Total amount of VAT: 						   "  +  totalVAT + "\n" +
                "Total amount paid: 									  		"  + totalPaidAmount + "\n" +
                "Total amount of change: 								   " + totalChange + "\n" +
                "******************************************************************" + "\n" +
                "The sale is ended and a receipt is printed";

        // Act
        view.print("");

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
