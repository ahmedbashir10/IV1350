package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.Identifier;
import se.kth.iv1350.POS.model.Sale;

import java.util.HashMap;

/**
 * Represents the inventorySystem that contains information about items.
 *
 */

public class InventorySystem {
	private Sale sale;
	HashMap<Identifier, Double> priceCatalog = new HashMap<>();
	HashMap<Identifier, Double> taxCatalog = new HashMap<>();
	HashMap<Identifier, String> descriptionCatalog = new HashMap<>();

	/**
	 * Creates some hardcoded instances in the catalogs so it can get tested
	 */
	private void catalogCreater() {
		Identifier identifiesMilk = new Identifier("m1020k");
		Identifier identifiesChips = new Identifier("c1020k");
		Identifier identifiesGodis = new Identifier("g1020k");
		Identifier identifiesBanana = new Identifier("b1020k");
		Identifier identifiesRice = new Identifier("r1020k");

		descriptionCatalog.put(identifiesMilk, "Milk");
		descriptionCatalog.put(identifiesChips, "Chips");
		descriptionCatalog.put(identifiesGodis, "Godis");
		descriptionCatalog.put(identifiesBanana, "Banana");
		descriptionCatalog.put(identifiesRice, "Rice");

		priceCatalog.put(identifiesMilk, (double) 4.90);
		priceCatalog.put(identifiesChips, (double) 14.90);
		priceCatalog.put(identifiesGodis, (double) 24.90);
		priceCatalog.put(identifiesBanana, 4.90);
		priceCatalog.put(identifiesRice, 29.90);

		taxCatalog.put(identifiesMilk, 0.12);
		taxCatalog.put(identifiesChips, 0.25);
		taxCatalog.put(identifiesGodis, 0.6);
		taxCatalog.put(identifiesBanana, 0.6);
		taxCatalog.put(identifiesRice, 0.12);

	}

	/**
	 * @return the sale
	 */
	public Sale getSale() {
		return sale;
	}

	public InventorySystem() {
		catalogCreater();

	}

	/**
	 * Gets the valid parameters for the item that is identified by a specific
	 * identifier and creates a new item with the correct information
	 *
	 * @param identifier The identifier that is used to get the values from the
	 *                   different catalogs
	 * @return The itemDTO of the item that is identified
	 */
	public ItemDTO getItemDTO(Identifier identifier) {
		ItemDTO item = new ItemDTO(descriptionCatalog.get(identifier), priceCatalog.get(identifier),
				taxCatalog.get(identifier));
		return item;

	}

	/**
	 * Sets the sale in this system to the given sale
	 *
	 * @param sale the given sale
	 */
	public void setSale(Sale sale) {
		this.sale = sale;
	}

}