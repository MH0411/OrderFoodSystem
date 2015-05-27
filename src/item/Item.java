package item;

public class Item {
	
	private String itemID;
	private String itemName;
	private double unitPrice;
	
	public Item(String itemID, String itemName, double unitPrice) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
	}
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
