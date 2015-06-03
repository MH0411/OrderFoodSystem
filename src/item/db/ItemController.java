package item.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;

import db.DatabaseController;
import user.User;
import item.Item;

public class ItemController {
	
	private Item item;
	private DatabaseController dbController;
	private Connection conn;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	@SuppressWarnings("null")
	public Vector<Item> selectAllItems() throws SQLException, 
		ClassNotFoundException {
	
		conn = dbController.getConnection();		
		String sql = "select * from tb_item";	
		
		//Create statement object
		Statement stmt = conn.createStatement();
		
		//Create result set object
		ResultSet rsItem = stmt.executeQuery(sql);

		//display result set
		Vector<Item> items  = new Vector<Item>();
		while(rsItem.next()){
			
			Item tempItem = null;
			tempItem.setItemId(rsItem.getString("itemId"));
			tempItem.setName(rsItem.getString("name"));
			items.add(tempItem);
		}
		conn.close();
		return items;
	}
}
