package transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import db.DatabaseController;

public class Sale {
	
	private String saleId;
	private String itemId;
	private String name;
	private String receiptId;
	private int quantity;
	private double subTotalPrice;
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsSale;
	
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
	
	//Get data from database and display at sale table
	public Vector<Sale> displaySales(JTable table) 
			throws ClassNotFoundException, SQLException {

		//Open database connection
		conn = (Connection) dbController.getConnection();
		//Create sql statement;
		sql = "SELECT name, sum(quantity), sum(subTotalPrice) FROM tb_Sale s "
				+ "LEFT JOIN tb_item i ON s.itemId = i.itemId "
				+ "LEFT JOIN tb_receipt r ON s.receiptId = r.receiptId "
				+ "WHERE dateTime = '2015-06-10 09:29:15'"
				+ "GROUP BY name ORDER BY quantity DESC";
		
		//Create statement object
		stmt = conn.createStatement();	
		//Create result set object
		rsSale = stmt.executeQuery(sql);
		// Wrap result in Vector
		Vector<Sale> sales = new Vector<Sale>();
		//Get all item name in database.
		while(rsSale.next()){
	
			setName(rsSale.getString(1));
			setQuantity(rsSale.getInt(2));
			setSubTotalPrice(rsSale.getDouble(3));
			
			DefaultTableModel item = (DefaultTableModel)table.getModel();
			item.addRow(new Object[]{getName(), getQuantity(),
					getSubTotalPrice()});
		}
		
		// Close connection
		conn.close();
		
		// Return vector of ahtletes
		return sales;		
	}
	

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
