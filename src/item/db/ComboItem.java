package item.db;

import item.Item;

public class ComboItem {
	
	private Item item;
	private String itemId;
	private String name;
	private double unitPrice;
	
	public ComboItem(Item item) {
		super();
		this.item = item;
//		this.itemId = itemId;
//		this.name = name;
//		this.unitPrice = unitPrice;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return item.getUnitPrice();
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String toString() {
		return item.getName();
	}
}
