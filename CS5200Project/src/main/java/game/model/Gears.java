package game.model;

import java.math.BigDecimal;

public class Gears extends Equipments {
	
	public Gears (
			int itemID,
			String itemName,
			int level,
			int maxStackSize,
			BigDecimal price,
			int requiredLevel
			) {
		super(itemID, itemName, level, maxStackSize, price, requiredLevel);
	}
  
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("hashing not supported");
  }
  
  @Override
  public String toString() {
    return String.format(
      "Gear: [%s]",
      super.toString()
    );
  }

}
