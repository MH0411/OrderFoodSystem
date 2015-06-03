package item;

public class Item {
	
	private String itemId;
	private String name;
	private double unitPrice;
	private String status;
	
	public Item(String itemId, String name, double unitPrice, String status) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.status = status;
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
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
