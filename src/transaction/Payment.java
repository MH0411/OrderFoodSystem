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

	public Payment(Timestamp dateTime, Cart cart) {
		super();
		this.dateTime = dateTime;
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

}
