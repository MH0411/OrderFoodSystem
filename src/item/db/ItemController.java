package item.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import db.DatabaseController;
import item.Item;

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
	 * Add items from database to combo box
	 * @param itemsComboBox
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public JComboBox<Item> getItemsInfo(JComboBox<Item> itemsComboBox) 
			throws SQLException, ClassNotFoundException {
		//Open database connection
		conn = dbController.getConnection();
		//Create sql statement;
		sql = "select * from tb_item";	
		//Create statement object
		stmt = conn.createStatement();	
		//Create result set object
		rsItem = stmt.executeQuery(sql);
		//Get all item name in database.
		while(rsItem.next()) {
			itemId = rsItem.getInt("itemId");
			name = rsItem.getString("name");
			unitPrice = rsItem.getDouble("unitPrice");
			Item item = new Item(itemId, name, unitPrice);
//			 itemsComboBox.addItem(new ComboItem(rsItem.getString("itemId"),
//					 rsItem.getString("name").toString(), rsItem.getDouble("unitPrice")));
			itemsComboBox.addItem(item);
			
		}
		//Close database connection
		conn.close();
		//Return String to combo box.
		return itemsComboBox;
	}
}


