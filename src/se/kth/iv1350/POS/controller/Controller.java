package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.DiscountDataBase;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.integration.itemDTO;
import se.kth.iv1350.POS.model.Customer;
import se.kth.iv1350.POS.model.Identifier;
import se.kth.iv1350.POS.model.Sale;

import javax.swing.text.View;

public class Controller {

	private View view;

	private Sale sale;

	//private main main;

	private InventorySystem inventorySystem;

	private AccountingSystem accountingSystem;

	private DiscountDataBase discountDataBase;

	private Customer customer;

	private Identifier identifier;

	public void startSale() {

	}

	public Controller Controller() {
		return null;
	}

	public void increaseItemQuantity(itemDTO itemDTO, int quantity) {

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

	public itemDTO scanItem(java.lang.String barcode) {
		return null;
	}

}
