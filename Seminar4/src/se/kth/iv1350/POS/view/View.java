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

	/**
	 *
	 * Creates a new instance, that uses the specified controller for all calls to
	 * other layers.
	 *
	 * @param contr The controller to use for all calls to other layers.
	 */
	public View(Controller contr) {
		this.contr = contr;

	}

	public void runFakeExecution() throws InvalidIdentifierException, OperationFailedException{
		String barcodeForMilk = "m1020k";
		String barcodeForChips = "c1020k";
		String barcodeForGodis = "g1020k";

		contr.startSale();
		System.out.println("A new sale has been started" + "\n");
		contr.scanItem(barcodeForMilk);
		contr.scanItem(barcodeForMilk);
		contr.scanItem(barcodeForChips);
		contr.scanItem(barcodeForGodis);
		System.out.println("Items has been scanned" + "\n");
		contr.IncreaseQuantityOfAnItem(3);
		System.out.println("The last scanned item (Godis in this case) has been increased in quantity" + "\n");
		totalPrice = contr.getTotalPrice();
		System.out.println("The price is: " + totalPrice + "\n");
		change = contr.payment(100);
		System.out.println("The change of this sale is: " + change + "\n");
		contr.endSale();
		System.out.println("The sale is ended and a receipt is printed");

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