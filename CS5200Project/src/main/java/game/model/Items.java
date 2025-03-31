package game.model;

public class Items {
	
	private int itemID;
	private String itemName;
	private int level;
	private int maxStackSize;
	
	public Items(int itemID, String itemName, int level, int maxStackSize) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.level = level;
		this.maxStackSize = maxStackSize;
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

	@Override
	public String toString() {
		return "Items [itemID=" + itemID + ", itemName=" + itemName + ", level=" + level + ", maxStackSize="
				+ maxStackSize + "]";
	}
	
	

}
