package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.itemDTO;
import se.kth.iv1350.POS.integration.Discount;

public class Sale {

	private java.lang.LocalTime saleTime;

	private double totalPrice;

	private double change;

	private Receipt receipt;

	private Controller controller;

	private Printer printer;

	public Sale Sale() {
		return null;
	}

	private void setTimeOfSale() {

	}

	public void addItem(itemDTO itemDTO) {

	}

	public void addItemQuantity(int itemDTO, int quantity) {

	}

	public double getPrice() {
		return 0;
	}

	public void addTotalPrice(int totalPrice) {

	}

	public Sale getThisSale() {
		return null;
	}

	public double getChange(double totalAmount) {
		return 0;
	}

	public void endSale() {

	}

	public double getPriceAfterDiscount(Discount discount) {
		return 0;
	}

}
