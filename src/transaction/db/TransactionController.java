package transaction.db;

import item.Item;
import item.OrderedItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import transaction.Sale;
import user.User;

import com.mysql.jdbc.Connection;

import db.DatabaseController;

/**
 * This class represent controller to control the connection and process
 * between Item and database.
 * @author JKGan
 *
 */
public class TransactionController {
	
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsSale;
	
	/**
	 * Get sales data from database between startDate and endDate 
	 * @param table
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Vector<Sale> getSales(String startDate, 
			String endDate) throws ClassNotFoundException, SQLException {

		//Open database connection
		conn = (Connection) dbController.getConnection();
		
		//Create sql statement;
		sql = "SELECT i.itemId, name, sum(quantity), unitPrice, "
				+ "sum(subTotalPrice) FROM tb_sale s "
				+ "LEFT JOIN tb_item i ON s.itemId = i.itemId "
				+ "LEFT JOIN tb_receipt r ON s.receiptId = r.receiptId "
				+ "WHERE dateTime BETWEEN '" + startDate + "' "
				+ "AND '" + endDate + "' "
				+ "GROUP BY i.itemId ORDER BY sum(quantity) DESC";
		
		//Create statement object
		stmt = conn.createStatement();
		
		//Create result set object
		rsSale = stmt.executeQuery(sql);
		
		// Wrap result in Vector
		Vector<Sale> sales = new Vector<Sale>();
		
		//Get all item name in database and store in sales
		while(rsSale.next()){
	
			Sale sale = new Sale();
			sale.setItemId(rsSale.getString(1));
			sale.setName(rsSale.getString(2));
			sale.setQuantity(rsSale.getInt(3));
			sale.setUnitPrice(rsSale.getDouble(4));
			sale.setTotalPrice(rsSale.getDouble(5));
			sales.add(sale);

		}
		
		// Close connection
		conn.close();
		
		// Return vector of sale
		return sales;		
	}
	
	/**
	 * Method to save receipt details into database
	 * @param totalPrice
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertReceiptData(double totalPrice )
			throws SQLException, ClassNotFoundException {
		
		//Open connection
		conn = (Connection) dbController.getConnection();
		
		sql = "INSERT INTO tb_receipt (totalPrice) VALUES (?)";
		
		
		PreparedStatement psReceipt =conn.prepareStatement(sql);
		
		psReceipt.setDouble(1, totalPrice);
		
		//Execute query
		psReceipt.executeUpdate();
		
		//Close
		conn.close();
	}
	
	/**
	 * Method to get previous receipt data
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<OrderedItem> getReceiptData() throws SQLException,
		ClassNotFoundException {
		
		ArrayList<OrderedItem> items = new ArrayList<OrderedItem>();
		
		conn = (Connection) dbController.getConnection();
		//Create sql query
		sql = "SELECT MAX(receiptId) FROM tb_receipt";
		
		stmt = conn.createStatement();	
		
		//Create result set object
		ResultSet rsReceipt = stmt.executeQuery(sql);
		
		//Get current receipt id
		int maxReceiptId = 0;
		if (rsReceipt.next()) {
			maxReceiptId = rsReceipt.getInt(1);
		} else {
			maxReceiptId = 1;
		}
		
		String sql = "SELECT i.itemId, name, quantity, unitPrice, subTotalPrice"
				+ " FROM tb_sale s LEFT JOIN tb_item i ON s.itemId = i.itemId "
				+ "WHERE s.receiptId = '" + maxReceiptId + "'";
				
		//Create statement object
		Statement stmt = conn.createStatement();

		//Create result set object
		ResultSet rsSale = stmt.executeQuery(sql);

		//display result set
		while (rsSale.next()) {
		
			OrderedItem orderedItem = new OrderedItem(rsSale.getInt("i.itemId"),
											rsSale.getString("name"),
											rsSale.getInt("quantity"),
											rsSale.getDouble("unitPrice"),
											rsSale.getDouble("subTotalPrice"));
			items.add(orderedItem);
		}
		return items;
	}
	
	/**
	 * Method to save sale details into database
	 * @param cartItem
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertSaleData(Item cartItem) 
			throws SQLException, ClassNotFoundException {
		
		//Open connection
		conn = (Connection) dbController.getConnection();
		
		//Create sql query
		sql = "SELECT MAX(receiptId) FROM tb_receipt";
		
		stmt = conn.createStatement();	
		
		//Create result set object
		ResultSet rsReceipt = stmt.executeQuery(sql);
		
		//Get current receipt id
		int maxReceiptId = 0;
		if (rsReceipt.next()) {
			maxReceiptId = rsReceipt.getInt(1);
		} else {
			maxReceiptId = 1;
		}
		
		//Create sql query
		sql = "INSERT INTO tb_sale (itemId, receiptId,"
				+ "quantity, subTotalPrice)"
				+ " VALUES (?, ?, ?, ?)";
		
		PreparedStatement psSale = conn.prepareStatement(sql);
		
		//Insert to sale table
		psSale.setInt(1, cartItem.getItemId());
		psSale.setInt(2, maxReceiptId);
		psSale.setInt(3, cartItem.getQuantity());
		psSale.setDouble(4, cartItem.getSubTotalPrice());
		
		psSale.executeUpdate();
		
		//Close
		conn.close();
	}

}
