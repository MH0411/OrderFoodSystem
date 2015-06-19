package item;

/**
 * This class represent item ordered by customer.
 * It consists of itemId, name, unitPrice(which inherits from Item class) and
 * quantity and subTotalPrice. 
 * @author JKGan
 *
 */
public class OrderedItem extends Item {

	private int quantity;
	private double subTotalPrice;
	
	/**
	 * Construct to initialize itemId, name, quantity, unitPrice and 
	 * subTotalPrice.
	 * @param itemId
	 * @param name
	 * @param quantity
	 * @param unitPrice
	 * @param subTotalPrice
	 */
	public OrderedItem(int itemId, String name, int quantity, 
			double unitPrice, double subTotalPrice) {
		super(itemId, name, unitPrice);
		this.quantity = quantity;
		this.subTotalPrice = subTotalPrice;
	}
	
	/**
	 * getter of quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * setter of quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * getter of subTotalPrice
	 * @return subTotalPrice
	 */
	public double getSubTotalPrice() {
		return subTotalPrice;
	}
	
	/**
	 * setter of subTotalPrice
	 * @param subTotalPrice
	 */
	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
}
