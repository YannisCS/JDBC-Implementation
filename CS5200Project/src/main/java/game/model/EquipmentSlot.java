package game.model;

public class EquipmentSlot {
	
	private String bodyPartName;

	public EquipmentSlot(String bodyPartName) {
		super();
		this.bodyPartName = bodyPartName;
	}

	public String getBodyPartName() {
		return bodyPartName;
	}

	public void setBodyPartName(String bodyPartName) {
		this.bodyPartName = bodyPartName;
	}

	@Override
	public String toString() {
		return "EquipmentSlot [bodyPartName=" + bodyPartName + "]";
	}

}