package transaction;


public class Sale {
	
	private String itemId;
	private String name;
	private int quantity;
	private double unitPrice;
	private double totalPrice;

	public String getItemId(){
		return itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getUnitPrice(){
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double subTotalPrice) {
		this.totalPrice = subTotalPrice;
	}
	
	
}
