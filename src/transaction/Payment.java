package transaction;

import java.sql.Timestamp;

/**
 * 
 * @author JKGan
 *
 */
public class Payment {

	private Timestamp dateTime;
	private Cart cart;
	private double change = 0.0;

	public Payment(Cart cart) {
		super();
		this.cart = cart;
	}
	
	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double calculateChange(double cash) {
		change =  cash - cart.getRoundTotalPrice();
		return change;
	}
}
