package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.itemDTO;
import se.kth.iv1350.POS.integration.Discount;

public class Sale {

	private java.lang.LocalTime saleTime;

	private double totalPrice;
	private double paidAmount;

	private double change;

	private Receipt receipt;
	private double totalQuantityOfGoods;

	public Sale() {
		this.receipt = new Receipt();
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount){
		this.paidAmount = paidAmount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}


	public double getTotalQuantityOfGoods() {
		return totalQuantityOfGoods;
	}

	public void setTotalQuantityOfGoods(double totalQuantityOfGoods) {
		this.totalQuantityOfGoods = totalQuantityOfGoods;
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

	public double getPriceAfterDiscount(Discount discount) {
		return 0;
	}

}
