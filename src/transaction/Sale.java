package transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import db.DatabaseController;

public class Sale {
	
	private String itemId;
	private String name;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsSale;
	private DecimalFormat decimalPattern = new DecimalFormat("#.00");


	public String getItemId(){
		return itemId;
	}
	
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getUnitPrice(){
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double subTotalPrice) {
		this.totalPrice = subTotalPrice;
	}
	
	//Get data from database and display at sale table
	public Vector<Sale> displaySales(JTable table, String startDate, 
			String endDate) throws ClassNotFoundException, SQLException {

		//Open database connection
		conn = (Connection) dbController.getConnection();
		
		//Create sql statement;
		sql = "SELECT i.itemId, name, sum(quantity), unitPrice, "
				+ "sum(subTotalPrice) FROM tb_Sale s "
				+ "LEFT JOIN tb_item i ON s.itemId = i.itemId "
				+ "LEFT JOIN tb_receipt r ON s.receiptId = r.receiptId "
				+ "WHERE dateTime BETWEEN '" + startDate + "' "
				+ "AND '" + endDate + "' "
				+ "GROUP BY i.itemId ORDER BY quantity DESC";
		
		//Create statement object
		stmt = conn.createStatement();
		
		//Create result set object
		rsSale = stmt.executeQuery(sql);
		
		// Wrap result in Vector
		Vector<Sale> sales = new Vector<Sale>();
		
		//Get all item name in database.
		while(rsSale.next()){
	
			setItemId(rsSale.getString(1));
			setName(rsSale.getString(2));
			setQuantity(rsSale.getInt(3));
			setUnitPrice(rsSale.getDouble(4));
			setTotalPrice(rsSale.getDouble(5));
			
			DefaultTableModel salesItem = (DefaultTableModel)table.getModel();
			salesItem.addRow(new Object[]{getItemId(), getName(), getQuantity(),
					decimalPattern.format(getUnitPrice()),
					decimalPattern.format(getTotalPrice())});
		}
		
		// Close connection
		conn.close();
		
		// Return vector of ahtletes
		return sales;		
	}
}
