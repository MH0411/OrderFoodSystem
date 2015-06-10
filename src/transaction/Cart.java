package transaction;

import java.util.ArrayList;

import item.Item;

public class Cart {
	
	private ArrayList<Item> cartItems = new ArrayList<Item>();
	private double totalPrice;
	private double chargedGST;

	public Cart() {}
	
	public ArrayList<Item> getCartItems() {
		return cartItems;
	}
	
	public void setCartItems(ArrayList<Item> cartItems) {
		this.cartItems = cartItems;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getChargedGST() {
		return chargedGST;
	}
	
	public void setChargedGST(double chargedGST) {
		this.chargedGST = chargedGST;
	}
	
	public void addItem(Item item) {		
		cartItems.add(item);
	}
}
