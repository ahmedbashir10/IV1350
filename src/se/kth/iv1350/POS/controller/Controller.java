package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.DiscountDataBase;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.model.Printer;
import se.kth.iv1350.POS.model.Sale;

public class Controller {

	private Sale sale;

	private InventorySystem inventorySystem;

	private AccountingSystem accountingSystem;

	private DiscountDataBase discountDataBase;

	private Printer printer;


	public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem, Printer printer) {
		this.inventorySystem = inventorySystem;
		this.accountingSystem = accountingSystem;
		this.printer = printer;
	}

	public void startSale() {
		sale = new Sale();

	}

	public double endSale() {
		return 0;
	}

	public double getPriceAfterDiscount() {
		return 0;
	}

	public double getChange(double totalAmount) {
		return 0;
	}


}
