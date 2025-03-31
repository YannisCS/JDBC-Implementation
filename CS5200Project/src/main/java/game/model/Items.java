package game.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Items {
	
	private int itemID;
	private String itemName;
	private int level;
	private int maxStackSize;
	private BigDecimal price;
	
	public Items(int itemID, String itemName, int level, int maxStackSize, BigDecimal price) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.level = level;
		this.maxStackSize = maxStackSize;
		this.price = price;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxStackSize() {
		return maxStackSize;
	}

	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("hashing not supported");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return itemID == other.itemID && Objects.equals(itemName, other.itemName) && level == other.level
				&& maxStackSize == other.maxStackSize && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return String.format(
				"Items [itemID=%s, itemName=%s, level=%s, maxStackSize=%s, price=%s]", 
				itemID, 
				itemName,
				level, 
				maxStackSize, 
				price);
	}

}
