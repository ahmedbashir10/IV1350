package se.kth.iv1350.POS.controller;

import view.View;
import model.Sale;
import startup.main;
import integration.InventorySystem;
import integration.AccountingSystem;
import integration.DiscountDataBase;
import model.Customer;
import model.Identifier;
import integration.itemDTO;

public class Controller {

	private View view;

	private Sale sale;

	private main main;

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
