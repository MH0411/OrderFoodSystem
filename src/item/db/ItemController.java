package item.db;

import item.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import db.DatabaseController;

/**
 * This class represent all process between Item class and database
 * @author JKGan
 *
 */
public class ItemController {
	
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsItem;
	private int itemId;
	private String name;
	private double unitPrice;
	Item tempItem = null;

//	public Item getItem() {
//		return item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
//	
	/**
	 * Get all item info from database
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Item> getAllItemsInfo() 
			throws SQLException, ClassNotFoundException {
		
		//Open database connection
		conn = dbController.getConnection();
		
		//Create sql statement;
		sql = "select * from tb_item";	
		
		//Create statement object
		stmt = conn.createStatement();	
		
		//Create result set object
		rsItem = stmt.executeQuery(sql);
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		//Get all item name in database.
		while(rsItem.next()) {
			itemId = rsItem.getInt("itemId");
			name = rsItem.getString("name");
			unitPrice = rsItem.getDouble("unitPrice");
			Item item = new Item(itemId, name, unitPrice);
			items.add(item);
//			itemsComboBox.addItem(item);
		}
		
		//Close database connection
		conn.close();
		
		//Return String to combo box.
//		return itemsComboBox;
		
		return items;
	}
}


