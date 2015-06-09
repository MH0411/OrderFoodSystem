package transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.jdbc.Connection;

import db.DatabaseController;

public class Sale {
	
	private String saleId;
	private String itemId;
	private String receiptId;
	private int quantity;
	private double subTotalPrice;
	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
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

	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsSale;
	
	
	//trying get data from database and display at sale table
	public Vector<Sale> displaySales() 
			throws ClassNotFoundException, SQLException {

		//Open database connection
		conn = (Connection) dbController.getConnection();
		//Create sql statement;
		sql = "select * from tb_Sale";	
		//Create statement object
		stmt = conn.createStatement();	
		//Create result set object
		rsSale = stmt.executeQuery(sql);
		// Wrap result in Vector
		Vector<Sale> sales = new Vector<Sale>();
		//Get all item name in database.
		while(rsSale.next()){
	
			// Create temporary object and set the values
			Sale sale = new Sale();
			sale.setSaleId(rsSale.getString(1));
			sale.setItemId(rsSale.getString(2));
			sale.setReceiptId(rsSale.getString(4));
			sale.setQuantity(rsSale.getInt(3));
			sale.setSubTotalPrice(rsSale.getDouble(5));
			
			// add into vector
			sales.add(sale);
			
			System.out.println(sale.getSaleId());
			System.out.println(sale.getItemId());
			System.out.println(sale.getReceiptId());
			System.out.println(sale.getQuantity());
			System.out.println(sale.getSubTotalPrice());
		}
		
		// Close connection
		conn.close();
		
		// Return vector of ahtletes
		return sales;
		
	}
	
}
