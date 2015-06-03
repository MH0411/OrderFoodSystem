package item.db;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import db.DatabaseController;
import user.User;
import item.Item;

public class ItemController {
	
	private Item item;
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsItem;
	Item tempItem = null;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public JComboBox<ComboItem> fillComboBox(JComboBox<ComboItem> itemsComboBox) 
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
		while(rsItem.next()){
			 itemsComboBox.addItem(new ComboItem(rsItem.getString("itemId"),
					 rsItem.getString("name"), rsItem.getString("unitPrice")));
		}
		//Close database connection
		conn.close();
		//Return String to combo box.
		return itemsComboBox;
	}

	public JTextField actionPerformed(ActionEvent arg0,
			JComboBox<String> itemsComboBox, JTextField unitPriceTextField) 
			throws ClassNotFoundException, SQLException {
		
		//Open database connection
		conn = dbController.getConnection();
		//Create sql statement;
		sql = "select * from tb_item WHERE name = ?";	
		//Create statement object
		stmt = conn.prepareStatement(sql);
		((PreparedStatement) stmt).setString(1,(String)itemsComboBox.getSelectedItem());
		//Create result set object
		rsItem = stmt.executeQuery(sql);
		//Get all item name in database.
		while(rsItem.next()){
			unitPriceTextField.setText(rsItem.getString("unitPrice"));
		}
		//Close database connection
		conn.close();
		//Return String to combo box.
		return unitPriceTextField;
	}
}
