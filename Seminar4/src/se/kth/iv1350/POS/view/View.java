package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.Exceptions.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.Exceptions.OperationFailedException;

/**
 * This is a placehodlder for the real view. It contains a hardcoded execution
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
	 * @return
	 * @throws OperationFailedException
	 * @throws InvalidIdentifierException
	 */
	public void runFakeExecution() throws InvalidIdentifierException, OperationFailedException {
		printA("");
		printB("");
	}

	public void printA(String output) throws OperationFailedException, InvalidIdentifierException {
		String barcodeForMilk = "m1020k";
		String barcodeForChips = "c1020k";
		String barcodeForGodis = "g1020k";

		contr.startSale();
		System.out.println("A new sale has been started" + "\n");
		contr.scanItem(barcodeForMilk);
		contr.scanItem(barcodeForChips);
		contr.scanItem(barcodeForGodis);
		System.out.println("Items has been scanned" + "\n");
		totalPrice = contr.getTotalPrice();
		System.out.println("The price is: " + totalPrice + "\n");
		System.out.println("The customer with id 662 want a discount based on his age: " + "\n");
		/*try {
			contr.calculatePriceAfterDiscount("age", contr.getAccountingSystem().getCustomer("662"));
		} catch (DiscountException exc) {
			System.out.print("User information: Customer with the id " + exc.getCustomerID() + " "
					+ "is not eligible for a discount!"+ "\n");
			System.out.print("LOG: The customer does not fit in any of the implemented algorithms"
					+ "for calculating a discount"+ "\n" + "\n");

		} catch (InstantiationException exc) {
			System.out.print("User information: There is no discount of the type you searched for, "
					+ "please try again!" + "\n");
			System.out.print("LOG: There is no discount calculator implementation that has this "
					+ "description" + "\n" + "\n");
		}*/
		totalPrice = contr.getTotalPrice();
		System.out.println("The price after discount is: " + totalPrice + "\n");
		change = contr.payment(100);
		paidAmount = contr.getSale().getPaidAmount();
		System.out.println("Customer payed: " + paidAmount + "\n");
		System.out.println("The change of this sale is: " + change + "\n");
		contr.endSale();
		System.out.println("The sale is ended and a receipt is printed" + "\n");
	}

	public void printB(String output){
		String barcodeThatDosentExist = "dosentExist";
		String barcodeThatNeedDataBaseAccess = "needsDataBaseAccess";
		String testingExceptions[] = { barcodeThatDosentExist, barcodeThatNeedDataBaseAccess };


		contr.startSale();

		for (int i = 0; i < 2; i++) {

			try {
				System.out.println("Scanning item that " + testingExceptions[i] + "\n");
				contr.scanItem(testingExceptions[i]);

			} catch (InvalidIdentifierException exc) {
				System.out.println("User information: "
						+ "Barcode " + exc.getInvalidbarcode() + " is not known in the" + " inventory system." + "\n");
				System.out.println("LOG: Searched for an item that dosent exist in the catalog (HashMap)" + "\n");
				exc.printStackTrace();
				System.out.println("\n");
			} catch (OperationFailedException exc) {
				System.out.println("User information: Server is down!"  + "\n");
				System.out.println("LOG: The database could not get accessed "  + "\n");
				exc.printStackTrace();
			}
		}
	}

}