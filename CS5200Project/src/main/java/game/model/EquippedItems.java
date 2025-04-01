package game.model;

public class EquippedItems {
	
	private int charID;
	private String equipPosition;
	private int itemID;
	public EquippedItems(int charID, String equipPosition, int itemID) {
		super();
		this.charID = charID;
		this.equipPosition = equipPosition;
		this.itemID = itemID;
	}
	public int getCharID() {
		return charID;
	}
	public void setCharID(int charID) {
		this.charID = charID;
	}
	public String getEquipPosition() {
		return equipPosition;
	}
	public void setEquipPosition(String equipPosition) {
		this.equipPosition = equipPosition;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	@Override
	public String toString() {
		return "EquippedItems [charID=" + charID + ", equipPosition=" + equipPosition + ", itemID=" + itemID + "]";
	}
}
