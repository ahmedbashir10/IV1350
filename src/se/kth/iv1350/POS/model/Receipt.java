package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.itemDTO;

public class Receipt {

	private int totalprice;

	private int change;

	private int date;

	private int time;

	private double tax;

	private itemDTO itemDTO;

	private Sale sale;

	Receipt Receipt() {
		return null;
	}

	void addInfoOfThisItem(itemDTO itemDTO) {

	}

	void addInfoWithQuantity(itemDTO itemDTO, int quantity) {

	}

	void addInfo(Sale sale) {

	}

	void addPrice(double totalPrice) {

	}

	void addPriceAfterDiscount(double totalPriceAfterDiscount) {

	}

}
