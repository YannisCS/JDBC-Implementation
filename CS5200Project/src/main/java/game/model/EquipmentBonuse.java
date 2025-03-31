package game.model;

import java.util.Objects;

public class EquipmentBonuse {
	
	private int equipmentID;
	private Statistics statistics;
	private int value;
	
	public EquipmentBonuse (
			int equipmentID,
			Statistics statistics,
			int value
			) {
		this.equipmentID = equipmentID;
		this.statistics = statistics;
		this.value = value;
	}
	
	public int getEquipmentID() {
		return equipmentID;
	}
	
	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}
	
	public Statistics getStatistics() {
		return statistics;
	}
	
	public void setStatistics(Statistics stats) {
		this.statistics = stats;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentBonuse that = (EquipmentBonuse) o;
    return
    		equipmentID == that.equipmentID
    		&& Objects.equals(statistics, that.statistics)
    		&& value == that.value;
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("hashing not supported");
  }

  @Override
  public String toString() {
    return String.format("Persons(%s)", fieldsToString());
  }

  protected String fieldsToString() {
    return String.format(
      "Equipment Bonuse(%s, %s, %d)",
      equipmentID,
      statistics,
      value
    );
  }
}
