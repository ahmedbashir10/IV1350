package se.kth.iv1350.POS.integration;

 public class ItemDTO {

	private String description;

	private  double price;

	private int taxRate;


	public ItemDTO(String description, double price, int taxRate) {
		this.description = description;
		this.price = price;
		this.taxRate = taxRate;
	}


	 public Object getPrice() {
		return this.price;
	 }

	 public int getTaxRate() {
		 return taxRate;
	 }

	 public String getDescription() {
		 return description;
	 }

	 public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^(temp >>> 32));
		temp = Double.doubleToLongBits(taxRate);
		result = prime *result + (int) (temp ^ (temp >>> 32));
		return result;
	 }
 }
