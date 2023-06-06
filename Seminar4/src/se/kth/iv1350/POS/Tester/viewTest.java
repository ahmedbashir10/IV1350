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
    void printAValidOutputTest() throws OperationFailedException, InvalidIdentifierException {
        String barcodeForMilk = "m1020k";
        String barcodeForChips = "c1020k";
        String barcodeForGodis = "g1020k";
        controller.startSale();
        controller.scanItem(barcodeForMilk);
        controller.scanItem(barcodeForChips);
        controller.scanItem(barcodeForGodis);
        double totalPrice = controller.getTotalPrice();
        double totalVAT = controller.getSale().getTotalVAT();

        double change = controller.payment(100);
        double totalChange = controller.getSale().getChange();
        double totalPaidAmount = controller.getSale().getPaidAmount();

        // Arrange
        String expectedOutput =
                "The total revenue from totalRevenueView is now: " + totalPaidAmount + " \n\n" +
                "A new sale has been started" + "\n\n" +
                "Items has been scanned" + "\n\n" +
                "The price is: " + totalPrice + "\n\n" +
                "The customer with id 662 want a discount based on his age: " + "\n\n" +
                "The price after discount is: " + totalPrice + "\n\n" +
                "The total revenue from totalRevenueView is now: " + "200.0 " + "\n\n" +
                "Customer payed: " + totalPaidAmount + "\n\n" +
                "The change of this sale is: " + change + "\n\n" +
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
        view.printA("");

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void printBValidOutputTest() throws OperationFailedException, InvalidIdentifierException {
        String barcodeThatDosentExist = "dosentExist";
        String barcodeThatNeedDataBaseAccess = "needsDataBaseAccess";
        String testingExceptions[] = { barcodeThatDosentExist, barcodeThatNeedDataBaseAccess };

        String expectedOutput =
                "Scanning item that dosentExist\n" +
                        "User information: Barcode dosentExist is not known in the inventory system.\n" +
                        "LOG: Searched for an item that dosent exist in the catalog (HashMap)\n" +
                        "\n" +
                        "Scanning item that needsDataBaseAccess\n" +
                        "User information: Server is down!\n" +
                        "LOG: The database could not get accessed\n";

        // Act
        view.printB("");

        // Assert
        for (int i = 0; i < 2; i++) {
            controller.scanItem(testingExceptions[i]);
            assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        }
    }

}
