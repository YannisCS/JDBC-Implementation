package game.model;

import java.util.Objects;

public class EquipmentBonuse {
	
	private Equipments equipment;
	private Statistics statistics;
	private int value;
	
	public EquipmentBonuse (
			Equipments equipment,
			Statistics statistics,
			int value
			) {
		this.equipment = equipment;
		this.statistics = statistics;
		this.value = value;
	}
	
	public Equipments getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Equipments equipment) {
		this.equipment = equipment;
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
    		Objects.equals(equipment, that.equipment)
    		&& Objects.equals(statistics, that.statistics)
    		&& value == that.value;
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("hashing not supported");
  }

  @Override
  public String toString() {
    return String.format("Equipment Bonuse: [%s]", fieldsToString());
  }

  protected String fieldsToString() {
    return String.format(
      "%s, %s, value=%d",
      equipment,
      statistics,
      value
    );
  }
}
