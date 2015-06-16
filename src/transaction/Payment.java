package transaction;


/**
 * This class represent the payment when the user confirm to buy cart items.

 * @author JKGan
 *
 */
public class Payment {

	private Cart cart;
	private double change = 0.0;

	/**
	 * Constructor of Payment.
	 * Used to initialize cart in payment object.
	 * @param cart
	 */
	public Payment(Cart cart) {
		super();
		this.cart = cart;
	}
	
	/**
	 * getter of cart
	 * @return cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * setter of cart
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * calculate change according to cash input
	 * @param cash
	 * @return
	 */
	public double calculateChange(double cash) {
		change =  cash - cart.getRoundTotalPrice();
		return change;
	}
}
