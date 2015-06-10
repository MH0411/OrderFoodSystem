package item.db;

import item.Item;

public class ComboItem {
	
	private Item item;
	
	public ComboItem(Item item) {
		super();
		this.item = item;
//		this.itemId = itemId;
//		this.name = name;
//		this.unitPrice = unitPrice;
	}
	
	public String getItemId() {
		return item.getItemId();
	}

	public String getName() {
		return item.getName();
	}
	
	public double getUnitPrice() {
		return item.getUnitPrice();
	}

	public String toString() {
		return item.getName();
	}
}
