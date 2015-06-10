package item;

public class Item {
	
	private int itemId;
	private String name;
	private double unitPrice;
	
	public Item(int itemId, String name, double unitPrice) {
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public Item(int itemId, String name, String unitPrice) {
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = Double.parseDouble(unitPrice);
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String toString() {
		return name;
	}


}
