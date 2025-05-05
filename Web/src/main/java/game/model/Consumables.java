package game.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Consumables extends Items{
	private String description;
	
	public Consumables(
			int itemID,
			String itemName,
			int level,
			int maxStackSize,
			BigDecimal price,
			String description) {
		super(itemID, itemName, level, maxStackSize, price);
		this.description = description;
	}
    
	//getters and setter
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumables other = (Consumables) obj;
		return Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return String.format(
				"%s %nitemType: Consumables [description=%s]", 
				super.toString(),
				description
				);
	}
	
	

}
