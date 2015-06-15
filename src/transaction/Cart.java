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
	private double totalPrice = 0;
	private double roundTotalPrice = 0;
	private double chargedGST = 0;
	private final double GST = 1.06;

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

	public double getRoundTotalPrice() {
		return roundTotalPrice;
	}

	public void setRoundTotalPrice(double roundTotalPrice) {
		this.roundTotalPrice = roundTotalPrice;
	}
	/**
	 * Add item into cartItems
	 * @param item
	 */
	public void addItem(Item item) {		
		cartItems.add(item);
		calculateTotalPrice(item.getSubTotalPrice());
	}
	
	public void calculateTotalPrice(double price) {
		totalPrice += (price * GST);
		chargedGST = totalPrice / GST * 0.06;
		roundTotalPrice = (Math.round(totalPrice * 20.0)) / 20.0;
	}
	
	public void removeItem(int index) {
		totalPrice -= (cartItems.get(index).getSubTotalPrice() * GST);
		chargedGST = totalPrice / GST * 0.06;
		roundTotalPrice = (Math.round(totalPrice * 20.0)) / 20.0;
		cartItems.remove(index);
	}

}
