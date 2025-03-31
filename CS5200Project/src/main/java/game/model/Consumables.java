package game.model;

import java.math.BigDecimal;

public class Consumables extends Items{
	private String description;
	
	public Consumables(
			int itemID,
			String itemName,
			int level,
			int maxStackSize,
			double price,
			String description) {
		super(itemID, itemName, level, maxStackSize, price);
		this.description = description;
	}
	
	//getters and setter
	
	//hashCode and equals
	
	//toString

}
