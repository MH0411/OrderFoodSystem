package transaction.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import transaction.Sale;

import com.mysql.jdbc.Connection;

import db.DatabaseController;

public class TransactionController {
	
	private DatabaseController dbController = new DatabaseController();
	private Connection conn;
	private String sql;
	private Statement stmt;
	private ResultSet rsSale;
	private DecimalFormat decimalPattern = new DecimalFormat("#.00");
	
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
	
			Sale sale = new Sale();
			sale.setItemId(rsSale.getString(1));
			sale.setName(rsSale.getString(2));
			sale.setQuantity(rsSale.getInt(3));
			sale.setUnitPrice(rsSale.getDouble(4));
			sale.setTotalPrice(rsSale.getDouble(5));
			sales.add(sale);
			
			DefaultTableModel salesItem = (DefaultTableModel)table.getModel();
			salesItem.addRow(new Object[]{sale.getItemId(), sale.getName(),
					sale.getQuantity(),
					decimalPattern.format(sale.getUnitPrice()),
					decimalPattern.format(sale.getTotalPrice())});
		}
		
		// Close connection
		conn.close();
		
		// Return vector of ahtletes
		return sales;		
	}
}
