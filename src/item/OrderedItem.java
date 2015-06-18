package item;

public class OrderedItem extends Item {

	private int quantity;
	private double subTotalPrice;
	
	public OrderedItem(int itemId, String name, int quantity, 
			double subTotalPrice, double unitPrice) {
		super(itemId, name, unitPrice);
		this.quantity = quantity;
		this.subTotalPrice = subTotalPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getSubTotalPrice() {
		return subTotalPrice;
	}
	
	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
}
