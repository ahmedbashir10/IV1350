package se.kth.iv1350.POS.model;

/**
 * Represents one receipt, which proves the payment of one sale.
 */

public class Receipt {
	private Sale sale;

	/**
	 * Sets the sale of this receipt to a given sale.
	 *
	 * @param sale The given sale.
	 */
	public void setSaleInfo(Sale sale) {
		this.sale = sale;
	}

	/**
	 * Creates a string representation of this receipt.
	 *
	 * @return The string representation of this receipt.
	 */
	@Override
	public String toString() {
		StringBuilder receiptBuilder = new StringBuilder();

		receiptBuilder.append("******************************************************************");
		receiptBuilder.append("\n");
		receiptBuilder.append("                          RECEIPT                      			 ");
		receiptBuilder.append("\n");
		receiptBuilder.append("******************************************************************");
		receiptBuilder.append("\n");


		receiptBuilder.append(receipttoString());
		return receiptBuilder.toString();

	}

	/**
	 * Makes a string representation of this sale
	 *
	 * @return The string representation of this sale
	 */

	public String receipttoString() {
		StringBuilder saleSB = new StringBuilder();
		saleSB.append("Description");
		saleSB.append("                                               Quantity");

		var itemSet = sale.getListOfItems().entrySet();
		for (var entry : itemSet) {
			saleSB.append("\n");
			saleSB.append(entry.getKey().getItemDescription());
			saleSB.append("                                                  			");
			saleSB.append(entry.getValue());
			appendNewLine(saleSB);
		}

		saleSB.append("******************************************************************");
		appendNewLine(saleSB);
		saleSB.append("                          TOTAL                     			 ");
		saleSB.append("\n\n");
		saleSB.append("Total price of the sale 								   ");
		saleSB.append(sale.getTotalPrice());

		appendNewLine(saleSB);

		saleSB.append("Total amount of VAT: 						   ");
		saleSB.append(sale.getTotalVAT());
		appendNewLine(saleSB);

		saleSB.append("Total amount paid: 									  		");
		saleSB.append(sale.getPaidAmount());
		appendNewLine(saleSB);

		saleSB.append("Total amount of change: 								   ");
		saleSB.append(sale.getChange());
		appendNewLine(saleSB);

		saleSB.append("******************************************************************");

		return saleSB.toString();

	}

	private void appendNewLine(StringBuilder StringBuilderToAppendNewLineOn) {
		StringBuilderToAppendNewLineOn.append("\n");

	}
}