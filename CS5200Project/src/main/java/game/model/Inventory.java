package game.model;

public class Inventory {
	
	private int charID;
	private int slotID;
	private int instance;
	private int quantity;
	public Inventory(int charID, int slotID, int instance, int quantity) {
		super();
		this.charID = charID;
		this.slotID = slotID;
		this.instance = instance;
		this.quantity = quantity;
	}
	public int getCharID() {
		return charID;
	}
	public void setCharID(int charID) {
		this.charID = charID;
	}
	public int getSlotID() {
		return slotID;
	}
	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}
	public int getInstance() {
		return instance;
	}
	public void setInstance(int instance) {
		this.instance = instance;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Inventory [charID=" + charID + ", slotID=" + slotID + ", instance=" + instance + ", quantity="
				+ quantity + "]";
	}

}