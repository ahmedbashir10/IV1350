package se.kth.iv1350.POS.integration;

class itemDTO {

	private final String name;

	private final String description;

	private final double price;

	private final int taxRate;

	private InventorySystem inventorySystem;

	itemDTO(String name, String description, double price, int taxRate, InventorySystem inventorySystem) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.taxRate = taxRate;
		this.inventorySystem = inventorySystem;
	}

	public itemDTO() {
	}

	itemDTO itemDTO(String name, String description, double price, double taxRate) {
		return null;
	}

}
