package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.Discount;
import se.kth.iv1350.POS.integration.ItemDTO;

import java.util.HashMap;

public class Sale {

	private ItemDTO recentAddedItem;
	private HashMap<ItemDTO, Integer> listOfItems = new HashMap<>();
	private double totalPrice;
	private double paidAmount;

	private double change;

	private Receipt receipt;
	private double totalTaxes;

	public Sale() {
		this.receipt = new Receipt();
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount){
		this.paidAmount = paidAmount;
	}

	public HashMap<ItemDTO, Integer> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(HashMap<ItemDTO, Integer> listOfItems) {
		this.listOfItems = listOfItems;
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


	public double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public void addItem(ItemDTO itemDTO) {
		if(getListOfItems().containsKey(itemDTO)){
			addItemQuantity(listOfItems.get(itemDTO),  1);
			recentAddedItem = itemDTO;
			increseTotPrice(itemDTO, 1);
			setTotalTaxes(getTotalTaxes() + getVAT(itemDTO));
		}
	}

	public void addItemQuantity(int ItemDTO, int quantityItems) {
			getListOfItems().put(recentAddedItem, quantityItems);
	}

	public void increseTotPrice(ItemDTO itemPriceToAdd, int itemQuantity){
		setTotalPrice(getTotalPrice() + ((itemPriceToAdd.getPrice() + getVAT(itemPriceToAdd)) * itemQuantity));
	}

	public void getVAT(ItemDTO itemToCalculateVATOf){
		return itemToCalculateVATOf.getTaxRate() * itemToCalculateVATOf.getPrice();
	}

	public double calculateChange(){
		setChange(paidAmount - totalPrice);
		return change;
	}

	public  void updateReceipt(){
		receipt.setSaleInformation(this);
	}



	public void addTotalPrice(int totalPrice) {

	}

	public double getPriceAfterDiscount(Discount discount) {
		return 0;
	}

}
