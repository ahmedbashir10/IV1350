package se.kth.iv1350.POS.integration;

 public class ItemDTO {

	private final String name;

	private final String description;

	private final double price;

	private final int taxRate;

	private InventorySystem inventorySystem;


	public ItemDTO(String name, String description, double price, int taxRate) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.taxRate = taxRate;
	}


}
