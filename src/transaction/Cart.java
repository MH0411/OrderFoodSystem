package transaction;

import java.util.ArrayList;

import item.Item;

/**
 * This class represent Cart of this application which store cartItems, 
 * totalPrice and chargedGST
 * All selected items will be added into Cart object
 * @author JKGan
 *
 */
public class Cart {
	
	private ArrayList<Item> cartItems = new ArrayList<Item>();
	private double totalPrice;
	private double chargedGST;

	public Cart() {}
	
	/**
	 * getter of cartItems
	 * @return cartItems
	 */
	public ArrayList<Item> getCartItems() {
		return cartItems;
	}
	
	/**
	 * setter of cartItems
	 * @param cartItems
	 */
	public void setCartItems(ArrayList<Item> cartItems) {
		this.cartItems = cartItems;
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
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * getter of chargeGST
	 * @return
	 */
	public double getChargedGST() {
		return chargedGST;
	}
	
	/**
	 * setter of chargeGST
	 * @param chargedGST
	 */
	public void setChargedGST(double chargedGST) {
		this.chargedGST = chargedGST;
	}
	
	/**
	 * Add item into cartItems
	 * @param item
	 */
	public void addItem(Item item) {		
		cartItems.add(item);
	}
}
