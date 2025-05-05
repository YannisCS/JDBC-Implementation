package game.model;

import java.util.Objects;

public class ConsumableItemBonuse {
	private Items item;
	private Statistics statistics;
	private float bonusePercent;
	private int valueCap;
	
	public ConsumableItemBonuse(Items item, Statistics statistics, float bonusePercent, int valueCap) {
		this.item = item;
		this.statistics = statistics;
		this.bonusePercent = bonusePercent;
		this.valueCap = valueCap;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public float getBonusePercent() {
		return bonusePercent;
	}

	public void setBonusePercent(float bonusePercent) {
		this.bonusePercent = bonusePercent;
	}

	public int getValueCap() {
		return valueCap;
	}

	public void setValueCap(int valueCap) {
		this.valueCap = valueCap;
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("hashing not supported");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsumableItemBonuse other = (ConsumableItemBonuse) obj;
		return Float.floatToIntBits(bonusePercent) == Float.floatToIntBits(other.bonusePercent)
				&& Objects.equals(item, other.item) && Objects.equals(statistics, other.statistics)
				&& valueCap == other.valueCap;
	}

	@Override
	public String toString() {
		return String.format(
				"ConsumableItemBonuse [itemID=%d, itemName=%s, statistics=%s, bonusePercent=%s, valueCap=%s]", 
				item.getItemID(),
				item.getItemName(),
				statistics.getStatsName(), 
				bonusePercent, 
				valueCap
		);
	}
	
	
	

}
