package item;

/**
 * This class represent the food and set in this application.
 * Each item have itemId, name and unitPrice.
 * @author JKGan
 *
 */
public class Item {
	
	private int itemId;
	private String name;
//	private int quantity = 0;
	private double unitPrice;
//	private double subTotalPrice = 0.0;
	
	/**
	 * Constructor of Item to initialize itemId, name and unitPrice
	 * @param itemId
	 * @param name
	 * @param unitPrice
	 */
	public Item(int itemId, String name, double unitPrice) {
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public Item(String name, double unitPrice) {

		this.name = name;
//		this.quantity = quantity;
		this.unitPrice = unitPrice;
//		this.subTotalPrice = subTotalPrice;
	}

	/**
	 * getter of itemId
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}
	
	/**
	 * setter of itemId
	 * @param itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter of name
	 * @return item name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter of name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter of unitPrice
	 * @return item unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	
	/**
	 * setter of unitPrice
	 * @param unitPrice
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Returns a string representation of the object. In general, the toString 
	 * method returns a string that "textually represents" this object.
	 */
	@Override
	public String toString() {
		return name;
	}


}
