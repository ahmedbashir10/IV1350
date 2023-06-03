package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.model.Receipt;
import se.kth.iv1350.POS.model.Sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    private Receipt receipt;
    private Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        receipt = new Receipt();
    }

    /**
     */
    @AfterEach
    void tearDown() {
        sale = null;
        receipt = null;
    }
    /**
     * Test the string representation of a receipt with a certain sale
     */
    @Test
    void receiptPrinterTest() {
        ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
        ItemDTO chips = new ItemDTO("chips", 15, 0.25);
        ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
        sale.addItem(tomato);
        sale.addItem(ketchup);
        sale.addItem(tomato);
        sale.addItem(chips);
        sale.setPaidAmount(42);
        sale.calculateChange();
        receipt.setSaleInfo(sale);
        assertEquals(true, receipt.toString().contains("RECEIPT"), "The receipt word is being added correctly");
    }



    /**
     * Tests if the toString method makes a correct representation of an item in the
     * receipt
     */
    @Test
    void itemInReceiptTest() {
        ItemDTO godis = new ItemDTO("Godis", 5, 0.12);
        ItemDTO chips = new ItemDTO("chips", 15, 0.25);
        ItemDTO milk = new ItemDTO("Milk", 20, 0.6);
        sale.addItem(godis);
        sale.addItem(milk);
        sale.addItem(chips);
        sale.addItem(milk);
        sale.addItem(chips);
        receipt.setSaleInfo(sale);
        assertEquals(true, receipt.toString().contains("Milk"), "The item is not converted to string correctly");
        assertEquals(true, receipt.toString().contains("Godis"), "The item is not converted to string correctly");
        assertEquals(true, receipt.toString().contains("chips"), "The item is not converted to string correctly");
    }

    /**
     * Tests if the toString method makes a correct representation of the total price
     * in the receipt
     */
    @Test
    void totalPriceInReceiptTest() {
        ItemDTO godis = new ItemDTO("Godis", 5, 0.12);
        ItemDTO chips = new ItemDTO("chips", 15, 0.25);
        ItemDTO milk = new ItemDTO("Milk", 20, 0.6);
        sale.addItem(godis);
        sale.addItem(milk);
        sale.addItem(godis);
        sale.addItem(chips);
        sale.addItem(godis);
        receipt.setSaleInfo(sale);
        assertEquals(true, receipt.toString().contains("67.55"), "The total price amount is not converted to string correctly");
    }

    /**
     * Tests if the toString method makes a correct representation of the total VAT
     * in the receipt
     */
    @Test
    void totalVATInReceiptTest() {
        ItemDTO godis = new ItemDTO("Godis", 5, 0.12);
        ItemDTO chips = new ItemDTO("chips", 15, 0.25);
        ItemDTO milk = new ItemDTO("Milk", 20, 0.6);
        sale.addItem(godis);
        sale.addItem(milk);
        sale.addItem(godis);
        sale.addItem(chips);
        sale.addItem(godis);
        receipt.setSaleInfo(sale);
        assertEquals(true, receipt.toString().contains("17.55"), "The total VAT is not converted to string correctly");
    }

    /**
     * Tests if the toString method makes a correct representation of the total change
     * in the receipt
     */
    @Test
    void changeInReceiptTest() {
        ItemDTO godis = new ItemDTO("Godis", 5, 0.12);
        ItemDTO chips = new ItemDTO("chips", 15, 0.25);
        ItemDTO milk = new ItemDTO("Milk", 20, 0.6);
        sale.addItem(godis);
        sale.addItem(milk);
        sale.addItem(godis);
        sale.addItem(chips);
        sale.addItem(godis);
        sale.setPaidAmount(32);
        sale.calculateChange();
        receipt.setSaleInfo(sale);
        assertEquals(true, receipt.toString().contains("67.55"),
                "The change amount is not converted to string correctly");
    }
}
