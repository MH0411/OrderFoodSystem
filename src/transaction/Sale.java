package transaction;

/**
 * This class represent the sale which between 2 dates.
 * It contains itemId, name, quantity, unitPrice and totalPrice.
 * @author JKGan
 *
 */
public class Sale {
	
	private String itemId;
	private String name;
	private int quantity;
	private double unitPrice;
	private double totalPrice;

	/**
	 * getter of itemId
	 * @return itemId
	 */
	public String getItemId(){
		return itemId;
	}
	
	/**
	 * setter of itemId
	 * @param itemId
	 */
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	
	/**
	 * getter of name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * setter of name
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
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
	 * getter of unitPrice
	 * @return	unitPrice
	 */
	public double getUnitPrice(){
		return unitPrice;
	}
	
	/**
	 * setter of unitPrice
	 * @param unitPrice
	 */
	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}

	/**
	 * getter of totalPrice
	 * @return totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * setter of totalPrice
	 * @param subTotalPrice
	 */
	public void setTotalPrice(double subTotalPrice) {
		this.totalPrice = subTotalPrice;
	}
	
	
}
