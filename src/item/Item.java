package item;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Item {
	
	private String itemId;
	private String name;
	private double unitPrice;
	
	public Item(String itemId, String name, double unitPrice) {
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public Item(String itemId, String name, String unitPrice){
		this.itemId = itemId;
		this.name = name;
		this.unitPrice = Double.parseDouble(unitPrice);
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



}
