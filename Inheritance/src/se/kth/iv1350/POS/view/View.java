package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.Exceptions.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.Exceptions.OperationFailedException;
import se.kth.iv1350.POS.integration.Exceptions.DiscountException;

/**
 * This is a sample of the real view. It contains a hardcoded execution
 * with calls to all system operations in the controller
 */

public class View {
	private Controller contr;
	private double totalPrice;
	private double change;
	private double paidAmount;

	/**
	 *
	 * Creates a new instance, that uses the specified controller for all calls to
	 * other layers.
	 *
	 * @param contr The controller to use for all calls to other layers.
	 */
	public View(Controller contr) {
		this.contr = contr;
		contr.addObserver(new TotalRevenueView());
		contr.addObserver(new TotalRevenueFileOutput());
	}

	/**
	 * A test method to test the components of the program
	 *
	 * @throws OperationFailedException
	 * @throws InvalidIdentifierException
	 *
	 */
	public void runFakeExecution() throws OperationFailedException, InvalidIdentifierException {
		String barcodeForTomato = "m1020k";
		String barcodeForChips = "c1020k";
		String barcodeForKetchup = "g1020k";

		contr.startSale();
		contr.scanItem(barcodeForTomato);
		contr.scanItem(barcodeForChips);
		contr.scanItem(barcodeForKetchup);
		contr.scanItem(barcodeForKetchup);
		contr.scanItem(barcodeForTomato);
		System.out.println("Items has been scanned" + "\n");
		totalPrice = contr.getTotalPrice();
		System.out.println("The price is: " + totalPrice + "\n");
		System.out.println("**************************************************" + "\n");

		change = contr.payment(200);
		paidAmount = contr.getSale().getPaidAmount();
		System.out.println("Customer payed: " + paidAmount + "\n");
		System.out.println("The change of this sale is: " + change + "\n");
		contr.endSale();
		System.out.println("The sale is ended and a receipt is printed" + "\n");

	}
}