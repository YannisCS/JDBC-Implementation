package game.model;

import java.math.BigDecimal;

public class Equipments extends Items {
	
	private int requiredLevel;
	
	public Equipments (
			int itemID,
			String itemName,
			int level,
			int maxStackSize,
			BigDecimal price,
			int requiredLevel
			) {
		super(itemID, itemName, level, maxStackSize, price);
		this.requiredLevel = requiredLevel;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}
	
	public void setRequiredLevel(int level) {
		this.requiredLevel = level;
	}
	
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Equipments that = (Equipments) o;
    return requiredLevel == that.requiredLevel;
  }
  
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("hashing not supported");
  }
  
  @Override
  public String toString() {
    return String.format(
      "Equipment: [%s, required level=%d]",
      super.toString(),
      requiredLevel
    );
  }

}
