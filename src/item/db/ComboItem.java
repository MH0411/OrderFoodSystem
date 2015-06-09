package item.db;

public class ComboItem {
	
	private String itemId;
	private String name;
	private double unitPrice;
	
	public ComboItem(String itemId, String name, double unitPrice) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = unitPrice;
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
	
	public String toString(){
		return name;
	}
}
