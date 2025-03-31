package game.model;

import java.util.Objects;

public class Weapons extends Equipments {
	
	private String wearableJob;
	private int damage;
	
	public Weapons (
			int itemID,
			String itemName,
			int level,
			int maxStackSize,
			double price,
			int requiredLevel,
			String wearableJob,
			int damage
			) {
		super(itemID, itemName, level, maxStackSize, price, requiredLevel);
		this.wearableJob = wearableJob;
		this.damage = damage;
	}
	
	public String getWearableJob() {
		return wearableJob;
	}
	
	public void setWearableJob(String job) {
		this.wearableJob = job;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
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
    Weapons that = (Weapons) o;
    return Objects.equals(wearableJob, that.wearableJob)
    		&& damage == that.damage;
  }
  
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("hashing not supported");
  }
  
  @Override
  public String toString() {
    return String.format(
      "Equipment(%s, %s, %d)",
      super.fieldsToString(),
      wearableJob,
      damage
    );
  }

}
